package com.example.TeranSofiaIntegrador.Daos;

import com.example.TeranSofiaIntegrador.Entidades.Odontologo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import static com.example.TeranSofiaIntegrador.Daos.H2Manager.getConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class OdontologoDaoH2 implements IDao<Odontologo>{

    private static final Logger logger =  LogManager.getLogger(OdontologoDaoH2.class);

    private static final String INSERT = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?);";
    private static final String UPDATE = "UPDATE ODONTOLOGOS SET NOMBRE = ?, APELLIDO = ?  WHERE MATRICULA = ?;";

    private static final String SELECT_ALL = "SELECT * FROM ODONTOLOGOS;";
    private static final String SELECT_BY_ID = "SELECT FROM ODONTOLOGOS WHERE MATRICULA = ?; ";
    private static final String DELETE = "DELETE FROM ODONTOLOGOS WHERE MATRICULA = ?;";

    @Override
    public List<Odontologo> listar() {
        List<Odontologo> odontologos = null;
        try {
            Connection connection = getConnection();
            var statement = connection.createStatement();
            odontologos = new ArrayList<>();
            var resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                logger.info(" matricula: " + resultSet.getInt(1) + " nombre: " + resultSet.getString(2) + " apellido " + resultSet.getString(3));
                odontologos.add(new Odontologo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            if (odontologos.size() == 0) {
                logger.info("no hay odontologos en la lista");
            }
        }


        return odontologos;
    }

    @Override
    public void agregar(Odontologo odontologo) {

        try {
            Connection connection = getConnection();
            var agregar = connection.prepareStatement(INSERT);
            agregar.setInt(1, odontologo.getMatricula());
            agregar.setString(2, odontologo.getNombre());
            agregar.setString(3, odontologo.getApellido());

            agregar.execute();
            logger.info("Se agrego correctamente a la base de datos!");
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void modificar(Odontologo odontologo){
        try {
            Connection connection = getConnection();
            var psUpdate = connection.prepareStatement(UPDATE);
            psUpdate.setString(1,odontologo.getNombre());
            psUpdate.setString(2,odontologo.getApellido());
            psUpdate.setInt(3,odontologo.getMatricula());

            psUpdate.execute();
            logger.info("Se modifico correctamente!");
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void eliminar(int matricula) {
        try {
            Connection connection =   getConnection();
            var eliminar = connection.prepareStatement(DELETE);

            var id = matricula;

            String selectQuery = "SELECT * FROM ODONTOLOGOS WHERE MATRICULA = ?;";
            var empQuery = connection.prepareStatement(selectQuery);
            empQuery.setInt(1, id);
            var resultSet = empQuery.executeQuery();
            eliminar.setInt(1, matricula);
            eliminar.execute();
            logger.info("se eliminó correctamente!");


        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

    }

    public Optional<Odontologo> getById(int matricula){
        try {
            var connection = getConnection();
            var statement = connection.prepareStatement(SELECT_BY_ID);
           statement.setInt(1,matricula);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                logger.info(" matricula: " + resultSet.getInt(1) + " nombre: " + resultSet.getString(2) + " apellido: " + resultSet.getString(3));
                return Optional.of(new Odontologo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            logger.info("no hay odontologos en la lista");
        }
        return Optional.empty();
    }


}
