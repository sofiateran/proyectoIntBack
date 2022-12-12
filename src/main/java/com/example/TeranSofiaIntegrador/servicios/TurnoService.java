package com.example.TeranSofiaIntegrador.servicios;

import com.example.TeranSofiaIntegrador.entidades.Turno;
import com.example.TeranSofiaIntegrador.entidades.TurnoDTO;
import com.example.TeranSofiaIntegrador.exceptions.OdontologoNotFound;
import com.example.TeranSofiaIntegrador.exceptions.PacienteNotFound;
import com.example.TeranSofiaIntegrador.exceptions.ResourceNotFoundException;
import com.example.TeranSofiaIntegrador.repositories.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class TurnoService {

    private final TurnoRepository repository;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    public Turno agregar(TurnoDTO turnoDTO) throws OdontologoNotFound, PacienteNotFound {
        var odontologo1 = odontologoService.getById(turnoDTO.matriculaOdontologo()).orElseThrow(OdontologoNotFound::new);
        var paciente1 = pacienteService.getById(turnoDTO.idPaciente()).orElseThrow(PacienteNotFound::new);
        var turno = new Turno(turnoDTO.id(), odontologo1, paciente1, turnoDTO.fecha());
        return repository.save(turno);
    }

    public List<Turno> listar()  {
        return repository.findAll();
    }

    public Turno modificar(TurnoDTO turnoDTO) throws OdontologoNotFound, PacienteNotFound {
        var odontologo1 = odontologoService.getById(turnoDTO.matriculaOdontologo()).orElseThrow(OdontologoNotFound::new);
        var paciente1 = pacienteService.getById(turnoDTO.idPaciente()).orElseThrow(PacienteNotFound::new);
        var turno = new Turno(turnoDTO.id(), odontologo1, paciente1, turnoDTO.fecha());
        return repository.save(turno);
    }
    public void eliminar(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El turno con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }


    public Optional<Turno> getById(int id) {
        return repository.findById(id);
    }
}
