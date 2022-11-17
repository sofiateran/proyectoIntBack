package com.example.TeranSofiaIntegrador.Daos;




import com.example.TeranSofiaIntegrador.Entidades.Turno;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDao <T> {

    List<T> listar() throws SQLException;
    void agregar(T entidad) throws SQLException;
    void modificar( T entidad) throws SQLException;
    void eliminar(int id) throws SQLException;

        Optional<T> getById(int id);
}