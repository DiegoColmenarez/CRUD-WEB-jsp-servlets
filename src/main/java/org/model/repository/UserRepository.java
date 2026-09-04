package org.model.repository;

import org.model.config.ConnectionFactory;
import org.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

//    public void insertUser(User user){
//        String sql = "INSERT INTO users (nombre, apellido, email, password) VALUES (?, ?, ?, ?)";
//        try (Connection connection = ConnectionFactory.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)){
//            statement.setString(1, String.valueOf(user.getName()));
//            statement.setString(2,String.valueOf(user.getLastName()));
//            statement.setString(3, String.valueOf(user.getEmail()));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
