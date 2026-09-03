package org.model.enums;

public enum TypeUser {
    CLIENTE,
    ADMIN;

    private static boolean isValidValue(final String value) {
        for (final TypeUser role : values()) {
            if (role.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
