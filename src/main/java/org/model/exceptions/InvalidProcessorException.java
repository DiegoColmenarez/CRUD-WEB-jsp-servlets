package org.model.exceptions;

public class InvalidProcessorException extends DomainException {
    public InvalidProcessorException(String message) {
        super(message);
    }

    private static final String MESSAGE_BRAND_NULL = "Processor brand is invalid. Brand is Null";
    private static final String MESSAGE_BRAND_EMPTY = "Processor brand is invalid, it cannot be empty";
    private static final String MESSAGE_SPEED_NULL = "Processor speed is invalid. Speed is Null";
    private static final String MESSAGE_SPEED_EMPTY = "Processor speed is invalid, it cannot be empty";
    private static final String MESSAGE_SPEED_FORMAT_INVALID = "Processor speed format is invalid, expected format: 3.5GHz";

    public static InvalidProcessorException becauseBrandIsNull() {
        return new InvalidProcessorException(MESSAGE_BRAND_NULL);
    }

    public static InvalidProcessorException becauseBrandIsEmpty() {
        return new InvalidProcessorException(MESSAGE_BRAND_EMPTY);
    }

    public static InvalidProcessorException becauseSpeedIsNull() {
        return new InvalidProcessorException(MESSAGE_SPEED_NULL);
    }

    public static InvalidProcessorException becauseSpeedIsEmpty() {
        return new InvalidProcessorException(MESSAGE_SPEED_EMPTY);
    }

    public static InvalidProcessorException becauseSpeedFormatIsInvalid() {
        return new InvalidProcessorException(MESSAGE_SPEED_FORMAT_INVALID);
    }
}