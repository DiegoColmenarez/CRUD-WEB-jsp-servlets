package org.model.vo;

import org.model.exceptions.InvalidProcessorException;

public record ComputerProcessor(String cpuBrand, String cpuSpeed) {

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
        if (!cpuSpeed.matches("^\\d+(\\.\\d+)?\\s*(GHz|MHz)$")) {
            throw InvalidProcessorException.becauseSpeedFormatIsInvalid();
        }
    }

    public ComputerProcessor {
        validateCpuBrandNull(cpuBrand);
        validateCpuBrandEmpty(cpuBrand);
        validateCpuSpeedNull(cpuSpeed);
        validateCpuSpeedEmpty(cpuSpeed);
        validateSpeedFormat(cpuSpeed.trim());
        cpuBrand = cpuBrand.trim().toUpperCase();
        cpuSpeed = cpuSpeed.trim().toUpperCase();
    }
}