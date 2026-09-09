package org.model.exceptions;

public class InvalidMemoryException extends DomainException {
    public InvalidMemoryException(String message) {
        super(message);
    }

    private static final String MESSAGE_TECNOLOGIA_INVALID = "RAM technology is invalid";
    private static final String MESSAGE_CAPACIDAD_INVALID = "RAM capacity is invalid";
    private static final String MESSAGE_CAPACIDAD_FORMAT_INVALID = "RAM capacity format is invalid, expected format: 16GB";

    public static InvalidMemoryException becauseTecnologiaIsInvalid() {
        return new InvalidMemoryException(MESSAGE_TECNOLOGIA_INVALID);
    }

    public static InvalidMemoryException becauseCapacidadIsInvalid() {
        return new InvalidMemoryException(MESSAGE_CAPACIDAD_INVALID);
    }

    public static InvalidMemoryException becauseCapacidadFormatIsInvalid() {
        return new InvalidMemoryException(MESSAGE_CAPACIDAD_FORMAT_INVALID);
    }
}