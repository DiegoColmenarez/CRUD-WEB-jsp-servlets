package org.model.repository;

import org.model.config.ConnectionFactory;
import org.model.vo.PasswordResetCode;
import org.model.vo.UserId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
}
