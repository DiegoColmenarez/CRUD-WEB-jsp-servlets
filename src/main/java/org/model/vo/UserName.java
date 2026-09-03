package org.model.vo;

import org.model.exceptions.InvalidNameUserException;

import java.util.Objects;
import java.util.regex.Pattern;

public record UserName(String value) {

    private static final Pattern NAME_PATTERN =
            Pattern.compile("^[\\p{L} \\-']+$");

    private static void validateNameFormat(String value) {
        if (!NAME_PATTERN.matcher(value).matches()) {
            throw InvalidNameUserException.becauseContainsInvalidCharacters();
        }
    }

    public UserName{
        final String normalizedValue = Objects.requireNonNull(value, "UserName cannot be null")
                .trim();
        validateNameFormat(normalizedValue);
        value = normalizedValue;
    }
}
