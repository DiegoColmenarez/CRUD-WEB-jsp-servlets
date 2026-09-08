package org.model.exceptions;

import org.model.vo.UserId;
import org.model.vo.UserName;

public class UserNotFoundException extends DomainException{
    public UserNotFoundException(String message) {
        super(message);
    }

    private final static String MESSAGE_USER_NOT_EXIST =  "The user id: '%s' don't exist";
    private final static String MESSAGE_USER_NOT_EXIST2 =  "The user/s name: '%s' don't exist";
    private final static String MESSAGE_USER_NOT_EXIST3 =  "The user/s lastname: '%s' don't exist";

    public static UserNotFoundException becauseIdDoesExist(UserId userId){
        return new UserNotFoundException(String.format(MESSAGE_USER_NOT_EXIST, userId.value()));
    }
    public static UserNotFoundException becauseNameDoesExist(UserName userName){
        return new UserNotFoundException(String.format(MESSAGE_USER_NOT_EXIST2, userName.value()));
    }

    public static UserNotFoundException becauseLastNameDoesExist(UserName userName){
        return new UserNotFoundException(String.format(MESSAGE_USER_NOT_EXIST3, userName.value()));
    }
}
