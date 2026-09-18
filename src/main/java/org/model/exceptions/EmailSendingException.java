package org.model.exceptions;

public class EmailSendingException extends DomainException {
    public EmailSendingException(String message) {
        super(message);
    }

    private static final String MESSAGE_SEND_FAILED = "Email could not be sent, please try again later";

    public static EmailSendingException becauseSendFailed() {
        return new EmailSendingException(MESSAGE_SEND_FAILED);
    }
}