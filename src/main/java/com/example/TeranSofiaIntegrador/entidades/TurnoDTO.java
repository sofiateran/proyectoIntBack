package com.example.TeranSofiaIntegrador.entidades;

import java.sql.Date;

public record TurnoDTO(int id, int matriculaOdontologo, int idPaciente, Date fecha) {
}
