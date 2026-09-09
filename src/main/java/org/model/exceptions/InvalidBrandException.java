package org.model.exceptions;

public class InvalidBrandException extends DomainException {
    public InvalidBrandException(String message) {
        super(message);
    }

    private static final String MESSAGE_BRAND_NULL = "Brand is invalid. Brand is Null";
    private static final String MESSAGE_BRAND_EMPTY = "Brand is invalid, it cannot be empty";
    private static final String MESSAGE_FORMAT_INVALID = "Brand format is invalid, only letters, numbers, spaces, hyphens and underscores are allowed";
    private static final String MESSAGE_LENGTH_INVALID = "Brand is invalid, length must be between 2 and 50 characters";

    public static InvalidBrandException becauseBrandIsNull() {
        return new InvalidBrandException(MESSAGE_BRAND_NULL);
    }

    public static InvalidBrandException becauseBrandIsEmpty() {
        return new InvalidBrandException(MESSAGE_BRAND_EMPTY);
    }

    public static InvalidBrandException becauseFormatIsInvalid() {
        return new InvalidBrandException(MESSAGE_FORMAT_INVALID);
    }

    public static InvalidBrandException becauseLengthIsInvalid() {
        return new InvalidBrandException(MESSAGE_LENGTH_INVALID);
    }
}