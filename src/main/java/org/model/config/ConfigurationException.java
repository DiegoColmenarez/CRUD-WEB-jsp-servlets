package org.model.config;

public class ConfigurationException extends RuntimeException {
    public ConfigurationException(String message) {
        super(message);
    }
    private ConfigurationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    private static final String MESSAGE_NULL_ARGUMENT = "The configuration failed, Configuration file not found.";
    private static final String MESSAGE_NO_PERMISSIONS = "The configuration failed, lack of operating system permissions.";

    public static ConfigurationException becauseNullArgument(){
        return new ConfigurationException(MESSAGE_NULL_ARGUMENT);
    }

    public static ConfigurationException becauseNoPermissions(final Throwable cause){
        return new ConfigurationException(MESSAGE_NO_PERMISSIONS, cause);
    }
}
