package org.model.vo;

import org.model.exceptions.InvalidUserIdException;



public record UserId(int value) {

    private static void validateIntPositive(int value){
        if (value < 0){
            throw InvalidUserIdException.becauseIdIsInvalid();
        }
    }

    public UserId{
        validateIntPositive(value);
    }
}
