package org.model.service;

import org.model.vo.PasswordResetCode;

import java.security.SecureRandom;

public class PasswordResetCodeGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();

    public PasswordResetCode generator(){
        int number = 100000 + secureRandom.nextInt(900000);
        return new PasswordResetCode(String.valueOf(number));
    }
}
