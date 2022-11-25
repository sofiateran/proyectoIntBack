package com.example.TeranSofiaIntegrador.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Odontologo {
    @Id
    private int matricula;
    private String nombre,apellido;
}
