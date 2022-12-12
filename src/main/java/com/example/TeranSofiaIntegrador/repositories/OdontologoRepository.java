package com.example.TeranSofiaIntegrador.repositories;

import com.example.TeranSofiaIntegrador.entidades.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo,Integer> {
}
