package com.example.TeranSofiaIntegrador.repositories;

import com.example.TeranSofiaIntegrador.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
}
