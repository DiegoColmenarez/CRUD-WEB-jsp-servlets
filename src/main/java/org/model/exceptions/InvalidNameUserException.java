package org.model.exceptions;

public class InvalidNameUserException extends DomainException{
    public InvalidNameUserException(String message) {
        super(message);
    }

    private static String MESSAGE_INVALID = "The name is invalid";
    private static String MESSAGE_INVALID_EMPTY = "The name is empty";

    public static InvalidNameUserException becauseContainsInvalidCharacters(){
        return new InvalidNameUserException(MESSAGE_INVALID);
    }

    public InvalidNameUserException becauseIsEmpty(){
        return new InvalidNameUserException(MESSAGE_INVALID_EMPTY);
    }
}
