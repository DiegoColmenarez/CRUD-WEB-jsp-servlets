package org.model.entity;

import org.model.vo.UserEmail;
import org.model.vo.UserId;
import org.model.vo.UserName;
import org.model.vo.UserType;

public class User {
    private UserName name;
    private UserName lastName;
    private UserId id;
    private UserEmail email;
    private UserType type;

    public User(
            UserName name,
            UserName lastName,
            UserEmail email,
            UserType type
    ){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
    }


    public UserName getName() {
        return name;
    }

    public void setName(UserName name) {
        this.name = name;
    }
}
