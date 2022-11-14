package com.example.TeranSofiaIntegrador.Controller;

import com.example.TeranSofiaIntegrador.Daos.OdontologoDaoH2;
import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import com.example.TeranSofiaIntegrador.Servicios.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OdontologoController {
    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
    @GetMapping("/odontologos")
    public List<Odontologo> listarOdontologos(){
        return  odontologoService.listar();
    }

    @PostMapping("/nuevosOdontologos")
    @ResponseStatus(HttpStatus.CREATED)
    public void agregarOdontologo(@RequestBody Odontologo odontologo) {
        if (odontologo != null)
        odontologoService.agregar(odontologo);
    }

    @PutMapping("/modificarOdontologos")
    @ResponseStatus(HttpStatus.CREATED)
    public void modificarOdontologos(@RequestBody Odontologo odontologo) {
        odontologoService.modificar(odontologo);
    }

    @DeleteMapping("/eliminar")
    public void eliminarOdontologos(@RequestBody int matricula){
        odontologoService.eliminar(matricula);
    }

}
