package org.model.exceptions;

import org.model.vo.ComputerId;

public class ComputerNotFoundException extends DomainException {
    public ComputerNotFoundException(String message) {
        super(message);
    }

    private static final String MESSAGE_ID_DOES_NOT_EXIST = "Computer not found with ID: '%s'";

    public static ComputerNotFoundException becauseIdDoesNotExist(ComputerId id) {
        return new ComputerNotFoundException(String.format(MESSAGE_ID_DOES_NOT_EXIST, id.value()));
    }
}