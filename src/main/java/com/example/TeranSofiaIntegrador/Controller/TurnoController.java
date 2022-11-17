package com.example.TeranSofiaIntegrador.Controller;

import com.example.TeranSofiaIntegrador.Daos.TurnoDaoH2;
import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Entidades.Turno;
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
    private final TurnoService service;

    @GetMapping("/turnos")
    public List<Turno> listar() {
        return service.listar();
    }

    @PostMapping("/turnos")
    public ResponseEntity<?> listar(@RequestBody Turno turnoRequest) {
        try {
            return ResponseEntity.of(Optional.of(service.agregar(turnoRequest.getId(),
                    turnoRequest.getId_paciente(),
                    turnoRequest.getMatricula_odontologo(),
                    turnoRequest.getFecha())));
        } catch (OdontologoNotFound | PacienteNotFound e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

