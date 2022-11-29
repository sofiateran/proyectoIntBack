package com.example.TeranSofiaIntegrador.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String nombre, apellido, dni, domicilio;
    private Date fechaAlta;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_turno", referencedColumnName ="id")
    private Set<Turno> turno;
}
