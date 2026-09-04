package org.model.exceptions;

public class InvalidPasswordException extends DomainException{
    public InvalidPasswordException(String message) {
        super(message);
    }

    private static final String MESSAGE_INVALID = "The password is invalid, it's empty";

    public InvalidPasswordException becauseIsEmpty(){
        throw new InvalidPasswordException(MESSAGE_INVALID);
    }
}
