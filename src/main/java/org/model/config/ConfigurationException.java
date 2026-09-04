package org.model.config;

public class ConfigurationException extends RuntimeException {
    public ConfigurationException(String message) {
        super(message);
    }
    private ConfigurationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    private final String MESSAGE_NULL_ARGUMENT = "The configuration failed, Configuration file not found.";
    private final String MESSAGE_NO_PERMISSIONS = "The configuration failed, lack of operating system permissions.";

}
