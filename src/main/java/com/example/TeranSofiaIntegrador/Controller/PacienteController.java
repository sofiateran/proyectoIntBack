package com.example.TeranSofiaIntegrador.Controller;

import com.example.TeranSofiaIntegrador.Daos.OdontologoDaoH2;
import com.example.TeranSofiaIntegrador.Daos.PacienteDaoH2;
import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import com.example.TeranSofiaIntegrador.Servicios.OdontologoService;
import com.example.TeranSofiaIntegrador.Servicios.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@AllArgsConstructor
public class PacienteController {
    private final PacienteService pacienteService;

    @GetMapping("/pacientes")
    public List<Paciente> listar() {
        return pacienteService.listar();
    }
    @PostMapping("/nuevosPacientes")
    @ResponseStatus(HttpStatus.CREATED)
    public void agregar(@RequestBody Paciente paciente) {
        if (paciente != null) pacienteService.agregar(paciente);
    }
    @PutMapping("/modificarPacientes")
    public void modificar(@RequestBody Paciente paciente) {
        pacienteService.modificar(paciente);
    }

    @DeleteMapping("/eliminarPaciente")
    public void eliminar(@RequestBody int id) {
        pacienteService.eliminar(id);
    }
}
