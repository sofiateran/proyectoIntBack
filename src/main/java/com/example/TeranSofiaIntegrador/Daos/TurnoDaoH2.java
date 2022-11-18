package com.example.TeranSofiaIntegrador.Daos;

import com.example.TeranSofiaIntegrador.Entidades.Turno;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static com.example.TeranSofiaIntegrador.Daos.H2Manager.getConnection;

@Repository

public class TurnoDaoH2 implements IDao<Turno>{
    private static final Logger logger =  LogManager.getLogger(OdontologoDaoH2.class);

    private static final String INSERT = "INSERT INTO TURNOS ( id,matricula_odontologo, id_paciente, fecha) VALUES (?,?,?,?);";
    private static final String UPDATE = "UPDATE TURNOS SET matricula_odontologo = ?, id_paciente = ?, fecha = ?  WHERE id = ?;";

    private static final String SELECT_ALL = "SELECT * FROM TURNOS;";
    private static final String SELECT_BY_ID = "SELECT * FROM TURNOS WHERE id = ?; ";
    private static final String DELETE = "DELETE FROM TURNOS WHERE id = ?;";

    @Override
    public List<Turno> listar() {
        List<Turno> turnos = new ArrayList<>();
        try {
            Connection connection = getConnection();
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                logger.info(" id: " + resultSet.getInt(1) + " matricula_odontologo: " + resultSet.getInt(2) + " id_paciente " + resultSet.getInt(3) + " fecha " + resultSet.getDate(4));
                turnos.add(new Turno(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getDate(4)));
            }
            if (turnos.size() == 0) {
                logger.info("no hay turnos en la lista");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return turnos;
    }

    @Override
    public void agregar(Turno turno) {
        try {
            Connection connection = getConnection();
            var agregar = connection.prepareStatement(INSERT);
            agregar.setInt(1, turno.getId());
            agregar.setInt(2, turno.getMatricula_odontologo());
            agregar.setInt(3, turno.getId_paciente());
            agregar.setDate(4,turno.getFecha());

            agregar.execute();
            logger.info("Se agrego correctamente a la base de datos!");
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
    }


    @Override
    public void modificar(Turno turno) {
        try {
            Connection connection =  connection = getConnection();
            var psUpdate = connection.prepareStatement(UPDATE);
            psUpdate.setInt(1, turno.getMatricula_odontologo());
            psUpdate.setInt(2, turno.getId_paciente());
            psUpdate.setDate(3, turno.getFecha());
            psUpdate.setInt(4, turno.getId());


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

            String selectQuery = "SELECT * FROM TURNOS WHERE id = ?;";
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
    public Optional<Turno> getById(int id) {
        try {
            var connection = getConnection();
            var statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1,id);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                logger.info(" id: " + resultSet.getInt(1) + " matricula_odontologo: " + resultSet.getInt(2) + " id_paciente " + resultSet.getInt(3) + " fecha " + resultSet.getDate(4));
                Optional.of(new Turno(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getDate(4)));
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return Optional.empty();

    }
}
