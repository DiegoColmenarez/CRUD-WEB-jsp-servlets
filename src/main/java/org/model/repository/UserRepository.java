package org.model.repository;

import org.model.config.ConnectionFactory;
import org.model.entity.User;
import org.model.exceptions.InvalidEmailUserException;

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
            throw new RuntimeException(e);
        }
    }
}
