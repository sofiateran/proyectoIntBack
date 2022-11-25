package com.example.TeranSofiaIntegrador.Repositories;

import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
}
