package org.model.repository;

import org.model.config.ConnectionFactory;
import org.model.entity.User;
import org.model.vo.UserEmail;
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
            statement.setString(1, String.valueOf(user.getName()));
            statement.setString(2,String.valueOf(user.getLastName()));
            statement.setString(3, String.valueOf(user.getEmail()));
            statement.setString(4, String.valueOf(user.getPassword()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
