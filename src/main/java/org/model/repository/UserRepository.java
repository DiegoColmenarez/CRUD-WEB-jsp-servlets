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

    public void insertUser(User user){
        String sql = "INSERT INTO users (nombre, apellido, email, password) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, user.getName().value());
            statement.setString(2, user.getLastName().value());
            statement.setString(3, user.getEmail().value());
            statement.setString(4, user.getPassword().value());
            statement.executeUpdate();
        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())){
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
                throw new RuntimeException("No se afectaron filas");
            }
        } catch (SQLException e) {
            throw RepositoryException.repositoryGeneralException(e.getCause());
        }
    }
}
