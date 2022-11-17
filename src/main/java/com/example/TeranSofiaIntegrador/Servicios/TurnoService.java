package com.example.TeranSofiaIntegrador.Servicios;

import com.example.TeranSofiaIntegrador.Daos.TurnoDaoH2;
import com.example.TeranSofiaIntegrador.Entidades.Turno;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class TurnoService {
    private final static Logger logger = LogManager.getLogger(TurnoDaoH2.class);

    private final TurnoDaoH2 turnoDaoH2;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    public Turno agregar(int id, int matricula, int pacienteId, Date fecha) throws OdontologoNotFound, PacienteNotFound {
        var odontologo = odontologoService.getById(matricula).orElseThrow(OdontologoNotFound::new);
        var paciente = pacienteService.getById(pacienteId).orElseThrow(PacienteNotFound::new);
        var turno = new Turno(id, matricula, pacienteId, (java.sql.Date) fecha);
        turnoDaoH2.agregar(turno);

        return turno;
    }

    public List<Turno> listar()  {
        return turnoDaoH2.listar();
    }

    public void modificar(Turno turno) {
        turnoDaoH2.modificar(turno);
    }

    public void eliminar(int id)  {
        turnoDaoH2.eliminar(id);
    }


    public Optional<Turno> getById(int id) {
        return turnoDaoH2.getById(id);
    }
}
