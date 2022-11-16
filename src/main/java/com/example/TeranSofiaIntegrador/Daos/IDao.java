package com.example.TeranSofiaIntegrador.Daos;




import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDao <T> {

    List<T> listar();
    void agregar(T entidad) ;
    void modificar( T entidad) ;
    void eliminar(int id) ;
    Optional<T> getById (int id);

}