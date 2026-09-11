package org.model.repository;

import org.model.config.ConnectionFactory;
import org.model.vo.PasswordResetCode;
import org.model.vo.UserId;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class PasswordResetRepository {

    public void saveResetCode(UserId userId, PasswordResetCode code, LocalDateTime expiresAt) {
        String sql = "INSERT INTO password_reset_tokens (user_id, code, expires_at) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId.value());
            statement.setString(2, code.value());
            statement.setTimestamp(3, Timestamp.valueOf(expiresAt));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw RepositoryException.repositoryGeneralException(e);
        }
    }

    public Optional<Integer> findUserIdByValidCode(PasswordResetCode code) {
        String sql = "SELECT user_id FROM password_reset_tokens " +
                "WHERE code = ? AND used = FALSE AND expires_at > NOW() " +
                "ORDER BY created_at DESC LIMIT 1";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, code.value());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(resultSet.getInt("user_id"));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw RepositoryException.repositoryGeneralException(e);
        }
    }
}
