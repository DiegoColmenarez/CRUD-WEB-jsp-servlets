package org.model.repository;

public class RepositoryException extends RuntimeException {
    public RepositoryException(String message) {
        super(message);
    }
    private static final String MESSAGE_ERROR = "Error, It cannot be inserted. Cause: '%s'";

    public static RepositoryException repositoryGeneralException(Throwable throwable){
        return new RepositoryException(String.format(MESSAGE_ERROR, throwable));
    }
}
