package com.example.TeranSofiaIntegrador.Controller;

import com.example.TeranSofiaIntegrador.Entidades.Turno;
import com.example.TeranSofiaIntegrador.Servicios.OdontologoNotFound;
import com.example.TeranSofiaIntegrador.Servicios.PacienteNotFound;
import com.example.TeranSofiaIntegrador.Servicios.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@AllArgsConstructor
public class TurnoController {

    private final TurnoService turnoService;


    @GetMapping("/turnos")
    public List<Turno> listarOdontologos(){
        return  turnoService.listar();
    }

    @PostMapping("/nuevosTurnos")
    public ResponseEntity<?> agregar(@RequestBody Turno turnoRequest) {
        try {
            return ResponseEntity.of(Optional.of(turnoService.agregar(
                    turnoRequest.getId(),
                    turnoRequest.getMatricula_odontologo(),
                    turnoRequest.getId_paciente(),
                    turnoRequest.getFecha())));
        } catch (OdontologoNotFound | PacienteNotFound e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/modificarTurnos")
    @ResponseStatus(HttpStatus.CREATED)
    public void modificarTurnos(@RequestBody Turno turno) {
        turnoService.modificar(turno);
    }

    @DeleteMapping("/eliminarTurnos")
    public void eliminarTurnos(@RequestBody int matricula){
        turnoService.eliminar(matricula);
    }

    @GetMapping("/turnos/{id}")
    public Optional<Turno> getById (@PathVariable int id){
        return turnoService.getById(id);

    }
}
