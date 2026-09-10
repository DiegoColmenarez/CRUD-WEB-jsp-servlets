package org.model.vo;

import org.model.exceptions.InvalidProcessorException;

public record ComputerProcessor(String cpuBrand, String cpuSpeed) {

    private static final String SPEED_PATTERN = "^\\d+(\\.\\d+)?\\s*(GHz|MHz)?$";

    private static void validateCpuBrandNull(String cpuBrand) {
        if (cpuBrand == null) {
            throw InvalidProcessorException.becauseBrandIsNull();
        }
    }

    private static void validateCpuBrandEmpty(String cpuBrand) {
        if (cpuBrand.trim().isEmpty()) {
            throw InvalidProcessorException.becauseBrandIsEmpty();
        }
    }

    private static void validateCpuSpeedNull(String cpuSpeed) {
        if (cpuSpeed == null) {
            throw InvalidProcessorException.becauseSpeedIsNull();
        }
    }

    private static void validateCpuSpeedEmpty(String cpuSpeed) {
        if (cpuSpeed.trim().isEmpty()) {
            throw InvalidProcessorException.becauseSpeedIsEmpty();
        }
    }

    private static void validateSpeedFormat(String cpuSpeed) {
        if (!cpuSpeed.matches(SPEED_PATTERN)) {
            throw InvalidProcessorException.becauseSpeedFormatIsInvalid();
        }
    }

    private static String normalizeSpeed(String cpuSpeed) {
        String trimmed = cpuSpeed.trim().toUpperCase();
        if (trimmed.matches("^\\d+(\\.\\d+)?$")) {
            return trimmed + "GHZ";
        }
        return trimmed;
    }

    public ComputerProcessor {
        validateCpuBrandNull(cpuBrand);
        validateCpuBrandEmpty(cpuBrand);
        validateCpuSpeedNull(cpuSpeed);
        validateCpuSpeedEmpty(cpuSpeed);
        cpuBrand = cpuBrand.trim().toUpperCase();
        cpuSpeed = normalizeSpeed(cpuSpeed);
        validateSpeedFormat(cpuSpeed);
    }
}