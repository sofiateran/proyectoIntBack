package com.example.TeranSofiaIntegrador.Controller;

import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import com.example.TeranSofiaIntegrador.Entidades.Turno;
import com.example.TeranSofiaIntegrador.Exceptions.OdontologoNotFound;
import com.example.TeranSofiaIntegrador.Exceptions.PacienteNotFound;
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
    public ResponseEntity<List<Turno>> listar() {
        return ResponseEntity.ok(turnoService.listar());
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
    public ResponseEntity<String> modificar(@RequestBody Turno turno) {
        turnoService.modificar(turno);
        return ResponseEntity.ok("Se modifico el turno");
    }

    @DeleteMapping("/eliminarTurnos")
    public ResponseEntity<String> eliminar(@RequestBody int id) {
        turnoService.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos el turno con id: " + id);
    }

    @GetMapping("/turnos/{id}")
    public ResponseEntity<Optional<Turno>> getById(@PathVariable int id) {
        return ResponseEntity.ok(turnoService.getById(id));
    }
}
