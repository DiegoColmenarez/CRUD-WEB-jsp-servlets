package org.model.exceptions;

public class InvalidPasswordResetCodeException extends DomainException {
    public InvalidPasswordResetCodeException(String message) {
        super(message);
    }
}