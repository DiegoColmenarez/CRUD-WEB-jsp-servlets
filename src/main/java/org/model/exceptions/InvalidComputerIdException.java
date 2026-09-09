package org.model.exceptions;

public class InvalidComputerIdException extends DomainException {
    public InvalidComputerIdException(String message) {
        super(message);
    }

    private static final String MESSAGE_INVALID = "Computer ID is invalid, it must be greater than 0";

    public static InvalidComputerIdException becauseIdIsInvalid() {
        return new InvalidComputerIdException(MESSAGE_INVALID);
    }
}