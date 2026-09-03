package org.model.exceptions;

public class InvalidTypeUserException extends DomainException{
    public InvalidTypeUserException(String message) {
        super(message);
    }

    private static final String MESSAGE_INVALID = "User type is invalid";

    public static InvalidTypeUserException becauseValueIsInvalid(){
        return new InvalidTypeUserException(MESSAGE_INVALID);
    }

}
