package com.example.TeranSofiaIntegrador.Repositories;

import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import com.example.TeranSofiaIntegrador.Entidades.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<Turno,Integer> {
}
