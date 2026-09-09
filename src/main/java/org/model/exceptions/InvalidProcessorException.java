package org.model.exceptions;

public class InvalidProcessorException extends DomainException {
    public InvalidProcessorException(String message) {
        super(message);
    }

    private static final String MESSAGE_MARCA_INVALID = "Processor brand is invalid";
    private static final String MESSAGE_VELOCIDAD_INVALID = "Processor speed is invalid";
    private static final String MESSAGE_VELOCIDAD_FORMAT_INVALID = "Processor speed format is invalid, expected format: 3.5GHz";

    public static InvalidProcessorException becauseMarcaIsInvalid() {
        return new InvalidProcessorException(MESSAGE_MARCA_INVALID);
    }

    public static InvalidProcessorException becauseVelocidadIsInvalid() {
        return new InvalidProcessorException(MESSAGE_VELOCIDAD_INVALID);
    }

    public static InvalidProcessorException becauseVelocidadFormatIsInvalid() {
        return new InvalidProcessorException(MESSAGE_VELOCIDAD_FORMAT_INVALID);
    }
}