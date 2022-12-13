package com.example.TeranSofiaIntegrador.controller;

import com.example.TeranSofiaIntegrador.entidades.Turno;
import com.example.TeranSofiaIntegrador.entidades.TurnoDTO;
import com.example.TeranSofiaIntegrador.exceptions.OdontologoNotFound;
import com.example.TeranSofiaIntegrador.exceptions.PacienteNotFound;
import com.example.TeranSofiaIntegrador.exceptions.ResourceNotFoundException;
import com.example.TeranSofiaIntegrador.servicios.TurnoService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/turnos")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class TurnoController {

    private final TurnoService turnoService;

    private final static Logger logger = LoggerFactory.getLogger(TurnoController.class);
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    public ResponseEntity<List<Turno>> listar() {
        return ResponseEntity.ok(turnoService.listar());
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/nuevosTurnos")
    public ResponseEntity<?> agregar(@RequestBody TurnoDTO turnoRequest) {
        try {
            return ResponseEntity.ok(turnoService.agregar(
                    turnoRequest));
        } catch (OdontologoNotFound | PacienteNotFound e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/modificarTurnos")
    public ResponseEntity<String> modificar(@RequestBody TurnoDTO turno) throws OdontologoNotFound, PacienteNotFound {
        turnoService.modificar(turno);
        return ResponseEntity.ok("Se modifico el turno");
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/eliminarTurnos")
    public ResponseEntity<String> eliminar(@RequestBody int id) throws ResourceNotFoundException {
        turnoService.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos el turno con id: " + id);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/turnos/{id}")
    public ResponseEntity<Optional<Turno>> getById(@PathVariable int id) {
        return ResponseEntity.ok(turnoService.getById(id));
    }
}
