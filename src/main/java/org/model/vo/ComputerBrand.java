package org.model.vo;

import org.model.exceptions.InvalidBrandException;

public record ComputerBrand(String value) {

    private static void validateNull(String value) {
        if (value == null) {
            throw InvalidBrandException.becauseBrandIsNull();
        }
    }

    private static void validateEmpty(String value) {
        if (value.trim().isEmpty()) {
            throw InvalidBrandException.becauseBrandIsEmpty();
        }
    }

    private static void validateFormat(String value) {
        if (!value.matches("^[a-zA-Z0-9\\s\\-_]+$")) {
            throw InvalidBrandException.becauseFormatIsInvalid();
        }
    }

    private static void validateLength(String value) {
        if (value.length() < 2 || value.length() > 50) {
            throw InvalidBrandException.becauseLengthIsInvalid();
        }
    }

    public ComputerBrand {
        validateNull(value);
        validateEmpty(value);
        validateFormat(value.trim());
        validateLength(value.trim());
        value = value.trim().toUpperCase();
    }
}