package com.example.TeranSofiaIntegrador.Entidades;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
@Getter
@Setter
@Entity
@AllArgsConstructor
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private int matricula_odontologo;
    private int id_paciente;
    private Date fecha;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "matricula_odontologo" , referencedColumnName ="matricula")
//    private Odontologo odontologo;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_paciente" , referencedColumnName ="id")
//    private Paciente paciente;


}

