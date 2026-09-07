package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.model.repository.UserRepository;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userRepository = new UserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException{
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "add":
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
                case "list":
                default:
                    break;
            }
        } catch (Exception e) {
            throw new ServletException("Error procesando la petición GET", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException{
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "insert":
                    break;
                case "update":
                    break;
                case "delete":
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/menu.jsp?mensaje=OperacionRealizadaConExito");
                    break;
            }
        } catch (Exception e) {
            throw new ServletException("Error procesando la petición POST", e);
        }
    }


}