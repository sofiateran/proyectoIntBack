package com.example.TeranSofiaIntegrador.Controller;

import com.example.TeranSofiaIntegrador.Daos.OdontologoDaoH2;
import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import com.example.TeranSofiaIntegrador.Servicios.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class OdontologoController {
    private final OdontologoService service;

    @GetMapping("/odontologos")
    public List<Odontologo> listar() {
        return service.listar();
    }

    @PostMapping("/nuevosOdontologos")
    public void agregar(@RequestBody Odontologo paciente) {
        if (paciente != null) service.agregar(paciente);
    }

    @PutMapping("/modificarOdontologos")
    public void modificar(@RequestBody Odontologo paciente) {
        service.modificar(paciente);
    }

    @DeleteMapping("/eliminarOdontologo")
    public void eliminar(@RequestBody int id) {
        service.eliminar(id);
    }

    @GetMapping("/odontologos/{id}")
    public Optional<Odontologo> getByMatricula(@PathVariable int id) {
        return service.getByMatricula(id);
    }
}
