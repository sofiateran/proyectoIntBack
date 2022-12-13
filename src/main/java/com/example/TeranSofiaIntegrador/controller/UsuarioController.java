package com.example.TeranSofiaIntegrador.controller;

import com.example.TeranSofiaIntegrador.jwt.MyUserDetailsService;
import com.example.TeranSofiaIntegrador.roles.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UsuarioController {
    private MyUserDetailsService us;

    @PostMapping("/registrar")
    public ResponseEntity<?> agregarUsuario(@RequestBody Usuario usuario) {
        us.saveUsuario(usuario);
        return new ResponseEntity<>("Usuario agregado", null, HttpStatus.CREATED);
    }
}