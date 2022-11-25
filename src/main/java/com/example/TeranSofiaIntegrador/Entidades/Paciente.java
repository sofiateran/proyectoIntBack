package com.example.TeranSofiaIntegrador.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
@Getter
@Setter
@Entity
public class Paciente {
    @Id
    private int id;
    private String nombre, apellido, dni, domicilio;
    private Date fechaAlta;
}
