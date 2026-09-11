package org.model.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoaderSmtp {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = PropertiesLoaderSmtp.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new IllegalStateException("application.properties not found in classpath");
            }
            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Error loading application.properties", e);
        }
    }

    public static String get(String key) {
        String value = PROPERTIES.getProperty(key);
        if (value == null) {
            throw new IllegalStateException("Property not found: " + key);
        }
        return value;
    }

    public static String get(String key, String defaultValue) {
        return PROPERTIES.getProperty(key, defaultValue);
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }
}