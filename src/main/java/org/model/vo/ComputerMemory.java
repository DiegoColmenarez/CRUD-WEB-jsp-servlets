package org.model.vo;

import org.model.enums.RamTechnology;
import org.model.exceptions.InvalidMemoryException;

public record ComputerMemory(RamTechnology ramTechnology, String ramCapacity) {

    private static void validateRamTechnologyNull(RamTechnology ramTechnology) {
        if (ramTechnology == null) {
            throw InvalidMemoryException.becauseTechnologyIsNull();
        }
    }

    private static void validateRamCapacityNull(String ramCapacity) {
        if (ramCapacity == null) {
            throw InvalidMemoryException.becauseCapacityIsNull();
        }
    }

    private static void validateRamCapacityEmpty(String ramCapacity) {
        if (ramCapacity.trim().isEmpty()) {
            throw InvalidMemoryException.becauseCapacityIsEmpty();
        }
    }

    private static void validateCapacityFormat(String ramCapacity) {
        if (!ramCapacity.matches("^\\d+\\s*(GB|MB)$")) {
            throw InvalidMemoryException.becauseCapacityFormatIsInvalid();
        }
    }

    public ComputerMemory {
        validateRamTechnologyNull(ramTechnology);
        validateRamCapacityNull(ramCapacity);
        validateRamCapacityEmpty(ramCapacity);
        validateCapacityFormat(ramCapacity.trim());
        ramCapacity = ramCapacity.trim().toUpperCase();
    }
}