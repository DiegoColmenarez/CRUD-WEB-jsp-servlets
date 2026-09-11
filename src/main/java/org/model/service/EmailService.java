package org.model.service;

import jakarta.mail.*;
import org.model.config.PropertiesLoaderSmtp;


public class EmailService {

    private final String smtpUser;

    public EmailService() {
        this.smtpUser = PropertiesLoaderSmtp.get("smtp.user");
    }

}