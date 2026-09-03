package org.model.vo;

import org.model.exceptions.InvalidUserIdException;

import java.util.Objects;

public record UserId(int value) {

    private static void validateIntPositive(int value){
        if (value < 0){
            throw InvalidUserIdException.becauseIdIsInvalid();
        }
    }

    public UserId{
        var normalizedValue =  Objects.requireNonNull(value, "UserLastName cannot be null");
        validateIntPositive(normalizedValue);
        value = normalizedValue;
    }
}
