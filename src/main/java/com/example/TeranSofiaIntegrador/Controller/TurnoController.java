package com.example.TeranSofiaIntegrador.Controller;

import com.example.TeranSofiaIntegrador.Daos.TurnoDaoH2;
import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Entidades.Turno;
import com.example.TeranSofiaIntegrador.Servicios.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class TurnoController {
    TurnoService turnoService = new TurnoService(new TurnoDaoH2());

    @GetMapping("/turnos")
    public List<Turno> listarOdontologos(){
        return  turnoService.listar();
    }

    @PostMapping("/nuevosTurnos")
    @ResponseStatus(HttpStatus.CREATED)
    public void agregarOdontologo(@RequestBody Turno turno) {
        if (turno != null)
            turnoService.agregar(turno);
    }
    @PutMapping("/modificarTurnos")
    @ResponseStatus(HttpStatus.CREATED)
    public void modificarOdontologos(@RequestBody Turno turno) {
        turnoService.modificar(turno);
    }

    @DeleteMapping("/eliminar")
    public void eliminarOdontologos(@RequestBody int matricula){
        turnoService.eliminar(matricula);
    }

    @GetMapping("/turnos/{id}")
    public Optional<Turno> getById (@PathVariable int id){
        return turnoService.getById(id);

    }
}
