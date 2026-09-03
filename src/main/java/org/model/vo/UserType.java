package org.model.vo;

import org.model.enums.TypeUser;
import org.model.exceptions.InvalidTypeUserException;

import java.util.Objects;

public record UserType(String value) {

    private static void validateType(String value){
        if (!TypeUser.isValidValue(value)){
            throw InvalidTypeUserException.becauseValueIsInvalid();
        }
    }

    public UserType{
        final String normalizedValue = Objects.requireNonNull(value, "User type cannot be null")
                .trim();
        validateType(normalizedValue);
        value = normalizedValue;
    }
}
