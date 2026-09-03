package org.model.exceptions;

public class InvalidNameUserException extends DomainException{
    public InvalidNameUserException(String message) {
        super(message);
    }

    private static String MESSAGE_INVALID = "The name is invalid";

    public static InvalidNameUserException beacuseIsNotString(){
        return new InvalidNameUserException(MESSAGE_INVALID);
    }
}
