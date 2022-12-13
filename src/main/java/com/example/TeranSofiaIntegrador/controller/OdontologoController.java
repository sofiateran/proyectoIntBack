package com.example.TeranSofiaIntegrador.controller;

import com.example.TeranSofiaIntegrador.entidades.Odontologo;
import com.example.TeranSofiaIntegrador.exceptions.ResourceNotFoundException;
import com.example.TeranSofiaIntegrador.servicios.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/odontologos")
@RestController
@AllArgsConstructor

public class OdontologoController {
    private final OdontologoService service;

    @GetMapping("/")
    public ResponseEntity<List<Odontologo>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/nuevosOdontologos")
    public ResponseEntity<String> agregar(@RequestBody Odontologo odontologo) throws ResourceNotFoundException {
        service.agregar(odontologo);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modificarOdontologos")
    public ResponseEntity<String> modificar(@RequestBody Odontologo odontologo) {
        service.modificar(odontologo);
        return ResponseEntity.ok("Se modifico el odontologo");
    }

    @DeleteMapping("/eliminarOdontologo")
    public ResponseEntity<String>  eliminar(@RequestBody int id) throws ResourceNotFoundException {
        service.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos el odontologo con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Odontologo>> getByMatricula(@PathVariable int matricula) {
        return ResponseEntity.ok(service.getById(matricula));
    }

}
