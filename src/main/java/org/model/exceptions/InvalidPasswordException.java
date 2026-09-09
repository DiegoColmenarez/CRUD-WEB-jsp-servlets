package org.model.exceptions;

public class InvalidPasswordException extends DomainException{
    public InvalidPasswordException(String message) {
        super(message);
    }

    private static final String MESSAGE_INVALID = "The password is invalid, it's empty";
    private static final String MESSAGE_INVALID_FORMAT = "The password is invalid," +
            " The password must contain at least: a special character, a number, a lowercase letter, " +
            "and an uppercase letter. It cannot contain spaces.";

    public static InvalidPasswordException becauseIsEmpty(){
        throw new InvalidPasswordException(MESSAGE_INVALID);
    }

    public static InvalidPasswordException becauseFormatIsInvalid(){
        throw new InvalidPasswordException(MESSAGE_INVALID_FORMAT);
    }
}
