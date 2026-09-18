package org.model.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final Properties DB_PROPERTIES;
    private static final String DB_URL;

    static {
        DB_PROPERTIES = new Properties();

        String envUrl = System.getenv("DB_URL");
        String envUser = System.getenv("DB_USER");
        String envPassword = System.getenv("DB_PASSWORD");

        if (envUrl != null && !envUrl.isEmpty()) {
            DB_URL = envUrl;
            DB_PROPERTIES.setProperty("user", envUser);
            DB_PROPERTIES.setProperty("password", envPassword);
        } else {
            Properties localProps = ConnectionConfig.loadDataBaseConfig();
            DB_URL = localProps.getProperty("DB_URL");
            DB_PROPERTIES.setProperty("user", localProps.getProperty("user"));
            DB_PROPERTIES.setProperty("password", localProps.getProperty("password"));
        }

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