package org.model.vo;

import org.model.exceptions.InvalidPasswordException;

import java.util.Objects;
import java.util.regex.Pattern;

public record UserPassword(String value){

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    private static void validateFormat(String value){
        if (!PASSWORD_PATTERN.matcher(value).matches()){
            throw InvalidPasswordException.becauseFormatIsInvalid();
        }
    }

    private static void validateIsNotEmpty(String value){
        if (value.isEmpty()){
            throw InvalidPasswordException.becauseIsEmpty();
        }
    }

    public UserPassword{
        final String normalizedValue = Objects.requireNonNull(value, "UserName cannot be null");
        validateIsNotEmpty(normalizedValue);
        validateFormat(normalizedValue);
    }
}
