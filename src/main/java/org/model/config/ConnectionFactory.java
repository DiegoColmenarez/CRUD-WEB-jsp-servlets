package org.model.config;

import java.util.Properties;

public class ConnectionFactory {
    private static final Properties DB_PROPERTIES;
    private static final String DB_URL;

    static {
        DB_PROPERTIES = ConnectionConfig.loadDataBaseConfig();
        DB_URL = DB_PROPERTIES.getProperty("DB_URL");
    }

}
