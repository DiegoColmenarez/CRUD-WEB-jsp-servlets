package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.model.repository.ComputerRepository;

@WebServlet(name = "ComputerServlet", value = "/computer")
public class ComputerServlet extends HttpServlet {
    private ComputerRepository computerRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        this.computerRepository = new ComputerRepository();
    }
}
