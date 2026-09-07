package org.model.repository;


import org.model.vo.UserId;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    private final static String MESSAGE_USER_NOT_EXIST =  "The user '%s' don't exist";

    public static UserNotFoundException becauseIdDoesExist(UserId userid){
        return new UserNotFoundException(String.format(MESSAGE_USER_NOT_EXIST, userid));
    }
}
