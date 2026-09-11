package org.model.exceptions;

public class EmailSendingException extends DomainException {
    public EmailSendingException(String message) {
        super(message);
    }
}
