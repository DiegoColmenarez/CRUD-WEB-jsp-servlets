package org.model.vo;

import org.model.exceptions.InvalidMemoryException;


public record ComputerMemory(String tecnologiaRam, String capacidadRam) {

    private static void validateTecnologiaRam(String tecnologiaRam) {
        if (tecnologiaRam == null || tecnologiaRam.trim().isEmpty()) {
            throw InvalidMemoryException.becauseTecnologiaIsInvalid();
        }
    }

    private static void validateCapacidadRam(String capacidadRam) {
        if (capacidadRam == null || capacidadRam.trim().isEmpty()) {
            throw InvalidMemoryException.becauseCapacidadIsInvalid();
        }
    }

    private static void validateCapacidadFormat(String capacidadRam) {
        if (!capacidadRam.matches("^\\d+\\s*(GB|MB)$")) {
            throw InvalidMemoryException.becauseCapacidadFormatIsInvalid();
        }
    }

    public ComputerMemory {
        validateTecnologiaRam(tecnologiaRam);
        validateCapacidadRam(capacidadRam);
        validateCapacidadFormat(capacidadRam.trim());
        tecnologiaRam = tecnologiaRam.trim().toUpperCase();
        capacidadRam = capacidadRam.trim().toUpperCase();
    }
}