package com.example.TeranSofiaIntegrador.Controller;

import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Servicios.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
public class OdontologoController {
    private final OdontologoService service;

    @GetMapping("/odontologos")
    public ResponseEntity<List<Odontologo>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/nuevosOdontologos")
    public ResponseEntity<String> agregar(@RequestBody Odontologo odontologo) {
        service.agregar(odontologo);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modificarOdontologos")
    public ResponseEntity<String> modificar(@RequestBody Odontologo odontologo) {
        service.modificar(odontologo);
        return ResponseEntity.ok("Se modifico el odontologo");
    }

    @DeleteMapping("/eliminarOdontologo")
    public ResponseEntity<String>  eliminar(@RequestBody int id) {
        service.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos el odontologo con id: " + id);
    }

    @GetMapping("/odontologos/{id}")
    public ResponseEntity<Optional<Odontologo>> getByMatricula(@PathVariable int matricula) {
        return ResponseEntity.ok(service.getById(matricula));
    }
}
