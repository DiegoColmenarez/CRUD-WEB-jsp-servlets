package org.model.exceptions;

public class InvalidUserIdException extends DomainException{
    public InvalidUserIdException(String message) {
        super(message);
    }

    private static String MESSAGE_INVALID_ID = "The ID is invalid, because is a negative number";

    public static InvalidUserIdException becauseIdIsInvalid(){
        return new InvalidUserIdException(MESSAGE_INVALID_ID);
    }
}
