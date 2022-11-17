package com.example.TeranSofiaIntegrador.Servicios;


import com.example.TeranSofiaIntegrador.Daos.OdontologoDaoH2;
import com.example.TeranSofiaIntegrador.Daos.PacienteDaoH2;
import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PacienteService {

    private final static Logger logger = LogManager.getLogger(OdontologoDaoH2.class);

    private final PacienteDaoH2 pacienteDaoH2;

    public void agregar(Paciente paciente){
        pacienteDaoH2.agregar(paciente);
    }

    public List<Paciente> listar()  {
        return pacienteDaoH2.listar();
    }

    public void modificar(Paciente paciente) {
        pacienteDaoH2.modificar(paciente);
    }

    public void eliminar(int id)  {
        pacienteDaoH2.eliminar(id);
    }
    public Optional<Paciente> getById (int id){
        return pacienteDaoH2.getById(id);
    }

}
