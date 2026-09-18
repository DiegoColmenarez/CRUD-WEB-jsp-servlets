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
    private static final String SMTP_FROM;

    static {
        String envUser = System.getenv("SMTP_USER");
        String envPassword = System.getenv("SMTP_PASSWORD");
        String envHost = System.getenv("SMTP_HOST");
        String envPort = System.getenv("SMTP_PORT");
        String envFrom = System.getenv("SMTP_FROM");

        SMTP_USER = (envUser != null && !envUser.isEmpty()) ? envUser : PropertiesLoaderSmtp.get("smtp.user");
        SMTP_FROM = (envFrom != null && !envFrom.isEmpty()) ? envFrom : PropertiesLoaderSmtp.get("smtp.from");

        String smtpPassword = (envPassword != null && !envPassword.isEmpty()) ? envPassword : PropertiesLoaderSmtp.get("smtp.password");
        String smtpHost = (envHost != null && !envHost.isEmpty()) ? envHost : PropertiesLoaderSmtp.get("smtp.host");
        String smtpPort = (envPort != null && !envPort.isEmpty()) ? envPort : PropertiesLoaderSmtp.get("smtp.port");

        String auth = PropertiesLoaderSmtp.get("smtp.auth") != null ? PropertiesLoaderSmtp.get("smtp.auth") : "true";
        String startTls = PropertiesLoaderSmtp.get("smtp.starttls") != null ? PropertiesLoaderSmtp.get("smtp.starttls") : "true";

        Properties props = new Properties();
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", startTls);
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);

        SESSION = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SMTP_USER, smtpPassword);
            }
        });
    }

    public void sendResetCode(String toEmail, String code) {
        try {
            Message message = new MimeMessage(SESSION);
            message.setFrom(new InternetAddress(SMTP_FROM));
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