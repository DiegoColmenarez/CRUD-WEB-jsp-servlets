package org.model.exceptions;


import org.model.vo.UserId;

public class UserNotFoundException extends DomainException{
    public UserNotFoundException(String message) {
        super(message);
    }

    private final static String MESSAGE_USER_NOT_EXIST =  "The user id: '%s' don't exist";

    public static UserNotFoundException becauseIdDoesExist(UserId userId) {
        return new UserNotFoundException(String.format(MESSAGE_USER_NOT_EXIST, userId.value()));
    }
}
