package com.example.TeranSofiaIntegrador.Servicios;

import com.example.TeranSofiaIntegrador.Daos.Dao;
import com.example.TeranSofiaIntegrador.Daos.TurnoDaoH2;
import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import com.example.TeranSofiaIntegrador.Entidades.Turno;
import com.example.TeranSofiaIntegrador.exceptions.OdontologoNotFound;
import com.example.TeranSofiaIntegrador.exceptions.PacienteNotFound;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TurnoService {
    private final static Logger logger = LogManager.getLogger(TurnoDaoH2.class);

    private final Dao<Turno> turnoDaoH2;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    public Turno agregar(int id, int pacienteId, int matricula, LocalDate date) throws OdontologoNotFound, PacienteNotFound {
        var odontologo = odontologoService.getByMatricula(matricula).orElseThrow(OdontologoNotFound::new);
        var paciente = pacienteService.getById(pacienteId).orElseThrow(PacienteNotFound::new);
        var turno = new Turno(id, matricula, pacienteId, Date.valueOf(date));
        turnoDaoH2.add(turno);

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

    public Optional<Turno> getById (int id){
        return turnoDaoH2.getById(id);
    }

}
