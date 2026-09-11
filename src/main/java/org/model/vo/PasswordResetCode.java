package org.model.vo;

import org.model.exceptions.InvalidPasswordResetCodeException;

public record PasswordResetCode(String value) {

    private static final String CODE_PATTERN = "^\\d{6}$";

    private static void validateNull(String value) {
        if (value == null) {
            throw InvalidPasswordResetCodeException.becauseCodeIsNull();
        }
    }

    private static void validateEmpty(String value) {
        if (value.trim().isEmpty()) {
            throw InvalidPasswordResetCodeException.becauseCodeIsEmpty();
        }
    }

    private static void validateFormat(String value) {
        if (!value.trim().matches(CODE_PATTERN)) {
            throw InvalidPasswordResetCodeException.becauseFormatIsInvalid();
        }
    }

    public PasswordResetCode {
        validateNull(value);
        validateEmpty(value);
        validateFormat(value);
        value = value.trim();
    }
}