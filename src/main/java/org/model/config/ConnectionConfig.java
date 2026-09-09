package org.model.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionConfig {

    public static Properties loadDataBaseConfig(){
        Properties properties = new Properties();
        String fileName = "config.properties";

        try (InputStream inputStream = ConnectionConfig.class.getClassLoader().getResourceAsStream(fileName)){
            if (inputStream == null){
                throw ConfigurationException.becauseNullArgument();
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw ConfigurationException.becauseNoPermissions(e);
        }
        return properties;
    }
}