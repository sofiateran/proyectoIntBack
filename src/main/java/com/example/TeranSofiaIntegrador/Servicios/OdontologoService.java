package com.example.TeranSofiaIntegrador.Servicios;

import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Repositories.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OdontologoService {

    private final OdontologoRepository repository;

    public void agregar(Odontologo odontologo){
        repository.save(odontologo);
    }

    public List<Odontologo> listar()  {
        return repository.findAll();
    }

    public void modificar(Odontologo odontologo){
        repository.save(odontologo);
    }

    public void eliminar(int matricula)  {
        repository.deleteById(matricula);
    }

    public Optional<Odontologo> getById (int id){
        return repository.findById(id);
    }

}