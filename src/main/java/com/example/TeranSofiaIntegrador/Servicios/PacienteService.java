package com.example.TeranSofiaIntegrador.Servicios;


import com.example.TeranSofiaIntegrador.Daos.Dao;
import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PacienteService {
    private final Dao<Paciente> pacienteDaoH2;

    public void agregar(Paciente paciente) {
        pacienteDaoH2.add(paciente);
    }

    public List<Paciente> listar() {
        return pacienteDaoH2.getAll();
    }

    public void modificar(Paciente paciente) {
        pacienteDaoH2.update(paciente);
    }

    public void eliminar(int id) {
        pacienteDaoH2.delete(id);
    }

}
