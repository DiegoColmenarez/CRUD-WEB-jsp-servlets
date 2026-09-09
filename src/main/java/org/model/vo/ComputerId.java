package org.model.vo;

import org.model.exceptions.InvalidComputerIdException;

public record ComputerId(Integer value) {

    private static void validatePositive(Integer value) {
        if (value != null && value <= 0) {
            throw InvalidComputerIdException.becauseIdIsInvalid();
        }
    }

    public ComputerId {
        validatePositive(value);
    }
}