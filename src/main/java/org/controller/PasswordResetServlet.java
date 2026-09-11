package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.model.repository.PasswordResetRepository;
import org.model.repository.UserRepository;
import org.model.service.EmailService;
import org.model.service.PasswordResetCodeGenerator;

import java.io.IOException;

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

    private void showEmailForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/password-reset/enterEmail.jsp");
        dispatcher.forward(request, response);
    }

    private void showCodeForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/password-reset/enterCode.jsp");
        dispatcher.forward(request, response);
    }
}
