package com.example.TeranSofiaIntegrador.Servicios;

import com.example.TeranSofiaIntegrador.Daos.Dao;
import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OdontologoService {
    private final Dao<Odontologo> odontologoDaoH2;

    public void agregar(Odontologo odontologo) {
        odontologoDaoH2.add(odontologo);
    }

    public List<Odontologo> listar() {
        return odontologoDaoH2.getAll();
    }

    public void modificar(Odontologo odontologo) {
        odontologoDaoH2.update(odontologo);
    }

    public void eliminar(int matricula) {
        odontologoDaoH2.delete(matricula);
    }

    public Optional<Odontologo> getByMatricula(int matricula) {
        return odontologoDaoH2.getByMatricula(matricula);
    }

}