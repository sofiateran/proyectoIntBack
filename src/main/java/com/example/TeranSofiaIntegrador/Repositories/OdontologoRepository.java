package com.example.TeranSofiaIntegrador.Repositories;

import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.jar.JarEntry;
@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo,Integer> {
}
