package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.model.repository.ComputerRepository;

import java.io.IOException;

@WebServlet(name = "ComputerServlet", value = "/computer")
public class ComputerServlet extends HttpServlet {
    private ComputerRepository computerRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        this.computerRepository = new ComputerRepository();
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/computer/add.jsp");
        dispatcher.forward(request, response);
    }
}
