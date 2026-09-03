package org.model.vo;

import org.model.exceptions.InvalidEmailUserException;

import java.util.Objects;
import java.util.regex.Pattern;

public record UserEmail(String value) {

    private static final Pattern PATTERN_EMAIL =
            Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$");

    private static void validateFormatEmail(String value){
        if (!PATTERN_EMAIL.matcher(value).matches()){
            throw InvalidEmailUserException.becauseFormatIsInvalid();
        }
    }

    public UserEmail{
        final String normalizedValue = Objects.requireNonNull(value, "UserEmail cannot be null");
        validateFormatEmail(normalizedValue);
        value = normalizedValue;
    }
}
