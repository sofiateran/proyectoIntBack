package com.example.TeranSofiaIntegrador.Controller;

import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import com.example.TeranSofiaIntegrador.Servicios.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin

public class PacienteController {
    private final PacienteService pacienteService;

    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> listar() {
        return ResponseEntity.ok(pacienteService.listar());
    }

    @PostMapping("/nuevosPacientes")
    public ResponseEntity<String> agregar(@RequestBody Paciente paciente) {
        pacienteService.agregar(paciente);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modificarPacientes")
    public ResponseEntity<String> modificar(@RequestBody Paciente paciente) {
        pacienteService.modificar(paciente);
        return ResponseEntity.ok("Se modifico el odontologo");
    }

    @DeleteMapping("/eliminarPaciente")
    public ResponseEntity<String> eliminar(@RequestBody int id) {
        pacienteService.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos el paciente con id: " + id);
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Optional<Paciente>> getById(@PathVariable int id) {
        return ResponseEntity.ok(pacienteService.getById(id));
    }
}