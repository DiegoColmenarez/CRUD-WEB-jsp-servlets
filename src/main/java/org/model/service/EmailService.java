package org.model.service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.model.config.PropertiesLoaderSmtp;
import org.model.exceptions.EmailSendingException;

import java.util.Properties;

public class EmailService {

    private static final Session SESSION;
    private static final String SMTP_USER_AUTH;
    private static final String SENDER_EMAIL;

    static {
        // Buscamos la variable de Render
        String envUser = System.getenv("SMTP_USER");

        if (envUser != null && !envUser.isEmpty()) {
            SMTP_USER_AUTH = envUser;
            String envFrom = System.getenv("SMTP_FROM");
            SENDER_EMAIL = (envFrom != null && !envFrom.isEmpty()) ? envFrom : SMTP_USER_AUTH;

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", System.getenv("SMTP_HOST"));
            props.put("mail.smtp.port", System.getenv("SMTP_PORT"));

            SESSION = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SMTP_USER_AUTH, System.getenv("SMTP_PASSWORD"));
                }
            });
        } else {
            SMTP_USER_AUTH = PropertiesLoaderSmtp.get("smtp.user");
            String localFrom = PropertiesLoaderSmtp.get("smtp.from");
            SENDER_EMAIL = (localFrom != null && !localFrom.isEmpty()) ? localFrom : SMTP_USER_AUTH;

            Properties props = new Properties();
            props.put("mail.smtp.auth", PropertiesLoaderSmtp.get("smtp.auth"));
            props.put("mail.smtp.starttls.enable", PropertiesLoaderSmtp.get("smtp.starttls"));
            props.put("mail.smtp.host", PropertiesLoaderSmtp.get("smtp.host"));
            props.put("mail.smtp.port", PropertiesLoaderSmtp.get("smtp.port"));

            SESSION = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            SMTP_USER_AUTH,
                            PropertiesLoaderSmtp.get("smtp.password")
                    );
                }
            });
        }
    }

    public void sendResetCode(String toEmail, String code) {
        try {
            Message message = new MimeMessage(SESSION);
            message.setFrom(new InternetAddress(SENDER_EMAIL));
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