package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.model.exceptions.DomainException;
import org.model.repository.PasswordResetRepository;
import org.model.repository.UserRepository;
import org.model.service.EmailService;
import org.model.service.PasswordResetCodeGenerator;
import org.model.vo.PasswordResetCode;
import org.model.vo.UserEmail;
import org.model.vo.UserId;
import org.model.vo.UserPassword;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

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

    private void showPasswordForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/password-reset/newPassword.jsp");
        dispatcher.forward(request, response);
    }

    private void sendCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserEmail email = new UserEmail(request.getParameter("email"));
            Optional<UserId> userId = userRepository.findIdByEmail(email);

            if (userId.isPresent()) {
                PasswordResetCode code = codeGenerator.generator();
                LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(15);

                passwordResetRepository.saveResetCode(userId.get(), code, expiresAt);
                emailService.sendResetCode(email.value(), code.value());
            }

            request.getSession().setAttribute("resetEmail", email.value());
            request.setAttribute("successMessage",
                    "If the email is registered, you will receive a reset code");
            showCodeForm(request, response);
        } catch (DomainException e) {
            request.setAttribute("errorMessage", e.getMessage());
            showEmailForm(request, response);
        }
    }

    private void verifyCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PasswordResetCode code = new PasswordResetCode(request.getParameter("code"));
            Optional<Integer> userId = passwordResetRepository.findUserIdByValidCode(code);

            if (userId.isEmpty()) {
                request.setAttribute("errorMessage", "Invalid or expired code");
                showCodeForm(request, response);
                return;
            }

            request.getSession().setAttribute("resetCode", code.value());
            showPasswordForm(request, response);
        } catch (DomainException e) {
            request.setAttribute("errorMessage", e.getMessage());
            showCodeForm(request, response);
        }
    }

    private void updatePassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String codeValue = (String) request.getSession().getAttribute("resetCode");
            if (codeValue == null) {
                showEmailForm(request, response);
                return;
            }

            PasswordResetCode code = new PasswordResetCode(codeValue);
            Optional<Integer> userId = passwordResetRepository.findUserIdByValidCode(code);
            if (userId.isEmpty()) {
                request.setAttribute("errorMessage", "Session expired, please start again");
                showEmailForm(request, response);
                return;
            }

            UserPassword newPassword = new UserPassword(request.getParameter("password"));
            UserPassword confirmPassword = new UserPassword(request.getParameter("confirmPassword"));

            if (!newPassword.value().equals(confirmPassword.value())) {
                request.setAttribute("errorMessage", "Passwords do not match");
                showPasswordForm(request, response);
                return;
            }

            userRepository.updatePassword(new UserId(userId.get()), newPassword);
            passwordResetRepository.markCodeAsUsed(code);
            request.getSession().removeAttribute("resetCode");
            request.getSession().removeAttribute("resetEmail");

            response.sendRedirect(request.getContextPath() + "/jsp/auth/login.jsp");
        } catch (DomainException e) {
            request.setAttribute("errorMessage", e.getMessage());
            showPasswordForm(request, response);
        }
    }
}
