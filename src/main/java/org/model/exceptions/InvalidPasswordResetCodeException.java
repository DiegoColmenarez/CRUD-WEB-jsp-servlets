package org.model.exceptions;

public class InvalidPasswordResetCodeException extends DomainException {
    public InvalidPasswordResetCodeException(String message) {
        super(message);
    }
    private static final String MESSAGE_CODE_NULL = "Reset code is invalid. Code is Null";
    private static final String MESSAGE_CODE_EMPTY = "Reset code is invalid, it cannot be empty";
    private static final String MESSAGE_FORMAT_INVALID = "Reset code format is invalid, must be 6 digits";
    private static final String MESSAGE_EXPIRED = "Reset code has expired, please request a new one";
    private static final String MESSAGE_ALREADY_USED = "Reset code has already been used";
    private static final String MESSAGE_NOT_FOUND = "Reset code is invalid";


}