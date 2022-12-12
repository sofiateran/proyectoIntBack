package com.example.TeranSofiaIntegrador.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Odontologo {
    @Id
    private int matricula;
    private String nombre,apellido;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_turno")
    @JsonIgnore
    private Set<Turno> turno;
}
