package com.example.TeranSofiaIntegrador.Servicios;

import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import com.example.TeranSofiaIntegrador.Entidades.Turno;
import com.example.TeranSofiaIntegrador.Exceptions.OdontologoNotFound;
import com.example.TeranSofiaIntegrador.Exceptions.PacienteNotFound;
import com.example.TeranSofiaIntegrador.Repositories.TurnoRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class TurnoService {

    private final TurnoRepository repository;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    public Turno agregar(int id, Odontologo odontologo, Paciente paciente, Date fecha) throws OdontologoNotFound, PacienteNotFound {
        var odontologo1 = odontologoService.getById(odontologo.getMatricula()).orElseThrow(OdontologoNotFound::new);
        var paciente1 = pacienteService.getById(paciente.getId()).orElseThrow(PacienteNotFound::new);
        var turno = new Turno(id, odontologo1, paciente1, fecha);
        return repository.save(turno);

    }

    public List<Turno> listar()  {
        return repository.findAll();
    }

    public void modificar(Turno turno) {
        repository.save(turno);
    }

    public void eliminar(int id)  {
        repository.deleteById(id);
    }


    public Optional<Turno> getById(int id) {
        return repository.findById(id);
    }
}
