package org.model.vo;

import org.model.exceptions.InvalidProcessorException;

public record ComputerProcessor(String marcaCpu, String velocidadCpu) {

    private static void validateMarcaCpu(String marcaCpu) {
        if (marcaCpu == null || marcaCpu.trim().isEmpty()) {
            throw InvalidProcessorException.becauseMarcaIsInvalid();
        }
    }

    private static void validateVelocidadCpu(String velocidadCpu) {
        if (velocidadCpu == null || velocidadCpu.trim().isEmpty()) {
            throw InvalidProcessorException.becauseVelocidadIsInvalid();
        }
    }

    private static void validateVelocidadFormat(String velocidadCpu) {
        if (!velocidadCpu.matches("^\\d+(\\.\\d+)?\\s*(GHz|MHz)$")) {
            throw InvalidProcessorException.becauseVelocidadFormatIsInvalid();
        }
    }

    public ComputerProcessor {
        validateMarcaCpu(marcaCpu);
        validateVelocidadCpu(velocidadCpu);
        validateVelocidadFormat(velocidadCpu.trim());
        marcaCpu = marcaCpu.trim().toUpperCase();
        velocidadCpu = velocidadCpu.trim().toUpperCase();
    }
}