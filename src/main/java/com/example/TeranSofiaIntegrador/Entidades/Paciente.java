package com.example.TeranSofiaIntegrador.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@AllArgsConstructor
@Getter
@Setter
public class Paciente {
    private int id;
    private String nombre, apellido, dni, domicilio;
    private Date fechaAlta;
}
