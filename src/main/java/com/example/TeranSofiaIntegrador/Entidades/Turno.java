package com.example.TeranSofiaIntegrador.Entidades;

import java.time.LocalDate;

public record Turno(int id, Odontologo odontologo, Paciente paciente, LocalDate fecha) {
}
