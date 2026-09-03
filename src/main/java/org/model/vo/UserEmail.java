package org.model.vo;

import org.model.exceptions.InvalidEmailUserException;

import java.util.Objects;
import java.util.regex.Pattern;

public record UserEmail(String value) {

    // de momento esto se queda así
    private static final Pattern PATTERN_EMAIL =
            Pattern.compile("^[\\p{L} \\-']+$");

    private static void validateFormatEmail(String value){
        if (!PATTERN_EMAIL.matcher(value).matches()){
            throw InvalidEmailUserException.becauseFormatIsInvalid();
        }
    }

    public UserEmail{
        final String normalizedValue = Objects.requireNonNull(value, "UserLastName cannot be null");
        validateFormatEmail(normalizedValue);
    }
}
