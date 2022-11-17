package com.example.TeranSofiaIntegrador.Daos;

import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Entidades.Paciente;

import com.example.TeranSofiaIntegrador.Entidades.Turno;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.TeranSofiaIntegrador.Daos.H2Manager.getConnection;

@Repository
public class PacienteDaoH2 implements Dao<Paciente> {
    private static final Logger logger = LogManager.getLogger(PacienteDaoH2.class);

    private static final String INSERT = "INSERT INTO PACIENTES (ID, NOMBRE, APELLIDO,  DNI, DOMICILIO , FECHAALTA) VALUES (?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE PACIENTES SET NOMBRE = ?, APELLIDO = ?, DOMICILIO = ?, DNI = ?, FECHAALTA = ? WHERE ID = ?;";

    private static final String SELECT_ALL = "SELECT * FROM PACIENTES;";
    private static final String SELECT_BY_ID = "SELECT * FROM PACIENTES WHERE id = ?; ";
    private static final String DELETE = "DELETE FROM PACIENTES WHERE ID = ?;";

    @Override
    public List<Paciente> getAll() {
        var pacientes = new ArrayList<Paciente>();
        try (var connection = getConnection()) {
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                logger.info("id: " + resultSet.getInt(1) + " nombre: " + resultSet.getString(2) + " apellido: " + resultSet.getString(3) + " dni: " + resultSet.getString(4) + " domicilio: " + resultSet.getString(5) + " fecha de alta: " + resultSet.getDate(6));
                pacientes.add(new Paciente(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6)));
            }
            if (pacientes.size() == 0) {
                logger.info("no hay pacientes en la lista");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return pacientes;
    }

    @Override
    public void agregar(Paciente paciente) {

        try (var connection = getConnection()) {
            var agregar = connection.prepareStatement(INSERT);
            agregar.setInt(1,paciente.getId());
            agregar.setString(2, paciente.getNombre());
            agregar.setString(3, paciente.getApellido());
            agregar.setString(5, paciente.getDomicilio());
            agregar.setString(4, paciente.getDni());
            agregar.setDate(6,  paciente.getFechaAlta());

            agregar.execute();
            logger.info("Se agrego correctamente a la base de datos!");
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
    }


    @Override
    public void modificar(Paciente paciente) {
        try {
            Connection connection =  connection = getConnection();
            var psUpdate = connection.prepareStatement(UPDATE);

            psUpdate.setString(1, paciente.getNombre());
            psUpdate.setString(2, paciente.getApellido());
            psUpdate.setString(4, paciente.getDomicilio());
            psUpdate.setString(3, paciente.getDni());
            psUpdate.setDate(5, paciente.getFechaAlta());
            psUpdate.setInt(6,paciente.getId());

            psUpdate.execute();
            logger.info("Se modifico correctamente!");
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
    }



    @Override
    public void eliminar(int id) {
        try {
            Connection connection = getConnection();
            var eliminar = connection.prepareStatement(DELETE);

            var selectQuery = "SELECT * FROM PACIENTES WHERE id = ?;";
            var empQuery = connection.prepareStatement(selectQuery);
            empQuery.setInt(1, id);
            var resultSet = empQuery.executeQuery();
            eliminar.setInt(1,id);
            eliminar.execute();
            logger.info("se eliminó correctamente!");
        } catch (SQLException e) {
                logger.error(e.getMessage());
            }
    }

    @Override
    public Optional<Paciente> getById(int id) {
        try {
            var connection = H2Manager.getConnection();
            var statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1,id);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                logger.info("id: " + resultSet.getInt(1) + " nombre: " + resultSet.getString(2) + " apellido: " + resultSet.getString(3) + " domicilio: " + resultSet.getString(4) + " dni: " + resultSet.getString(5) + " fecha de alta: " + resultSet.getDate(6));
                return Optional.of(new Paciente(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6)));
            }

        } catch (SQLException e) {
            logger.info(e.getMessage());
        }

        return Optional.empty();

    }

    }


