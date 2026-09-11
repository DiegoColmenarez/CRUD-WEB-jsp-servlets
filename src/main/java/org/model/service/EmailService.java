package org.model.service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.model.config.PropertiesLoaderSmtp;
import org.model.exceptions.EmailSendingException;

import java.util.Properties;

public class EmailService {

    private static final Session SESSION;
    private static final String SMTP_USER;

    static {
        SMTP_USER = PropertiesLoaderSmtp.get("smtp.user");
        Properties props = new Properties();
        props.put("mail.smtp.auth", PropertiesLoaderSmtp.get("smtp.auth"));
        props.put("mail.smtp.starttls.enable", PropertiesLoaderSmtp.get("smtp.starttls"));
        props.put("mail.smtp.host", PropertiesLoaderSmtp.get("smtp.host"));
        props.put("mail.smtp.port", PropertiesLoaderSmtp.get("smtp.port"));
        SESSION = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        SMTP_USER,
                        PropertiesLoaderSmtp.get("smtp.password")
                );
            }
        });
    }

    public void sendResetCode(String toEmail, String code) {
        try {
            Message message = new MimeMessage(SESSION);
            message.setFrom(new InternetAddress(SMTP_USER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Password Reset Code");
            message.setText("Your password reset code is: " + code +
                    "\n\nThis code will expire in 15 minutes.");
            Transport.send(message);
        } catch (MessagingException e) {
            throw EmailSendingException.becauseSendFailed();
        }
    }
}