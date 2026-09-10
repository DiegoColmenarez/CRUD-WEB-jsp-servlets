package org.model.vo;

import org.model.exceptions.InvalidPortsException;

public record ComputerPorts(Integer usbPorts, Integer hdmiPorts) {

    private static void validateUsbPortsNull(Integer usbPorts) {
        if (usbPorts == null) {
            throw InvalidPortsException.becauseUsbPortsAreNull();
        }
    }

    private static void validateHdmiPortsNull(Integer hdmiPorts) {
        if (hdmiPorts == null) {
            throw InvalidPortsException.becauseHdmiPortsAreNull();
        }
    }

    private static void validateUsbPorts(Integer usbPorts) {
        if (usbPorts < 0) {
            throw InvalidPortsException.becauseUsbPortsAreInvalid();
        }
    }

    private static void validateHdmiPorts(Integer hdmiPorts) {
        if (hdmiPorts < 0) {
            throw InvalidPortsException.becauseHdmiPortsAreInvalid();
        }
    }

    private static void validateTotalPorts(Integer usbPorts, Integer hdmiPorts) {
        if (usbPorts + hdmiPorts > 20) {
            throw InvalidPortsException.becauseTotalPortsExceeded();
        }
    }

    public ComputerPorts {
        validateUsbPortsNull(usbPorts);
        validateHdmiPortsNull(hdmiPorts);
        validateUsbPorts(usbPorts);
        validateHdmiPorts(hdmiPorts);
        validateTotalPorts(usbPorts, hdmiPorts);
    }
}