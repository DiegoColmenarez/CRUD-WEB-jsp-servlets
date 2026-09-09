package org.model.exceptions;

public class InvalidDisplayException extends DomainException {
    public InvalidDisplayException(String message) {
        super(message);
    }

    private static final String MESSAGE_BRAND_NULL = "Monitor brand is invalid. Brand is Null";
    private static final String MESSAGE_BRAND_EMPTY = "Monitor brand is invalid, it cannot be empty";
    private static final String MESSAGE_INCHES_NULL = "Monitor inches are invalid. Inches are Null";
    private static final String MESSAGE_INCHES_INVALID = "Monitor inches are invalid, must be greater than 0";
    private static final String MESSAGE_INCHES_EXCEEDED = "Monitor inches exceeded, maximum is 80 inches";

    public static InvalidDisplayException becauseBrandIsNull() {
        return new InvalidDisplayException(MESSAGE_BRAND_NULL);
    }

    public static InvalidDisplayException becauseBrandIsEmpty() {
        return new InvalidDisplayException(MESSAGE_BRAND_EMPTY);
    }

    public static InvalidDisplayException becauseInchesAreNull() {
        return new InvalidDisplayException(MESSAGE_INCHES_NULL);
    }

    public static InvalidDisplayException becauseInchesAreInvalid() {
        return new InvalidDisplayException(MESSAGE_INCHES_INVALID);
    }

    public static InvalidDisplayException becauseInchesExceeded() {
        return new InvalidDisplayException(MESSAGE_INCHES_EXCEEDED);
    }
}