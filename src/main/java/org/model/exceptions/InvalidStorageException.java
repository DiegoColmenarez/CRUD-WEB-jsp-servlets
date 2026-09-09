package org.model.exceptions;

public class InvalidStorageException extends DomainException {
    public InvalidStorageException(String message) {
        super(message);
    }

    private static final String MESSAGE_TECHNOLOGY_INVALID = "Storage technology is invalid";
    private static final String MESSAGE_CAPACITY_INVALID = "Storage capacity is invalid";
    private static final String MESSAGE_CAPACITY_INVALID2 = "Storage capacity is invalid. Capacity is Null";
    private static final String MESSAGE_CAPACITY_FORMAT_INVALID = "Storage capacity format is invalid, expected format: MB, GB, TB";

    public static InvalidStorageException becauseTechnologyIsInvalid() {
        return new InvalidStorageException(MESSAGE_TECHNOLOGY_INVALID);
    }

    public static InvalidStorageException becauseCapacityIsInvalid() {
        return new InvalidStorageException(MESSAGE_CAPACITY_INVALID);
    }
    public static InvalidStorageException becauseCapacityIsNull() {
        return new InvalidStorageException(MESSAGE_CAPACITY_INVALID2);
    }

    public static InvalidStorageException becauseTechnologyIsNull() {
        return new InvalidStorageException(MESSAGE_CAPACITY_INVALID2);
    }

    public static InvalidStorageException becauseCapacityFormatIsInvalid() {
        return new InvalidStorageException(MESSAGE_CAPACITY_FORMAT_INVALID);
    }
}