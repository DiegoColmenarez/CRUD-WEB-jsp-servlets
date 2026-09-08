package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.model.entity.User;
import org.model.exceptions.DomainException;
import org.model.repository.UserRepository;
import org.model.vo.UserEmail;
import org.model.vo.UserId;
import org.model.vo.UserName;
import org.model.vo.UserPassword;

import java.io.IOException;
import java.util.List;

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
                    showAddForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    showDeleteConfirmation(request, response);
                    break;
                case "list":
                    listUsers(request, response);
                    break;
                default:
                    response.sendRedirect("/menu.jsp");
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
                    insertUser(request, response);
                    break;
                case "update":
                    updateUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/menu.jsp?mensaje=OperacionRealizadaConExito");
                    break;
            }
        } catch (Exception e) {
            throw new ServletException("Error procesando la petición POST", e);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/user/add.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("nombre");
            String lastName = request.getParameter("apellido");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User newUser = User.createUser(
                    new UserName(name),
                    new UserName(lastName),
                    new UserEmail(email),
                    new UserPassword(password)
            );
            userRepository.insertUser(newUser);
            response.sendRedirect("/menu.jsp");
        } catch (DomainException e) {
            request.setAttribute("errorMessage", e.getMessage());
           showAddForm(request, response);
        }
    }
    private void searchUsersByName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        List<User> users = userRepository.findByName(new UserName(nombre));
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteConfirmation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            UserId userId = new UserId(id);
            User user = userRepository.findById(userId);
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("jsp/user/remove.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/menu.jsp");
        } catch (DomainException e) {
            request.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("jsp/user/searchDelete.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            UserId userId = new UserId(id);
            userRepository.deleteUser(userId);
            response.sendRedirect("/menu.jsp");
        } catch (DomainException e) {
            request.setAttribute("errorMessage", e.getMessage());
            showDeleteConfirmation(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/menu.jsp");
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            UserId userId = new UserId(id);
            User user = userRepository.findById(userId);
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("jsp/user/modify.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/menu.jsp");
        } catch (DomainException e) {
            request.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("jsp/user/searchModify.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("nombre");
            String lastName = request.getParameter("apellido");
            String email = request.getParameter("email");
            User updatedUser = User.createUser(
                    new UserId(id),
                    new UserName(name),
                    new UserName(lastName),
                    new UserEmail(email)
            );
            userRepository.updateUser(updatedUser);
            response.sendRedirect("/menu.jsp");
        } catch (DomainException e) {
            request.setAttribute("errorMessage", e.getMessage());
            showEditForm(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/menu.jsp");
        }
    }
    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = userRepository.listAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/user/list.jsp");
        dispatcher.forward(request, response);
    }
}