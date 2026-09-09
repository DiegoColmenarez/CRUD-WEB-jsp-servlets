package org.model.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final Properties DB_PROPERTIES;
    private static final String DB_URL;

    static {
        DB_PROPERTIES = ConnectionConfig.loadDataBaseConfig();
        DB_URL = DB_PROPERTIES.getProperty("DB_URL");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver PostgreSQL no encontrado", e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_PROPERTIES);
    }
}