package org.model.exceptions;

public class InvalidTypeUserException extends DomainException{
    public InvalidTypeUserException(String message) {
        super(message);
    }

    private static final String MESSAGE_INVALID = "User type is invalid";
    private static final String MESSAGE_INVALID_EMPTY = "User type is invalid, it's empty";

    public static InvalidTypeUserException becauseValueIsInvalid(){
        return new InvalidTypeUserException(MESSAGE_INVALID);
    }

    public static InvalidTypeUserException becauseIsEmpty(){
        return new InvalidTypeUserException(MESSAGE_INVALID_EMPTY);
    }
}