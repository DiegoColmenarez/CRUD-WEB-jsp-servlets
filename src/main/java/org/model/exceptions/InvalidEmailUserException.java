package org.model.exceptions;

public class InvalidEmailUserException extends RuntimeException {
    public InvalidEmailUserException(String message) {
        super(message);
    }

    private static final String MESSAGE_INVALID = "Email is Invalid";

    public static InvalidEmailUserException becauseFormatIsInvalid(){
        return new InvalidEmailUserException(MESSAGE_INVALID);
    }
}
