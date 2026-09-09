package org.model.vo;

import org.model.exceptions.InvalidBrandException;
import java.util.Objects;

public record ComputerBrand(String value) {

    private static void validateNotEmpty(String value) {
        if (value.trim().isEmpty()) {
            throw InvalidBrandException.becauseIsEmpty();
        }
    }

    private static void validateFormat(String value) {
        if (value.length() < 2 || value.length() > 50) {
            throw InvalidBrandException.becauseLengthIsInvalid();
        }
    }

    public ComputerBrand {
        final String normalizedValue = Objects.requireNonNull(value, "Brand cannot be null").trim();
        validateNotEmpty(normalizedValue);
        validateFormat(normalizedValue);
        value = normalizedValue.toUpperCase();
    }
}