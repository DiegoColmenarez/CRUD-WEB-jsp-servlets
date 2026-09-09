package org.model.exceptions;

public class InvalidStorageException extends DomainException {
    public InvalidStorageException(String message) {
        super(message);
    }

    private static final String MESSAGE_TECNOLOGIA_INVALID = "Storage technology is invalid";
    private static final String MESSAGE_CAPACIDAD_INVALID = "Storage capacity is invalid";
    private static final String MESSAGE_CAPACIDAD_FORMAT_INVALID = "Storage capacity format is invalid";

    public static InvalidStorageException becauseTecnologiaIsInvalid() {
        return new InvalidStorageException(MESSAGE_TECNOLOGIA_INVALID);
    }

    public static InvalidStorageException becauseCapacidadIsInvalid() {
        return new InvalidStorageException(MESSAGE_CAPACIDAD_INVALID);
    }

    public static InvalidStorageException becauseCapacidadFormatIsInvalid() {
        return new InvalidStorageException(MESSAGE_CAPACIDAD_FORMAT_INVALID);
    }
}