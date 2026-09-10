package org.model.exceptions;

public class InvalidPortsException extends DomainException {
    public InvalidPortsException(String message) {
        super(message);
    }

    private static final String MESSAGE_USB_NULL = "USB ports are invalid. USB ports are Null";
    private static final String MESSAGE_HDMI_NULL = "HDMI ports are invalid. HDMI ports are Null";
    private static final String MESSAGE_USB_INVALID = "USB ports are invalid, cannot be negative";
    private static final String MESSAGE_HDMI_INVALID = "HDMI ports are invalid, cannot be negative";
    private static final String MESSAGE_TOTAL_EXCEEDED = "Total ports exceeded, maximum is 20 ports";

    public static InvalidPortsException becauseUsbPortsAreNull() {
        return new InvalidPortsException(MESSAGE_USB_NULL);
    }

    public static InvalidPortsException becauseHdmiPortsAreNull() {
        return new InvalidPortsException(MESSAGE_HDMI_NULL);
    }

    public static InvalidPortsException becauseUsbPortsAreInvalid() {
        return new InvalidPortsException(MESSAGE_USB_INVALID);
    }

    public static InvalidPortsException becauseHdmiPortsAreInvalid() {
        return new InvalidPortsException(MESSAGE_HDMI_INVALID);
    }

    public static InvalidPortsException becauseTotalPortsExceeded() {
        return new InvalidPortsException(MESSAGE_TOTAL_EXCEEDED);
    }
}