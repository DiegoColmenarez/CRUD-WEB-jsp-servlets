package org.model.exceptions;

public class InvalidUserIdException extends DomainException{
    public InvalidUserIdException(String message) {
        super(message);
    }

    private static String MESSAGE_INVALID_ID = "The ID is invalid, because is a negative number";
    private static String MESSAGE_EXIST_ID = "The ID is invalid, because alredy exist";

    public static InvalidUserIdException becauseIdAlredyExist(){
        return new InvalidUserIdException(MESSAGE_EXIST_ID);
    }

    public static InvalidUserIdException becauseIdAIsInvalid(){
        return new InvalidUserIdException(MESSAGE_INVALID_ID);
    }
}
