package org.model.exceptions;

public class InvalidEmailUserException extends DomainException {
    public InvalidEmailUserException(String message) {
        super(message);
    }

    private static final String MESSAGE_INVALID = "Email is Invalid, it's not a Email";
    private static final String MESSAGE_INVALID_EMPTY = "Email is Invalid, It's empty.";
    private static final String MESSAGE_EMAIL_EXIST = "Email is Invalid, This email is already registered.";
    public static InvalidEmailUserException becauseFormatIsInvalid(){
        return new InvalidEmailUserException(MESSAGE_INVALID);
    }

    public static InvalidEmailUserException becauseIsEmpty(){
        return new InvalidEmailUserException(MESSAGE_INVALID_EMPTY);
    }

    public static InvalidEmailUserException becauseEmailAlredy(){
        return new InvalidEmailUserException(MESSAGE_EMAIL_EXIST);
    }
}
