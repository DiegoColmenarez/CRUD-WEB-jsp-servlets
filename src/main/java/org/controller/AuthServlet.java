package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.model.repository.UserRepository;

@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends HttpServlet {
    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userRepository = new UserRepository();
    }
}

