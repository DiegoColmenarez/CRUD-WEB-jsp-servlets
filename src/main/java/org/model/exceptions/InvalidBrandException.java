package org.model.exceptions;

public class InvalidBrandException extends DomainException {
    public InvalidBrandException(String message) {
        super(message);
    }

    private static final String MESSAGE_EMPTY = "Brand is invalid, it cannot be empty";
    private static final String MESSAGE_LENGTH_INVALID = "Brand is invalid, length must be between 2 and 50 characters";

    public static InvalidBrandException becauseIsEmpty() {
        return new InvalidBrandException(MESSAGE_EMPTY);
    }

    public static InvalidBrandException becauseLengthIsInvalid() {
        return new InvalidBrandException(MESSAGE_LENGTH_INVALID);
    }
}