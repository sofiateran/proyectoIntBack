package com.example.TeranSofiaIntegrador.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@AllArgsConstructor
@Setter
@Getter
public class Turno {
    private int id;
    private int matricula_odontologo;
    private int id_paciente;
    private Date fecha;
}
