package org.model.service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.model.config.PropertiesLoaderSmtp;
import org.model.exceptions.EmailSendingException;

import java.util.Properties;


public class EmailService {

    private final String smtpUser;

    public EmailService() {
        this.smtpUser = PropertiesLoaderSmtp.get("smtp.user");
    }

    public void sendResetCode(String toEmail, String code) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", PropertiesLoaderSmtp.get("smtp.auth"));
        props.put("mail.smtp.starttls.enable", PropertiesLoaderSmtp.get("smtp.starttls"));
        props.put("mail.smtp.host", PropertiesLoaderSmtp.get("smtp.host"));
        props.put("mail.smtp.port", PropertiesLoaderSmtp.get("smtp.port"));

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        PropertiesLoaderSmtp.get("smtp.user"),
                        PropertiesLoaderSmtp.get("smtp.password")
                );
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(smtpUser));
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