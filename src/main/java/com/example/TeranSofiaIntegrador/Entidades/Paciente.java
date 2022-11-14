package com.example.TeranSofiaIntegrador.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.sql.*;
@Getter
@Setter
@AllArgsConstructor
public class Paciente {
    private int id;
    private String nombre, apellido, domicilio, dni;
    private Date fechaAlta;

}
