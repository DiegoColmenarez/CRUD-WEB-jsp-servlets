package org.model.vo;

import org.model.enums.TypeUser;
import org.model.exceptions.InvalidTypeUserException;

public record UserType(String value) {

    private static void validateType(String value){
        if (!TypeUser.isValidValue(value)){
            throw InvalidTypeUserException.becauseValueIsInvalid();
        }
    }
}
