package org.model.vo;

import org.model.exceptions.InvalidDisplayException;
import java.math.BigDecimal;

public record ComputerDisplay(String monitorBrand, BigDecimal inches) {

    private static void validateMonitorBrandNull(String monitorBrand) {
        if (monitorBrand == null) {
            throw InvalidDisplayException.becauseBrandIsNull();
        }
    }

    private static void validateMonitorBrandEmpty(String monitorBrand) {
        if (monitorBrand.trim().isEmpty()) {
            throw InvalidDisplayException.becauseBrandIsEmpty();
        }
    }

    private static void validateInchesNull(BigDecimal inches) {
        if (inches == null) {
            throw InvalidDisplayException.becauseInchesAreNull();
        }
    }

    private static void validateInches(BigDecimal inches) {
        if (inches.compareTo(BigDecimal.ZERO) <= 0) {
            throw InvalidDisplayException.becauseInchesAreInvalid();
        }
    }

    private static void validateInchesRange(BigDecimal inches) {
        if (inches.compareTo(new BigDecimal("80")) > 0) {
            throw InvalidDisplayException.becauseInchesExceeded();
        }
    }

    public ComputerDisplay {
        validateMonitorBrandNull(monitorBrand);
        validateMonitorBrandEmpty(monitorBrand);
        validateInchesNull(inches);
        validateInches(inches);
        validateInchesRange(inches);
        monitorBrand = monitorBrand.trim().toUpperCase();
    }
}