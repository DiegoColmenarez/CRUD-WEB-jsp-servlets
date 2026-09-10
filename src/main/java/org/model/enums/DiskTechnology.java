package org.model.enums;

public enum DiskTechnology {
    HDD,
    SDD,
    NVME;

    public static boolean isValidValue(final String value) {
        for (final DiskTechnology technology : values()) {
            if (technology.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
