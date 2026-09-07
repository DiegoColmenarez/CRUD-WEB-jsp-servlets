package org.model.repository;

import org.model.config.ConnectionFactory;
import org.model.entity.User;
import org.model.exceptions.InvalidEmailUserException;
import org.model.vo.UserEmail;
import org.model.vo.UserId;
import org.model.vo.UserName;
import org.model.vo.UserPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    public void insertUser(User user) {
        String sql = "INSERT INTO users (nombre, apellido, email, password) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName().value());
            statement.setString(2, user.getLastName().value());
            statement.setString(3, user.getEmail().value());
            statement.setString(4, user.getPassword().value());
            statement.executeUpdate();
        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                throw InvalidEmailUserException.becauseEmailAlredy();
            }
            throw RepositoryException.repositoryGeneralException(e.getCause());
        }
    }

    public void deleteUser(UserId id) {
        String sql = "DELETE FROM users WHERE id = ?";
        int rowsAffect = 0;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id.value());
            rowsAffect = statement.executeUpdate();
            if (rowsAffect == 0) {
               throw UserNotFoundException.becauseIdDoesExist(id);
            }
        } catch (SQLException e) {
            throw RepositoryException.repositoryGeneralException(e.getCause());
        }
    }

    public void updateUser(User user) {
        String sql = "UPDATE users SET nombre = ?, apellido = ?, email = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName().value());
            stmt.setString(2, user.getLastName().value());
            stmt.setString(3, user.getEmail().value());
            stmt.setInt(4, user.getId().value());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw UserNotFoundException.becauseIdDoesExist(user.getId());
            }
        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                throw InvalidEmailUserException.becauseEmailAlredy();
            }
            throw RepositoryException.repositoryGeneralException(e.getCause());
        }
    }
}
