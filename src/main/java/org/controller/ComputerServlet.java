package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.model.entity.Computer;
import org.model.enums.Category;
import org.model.enums.DiskTechnology;
import org.model.enums.RamTechnology;
import org.model.exceptions.DomainException;
import org.model.repository.ComputerRepository;
import org.model.vo.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

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

    private void insertComputer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String brand = request.getParameter("marca");
            String category = request.getParameter("categoria");
            String cpuBrand = request.getParameter("marcaCpu");
            String cpuSpeed = request.getParameter("velocidadCpu");
            String ramTechnology = request.getParameter("tecnologiaRam");
            String ramCapacity = request.getParameter("capacidadRam");
            String diskTechnology = request.getParameter("tecnologiaDisco");
            String diskCapacity = request.getParameter("capacidadDisco");
            String usbPorts = request.getParameter("numPuertosUsb");
            String hdmiPorts = request.getParameter("numPuertosHdmi");
            String monitorBrand = request.getParameter("marcaMonitor");
            String inches = request.getParameter("pulgadas");
            String price = request.getParameter("precio");

            Computer newComputer = Computer.createComputerWithoutId(
                    new ComputerBrand(brand),
                    new ComputerCategory(Category.fromValue(category)),
                    new ComputerProcessor(cpuBrand, cpuSpeed),
                    new ComputerMemory(RamTechnology.valueOf(ramTechnology.toUpperCase()), ramCapacity),
                    new ComputerStorage(DiskTechnology.valueOf(diskTechnology.toUpperCase()), diskCapacity),
                    new ComputerPorts(Integer.parseInt(usbPorts), Integer.parseInt(hdmiPorts)),
                    new ComputerDisplay(monitorBrand, new BigDecimal(inches)),
                    new ComputerPrice(new BigDecimal(price))
            );
            computerRepository.insertComputer(newComputer);
            response.sendRedirect("/menu.jsp");
        } catch (DomainException e) {
            request.setAttribute("errorMessage", e.getMessage());
            showAddForm(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Error en el formato de los datos numéricos");
            showAddForm(request, response);
        }
    }

    private void showDeleteConfirmation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ComputerId computerId = new ComputerId(id);
            Computer computer = computerRepository.findById(computerId);
            request.setAttribute("computer", computer);
            dispatcher = request.getRequestDispatcher("jsp/computer/remove.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/menu.jsp");
        } catch (DomainException e) {
            request.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("jsp/computer/searchDelete.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void deleteComputer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ComputerId computerId = new ComputerId(id);
            computerRepository.deleteComputer(computerId);
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
            ComputerId computerId = new ComputerId(id);
            Computer computer = computerRepository.findById(computerId);
            request.setAttribute("computer", computer);
            dispatcher = request.getRequestDispatcher("jsp/computer/modify.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/menu.jsp");
        } catch (DomainException e) {
            request.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("jsp/computer/searchModify.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void updateComputer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String brand = request.getParameter("marca");
            String category = request.getParameter("categoria");
            String cpuBrand = request.getParameter("marcaCpu");
            String cpuSpeed = request.getParameter("velocidadCpu");
            String ramTechnology = request.getParameter("tecnologiaRam");
            String ramCapacity = request.getParameter("capacidadRam");
            String diskTechnology = request.getParameter("tecnologiaDisco");
            String diskCapacity = request.getParameter("capacidadDisco");
            String usbPorts = request.getParameter("numPuertosUsb");
            String hdmiPorts = request.getParameter("numPuertosHdmi");
            String monitorBrand = request.getParameter("marcaMonitor");
            String inches = request.getParameter("pulgadas");
            String price = request.getParameter("precio");

            Computer updatedComputer = Computer.createComputer(
                    new ComputerId(id),
                    new ComputerBrand(brand),
                    new ComputerCategory(Category.fromValue(category)),
                    new ComputerProcessor(cpuBrand, cpuSpeed),
                    new ComputerMemory(RamTechnology.valueOf(ramTechnology.toUpperCase()), ramCapacity),
                    new ComputerStorage(DiskTechnology.valueOf(diskTechnology.toUpperCase()), diskCapacity),
                    new ComputerPorts(Integer.parseInt(usbPorts), Integer.parseInt(hdmiPorts)),
                    new ComputerDisplay(monitorBrand, new BigDecimal(inches)),
                    new ComputerPrice(new BigDecimal(price))
            );
            computerRepository.updateComputer(updatedComputer);
            response.sendRedirect("/menu.jsp");
        } catch (DomainException e) {
            request.setAttribute("errorMessage", e.getMessage());
            showEditForm(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Error en el formato de los datos numéricos");
            showEditForm(request, response);
        }
    }

    private void searchComputersByBrand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String brand = request.getParameter("marca");
        List<Computer> computers = computerRepository.findByBrand(new ComputerBrand(brand));
        request.setAttribute("computers", computers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/computer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listComputers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Computer> computers = computerRepository.listAllComputers();
        request.setAttribute("computers", computers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/computer/list.jsp");
        dispatcher.forward(request, response);
    }
}