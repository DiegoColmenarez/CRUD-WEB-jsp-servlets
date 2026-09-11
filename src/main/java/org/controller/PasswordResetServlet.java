package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.model.repository.PasswordResetRepository;
import org.model.repository.UserRepository;
import org.model.service.EmailService;
import org.model.service.PasswordResetCodeGenerator;

@WebServlet(name = "PasswordResetServlet", value = "/password-reset")
public class PasswordResetServlet extends HttpServlet {

    private UserRepository userRepository;
    private PasswordResetRepository passwordResetRepository;
    private PasswordResetCodeGenerator codeGenerator;
    private EmailService emailService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userRepository = new UserRepository();
        this.passwordResetRepository = new PasswordResetRepository();
        this.codeGenerator = new PasswordResetCodeGenerator();
        this.emailService = new EmailService();
    }
}
