package org.model.repository;

import org.model.exceptions.DomainException;

public class RepositoryException extends DomainException {
    public RepositoryException(String message) {
        super(message);
    }
    private static final String MESSAGE_ERROR = "Error, It cannot be inserted. Cause: '%s'";

    public static RepositoryException repositoryGeneralException(Throwable throwable){
        return new RepositoryException(String.format(MESSAGE_ERROR, throwable));
    }
}
