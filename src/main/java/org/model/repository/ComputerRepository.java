package org.model.repository;

import org.model.config.ConnectionFactory;
import org.model.entity.Computer;
import org.model.enums.Category;
import org.model.enums.DiskTechnology;
import org.model.enums.RamTechnology;
import org.model.exceptions.ComputerNotFoundException;
import org.model.vo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerRepository {

    public void insertComputer(Computer computer) {
        String sql = "INSERT INTO computers (marca, categoria, marcaCpu, velocidadCpu, tecnologiaRam, " +
                "capacidadRam, tecnologiaDisco, capacidadDisco, numPuertosUsb, numPuertosHdmi, " +
                "marcaMonitor, pulgadas, precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, computer.getBrand().value());
            statement.setString(2, computer.getCategory().value().getValue());
            statement.setString(3, computer.getProcessor().cpuBrand());
            statement.setString(4, computer.getProcessor().cpuSpeed());
            statement.setString(5, computer.getMemory().ramTechnology().getValue());
            statement.setString(6, computer.getMemory().ramCapacity());
            statement.setString(7, String.valueOf(computer.getStorage().diskTechnology()));
            statement.setString(8, computer.getStorage().diskCapacity());
            statement.setInt(9, computer.getPorts().usbPorts());
            statement.setInt(10, computer.getPorts().hdmiPorts());
            statement.setString(11, computer.getDisplay().monitorBrand());
            statement.setBigDecimal(12, computer.getDisplay().inches());
            statement.setBigDecimal(13, computer.getPrice().value());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw RepositoryException.repositoryGeneralException(e);
        }
    }

    public void deleteComputer(ComputerId id) {
        String sql = "DELETE FROM computers WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id.value());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw ComputerNotFoundException.becauseIdDoesNotExist(id);
            }
        } catch (SQLException e) {
            throw RepositoryException.repositoryGeneralException(e);
        }
    }

    public void updateComputer(Computer computer) {
        String sql = "UPDATE computers SET marca = ?, categoria = ?, marcaCpu = ?, velocidadCpu = ?, " +
                "tecnologiaRam = ?, capacidadRam = ?, tecnologiaDisco = ?, capacidadDisco = ?, " +
                "numPuertosUsb = ?, numPuertosHdmi = ?, marcaMonitor = ?, pulgadas = ?, precio = ? WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, computer.getBrand().value());
            statement.setString(2, computer.getCategory().value().getValue());
            statement.setString(3, computer.getProcessor().cpuBrand());
            statement.setString(4, computer.getProcessor().cpuSpeed());
            statement.setString(5, computer.getMemory().ramTechnology().getValue());
            statement.setString(6, computer.getMemory().ramCapacity());
            statement.setString(7, String.valueOf(computer.getStorage().diskTechnology()));
            statement.setString(8, String.valueOf(computer.getStorage().diskCapacity()));
            statement.setInt(9, computer.getPorts().usbPorts());
            statement.setInt(10, computer.getPorts().hdmiPorts());
            statement.setString(11, computer.getDisplay().monitorBrand());
            statement.setBigDecimal(12, computer.getDisplay().inches());
            statement.setBigDecimal(13, computer.getPrice().value());
            statement.setInt(14, computer.getId().value());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw ComputerNotFoundException.becauseIdDoesNotExist(computer.getId());
            }
        } catch (SQLException e) {
            throw RepositoryException.repositoryGeneralException(e);
        }
    }

    public List<Computer> listAllComputers() {
        String sql = "SELECT id, marca, categoria, marcaCpu, velocidadCpu, tecnologiaRam, capacidadRam, " +
                "tecnologiaDisco, capacidadDisco, numPuertosUsb, numPuertosHdmi, marcaMonitor, pulgadas, precio " +
                "FROM computers";
        List<Computer> computers = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                computers.add(mapResultSetToComputer(resultSet));
            }
        } catch (SQLException e) {
            throw RepositoryException.repositoryGeneralException(e);
        }
        return computers;
    }

    public Computer findById(ComputerId id) {
        String sql = "SELECT id, marca, categoria, marcaCpu, velocidadCpu, tecnologiaRam, capacidadRam, " +
                "tecnologiaDisco, capacidadDisco, numPuertosUsb, numPuertosHdmi, marcaMonitor, pulgadas, precio " +
                "FROM computers WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id.value());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToComputer(resultSet);
                }
                throw ComputerNotFoundException.becauseIdDoesNotExist(id);
            }
        } catch (SQLException e) {
            throw RepositoryException.repositoryGeneralException(e);
        }
    }

    public List<Computer> findByBrand(ComputerBrand brand) {
        String sql = "SELECT id, marca, categoria, marcaCpu, velocidadCpu, tecnologiaRam, capacidadRam, " +
                "tecnologiaDisco, capacidadDisco, numPuertosUsb, numPuertosHdmi, marcaMonitor, pulgadas, precio " +
                "FROM computers WHERE marca ILIKE ?";
        List<Computer> computers = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, brand.value());
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    computers.add(mapResultSetToComputer(resultSet));
                }
            }
        } catch (SQLException e) {
            throw RepositoryException.repositoryGeneralException(e);
        }
        return computers;
    }

    public List<Computer> findByCategory(ComputerCategory category) {
        String sql = "SELECT id, marca, categoria, marcaCpu, velocidadCpu, tecnologiaRam, capacidadRam, " +
                "tecnologiaDisco, capacidadDisco, numPuertosUsb, numPuertosHdmi, marcaMonitor, pulgadas, precio " +
                "FROM computers WHERE categoria = ?::category_enum";
        List<Computer> computers = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category.value().getValue());
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    computers.add(mapResultSetToComputer(resultSet));
                }
            }
        } catch (SQLException e) {
            throw RepositoryException.repositoryGeneralException(e);
        }
        return computers;
    }

    public List<Computer> findByMaxPrice(ComputerPrice maxPrice) {
        String sql = "SELECT id, marca, categoria, marcaCpu, velocidadCpu, tecnologiaRam, capacidadRam, " +
                "tecnologiaDisco, capacidadDisco, numPuertosUsb, numPuertosHdmi, marcaMonitor, pulgadas, precio " +
                "FROM computers WHERE precio <= ?";
        List<Computer> computers = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBigDecimal(1, maxPrice.value());
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    computers.add(mapResultSetToComputer(resultSet));
                }
            }
        } catch (SQLException e) {
            throw RepositoryException.repositoryGeneralException(e);
        }
        return computers;
    }
    private Computer mapResultSetToComputer(ResultSet resultSet) throws SQLException {
        return Computer.createComputer(
                new ComputerId(resultSet.getInt("id")),
                new ComputerBrand(resultSet.getString("marca")),
                new ComputerCategory(Category.fromValue(resultSet.getString("categoria"))),
                new ComputerProcessor(resultSet.getString("marcaCpu"), resultSet.getString("velocidadCpu")),
                new ComputerMemory(
                        RamTechnology.valueOf(resultSet.getString("tecnologiaRam").toUpperCase()),
                        resultSet.getString("capacidadRam")
                ),
                new ComputerStorage(
                        DiskTechnology.valueOf(resultSet.getString("tecnologiaDisco").toUpperCase()),
                        resultSet.getString("capacidadDisco")
                ),
                new ComputerPorts(resultSet.getInt("numPuertosUsb"), resultSet.getInt("numPuertosHdmi")),
                new ComputerDisplay(resultSet.getString("marcaMonitor"), resultSet.getBigDecimal("pulgadas")),
                new ComputerPrice(resultSet.getBigDecimal("precio"))
        );
    }
}