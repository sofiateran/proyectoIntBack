package com.example.TeranSofiaIntegrador.Daos;




import java.sql.SQLException;
import java.util.List;

public interface IDao <T> {

    List<T> listar() throws SQLException;
    void agregar(T entidad) throws SQLException;
    void modificar( T entidad) throws SQLException;
    void eliminar(int id) throws SQLException;

}