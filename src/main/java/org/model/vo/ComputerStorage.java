package org.model.vo;

import org.model.enums.DiskTechnology;
import org.model.exceptions.InvalidStorageException;

public record ComputerStorage(DiskTechnology diskTechnology, String diskCapacity) {

    private static void validateDiskTechnologyEmpty(String diskTechnology) {
        if (diskTechnology.trim().isEmpty()) {
            throw InvalidStorageException.becauseTechnologyIsInvalid();
        }
    }
    private static void validateDiskCapacityEmpty(String diskCapacity) {
        if (diskCapacity.trim().isEmpty()) {
            throw InvalidStorageException.becauseCapacityIsInvalid();
        }
    }
    private static void validateDiskCapacityNull(String diskCapacity) {
        if (diskCapacity == null) {
            throw InvalidStorageException.becauseCapacityIsNull();
        }
    }

    private static void validateTechnologyNull(DiskTechnology diskTechnology) {
        if (diskTechnology == null) {
            throw InvalidStorageException.becauseTechnologyIsNull();
        }
    }

    private static void validateCapacityFormat(String diskCapacity) {
        if (!diskCapacity.matches("^\\d+\\s*(GB|TB|MB)$")) {
            throw InvalidStorageException.becauseCapacityFormatIsInvalid();
        }
    }
    private static void validateDiskTechnologyFormat(String diskTechnology) {
        if (!DiskTechnology.isValidValue(diskTechnology)) {
            throw InvalidStorageException.becauseCapacityFormatIsInvalid();
        }
    }

    public ComputerStorage {
        validateDiskCapacityNull(diskCapacity);
        validateDiskCapacityEmpty(diskCapacity);
        validateCapacityFormat(diskCapacity.trim());
        validateTechnologyNull(diskTechnology);
        validateDiskTechnologyEmpty(String.valueOf(diskTechnology));
        validateDiskTechnologyFormat(String.valueOf(diskTechnology));
        diskCapacity = diskCapacity.trim().toUpperCase();
    }
}