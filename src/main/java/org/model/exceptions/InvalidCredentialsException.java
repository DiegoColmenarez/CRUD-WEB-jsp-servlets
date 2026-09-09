package org.model.exceptions;

public class InvalidCredentialsException extends DomainException {
    public InvalidCredentialsException(String message) {
        super(message);
    }

    public final static String MESSAGE_INVALID_CREDENTIAL = "The crendential is incorrect";

    public static InvalidCredentialsException becauseCrendentialInvalid(){
        return new InvalidCredentialsException(MESSAGE_INVALID_CREDENTIAL);
    }
}
