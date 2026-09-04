package org.model.vo;

import org.model.enums.TypeUser;
import org.model.exceptions.InvalidTypeUserException;

import java.util.Objects;

public record UserType(TypeUser value) {

    private static void validateType(String value){
        if (!TypeUser.isValidValue(value)){
            throw InvalidTypeUserException.becauseValueIsInvalid();
        }
    }
    private static void validateNotEmpty(String value){
        if (value.isEmpty()){
            throw InvalidTypeUserException.becauseIsEmpty();
        }
    }

    public UserType{
        final TypeUser normalizedValue = Objects.requireNonNull(value, "User type cannot be null");
        validateNotEmpty(String.valueOf(normalizedValue));
        validateType(String.valueOf(normalizedValue));
    }
}
