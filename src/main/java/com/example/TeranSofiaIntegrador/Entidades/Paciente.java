package com.example.TeranSofiaIntegrador.Entidades;

import java.sql.Date;

public record Paciente(int id, String nombre, String apellido, String domicilio, String dni, Date fechaAlta) {
}
