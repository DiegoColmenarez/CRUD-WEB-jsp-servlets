package org.model.exceptions;

public class InvalidMemoryException extends DomainException {
    public InvalidMemoryException(String message) {
        super(message);
    }

    private static final String MESSAGE_TECHNOLOGY_NULL = "RAM technology is invalid. Technology is Null";
    private static final String MESSAGE_CAPACITY_NULL = "RAM capacity is invalid. Capacity is Null";
    private static final String MESSAGE_CAPACITY_EMPTY = "RAM capacity is invalid, it cannot be empty";
    private static final String MESSAGE_CAPACITY_FORMAT_INVALID = "RAM capacity format is invalid, expected format: 16GB";

    public static InvalidMemoryException becauseTechnologyIsNull() {
        return new InvalidMemoryException(MESSAGE_TECHNOLOGY_NULL);
    }

    public static InvalidMemoryException becauseCapacityIsNull() {
        return new InvalidMemoryException(MESSAGE_CAPACITY_NULL);
    }

    public static InvalidMemoryException becauseCapacityIsEmpty() {
        return new InvalidMemoryException(MESSAGE_CAPACITY_EMPTY);
    }

    public static InvalidMemoryException becauseCapacityFormatIsInvalid() {
        return new InvalidMemoryException(MESSAGE_CAPACITY_FORMAT_INVALID);
    }
}