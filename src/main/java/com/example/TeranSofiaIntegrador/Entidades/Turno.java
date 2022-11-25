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
@AllArgsConstructor
public class Turno {
    @Id
    private int id;
    private int matricula_odontologo;
    private int id_paciente;
    private Date fecha;
}

