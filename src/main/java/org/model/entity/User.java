package org.model.entity;

import org.model.enums.TypeUser;
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
    private User(
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

    public UserName getLastName() {
        return lastName;
    }

    public void setLastName(UserName lastName) {
        this.lastName = lastName;
    }

    public UserEmail getEmail() {
        return email;
    }

    public void setEmail(UserEmail email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
