package org.model.exceptions;

public class InvalidComputerIdException extends DomainException {
    public InvalidComputerIdException(String message) {
        super(message);
    }

    private static final String MESSAGE_ID_NULL = "Computer ID is invalid. ID is Null";
    private static final String MESSAGE_ID_INVALID = "Computer ID is invalid, it must be greater than 0";

    public static InvalidComputerIdException becauseIdIsNull() {
        return new InvalidComputerIdException(MESSAGE_ID_NULL);
    }

    public static InvalidComputerIdException becauseIdIsInvalid() {
        return new InvalidComputerIdException(MESSAGE_ID_INVALID);
    }
}