package com.example.TeranSofiaIntegrador.controller;

import com.example.TeranSofiaIntegrador.entidades.Paciente;
import com.example.TeranSofiaIntegrador.exceptions.ResourceNotFoundException;
import com.example.TeranSofiaIntegrador.servicios.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor

public class PacienteController {
    private final PacienteService pacienteService;

    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> listar() {
        return ResponseEntity.ok(pacienteService.listar());
    }

    @PostMapping("/nuevosPacientes")
    public ResponseEntity<String> agregar(@RequestBody Paciente paciente) throws ResourceNotFoundException {
        pacienteService.agregar(paciente);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modificarPacientes")
    public ResponseEntity<String> modificar(@RequestBody Paciente paciente) {
        pacienteService.modificar(paciente);
        return ResponseEntity.ok("Se modifico el paciente");
    }

    @DeleteMapping("/eliminarPaciente")
    public ResponseEntity<String> eliminar(@RequestBody int id) throws ResourceNotFoundException {
        pacienteService.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos el paciente con id: " + id);
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Optional<Paciente>> getById(@PathVariable int id) {
        return ResponseEntity.ok(pacienteService.getById(id));
    }


}