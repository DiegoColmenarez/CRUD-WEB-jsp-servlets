package org.model.vo;

import org.model.exceptions.InvalidComputerIdException;

public record ComputerId(Integer value) {

    private static void validateNull(Integer value) {
        if (value == null) {
            throw InvalidComputerIdException.becauseIdIsNull();
        }
    }

    private static void validatePositive(Integer value) {
        if (value <= 0) {
            throw InvalidComputerIdException.becauseIdIsInvalid();
        }
    }

    public ComputerId {
        validateNull(value);
        validatePositive(value);
    }
}