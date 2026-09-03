package org.model.vo;

import org.model.exceptions.InvalidNameUserException;

import java.util.Objects;
import java.util.regex.Pattern;

public record UserName(String value) {

    private static final Pattern LAST_NAME_PATTERN =
            Pattern.compile("^[\\p{L} \\-']+$");

    private static void validateNameIsString(String value) {
        if (!LAST_NAME_PATTERN.matcher(value).matches()) {
            throw InvalidNameUserException.beacuseIsNotString();
        }
    }

    public UserName{
        final String normalizedValue = Objects.requireNonNull(value, "UserLastName cannot be null")
                .trim();
        validateNameIsString(normalizedValue);
        value = normalizedValue;
    }
}
