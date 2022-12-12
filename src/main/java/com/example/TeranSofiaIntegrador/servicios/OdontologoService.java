package com.example.TeranSofiaIntegrador.servicios;

import com.example.TeranSofiaIntegrador.entidades.Odontologo;
import com.example.TeranSofiaIntegrador.exceptions.ResourceNotFoundException;
import com.example.TeranSofiaIntegrador.repositories.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OdontologoService {

    private final OdontologoRepository repository;

    public void agregar(Odontologo odontologo) throws ResourceNotFoundException {
        repository.save(odontologo);

    }

    public List<Odontologo> listar()  {
        return repository.findAll();
    }

    public void modificar(Odontologo odontologo){
        repository.save(odontologo);
    }

    public void eliminar(int matricula) throws ResourceNotFoundException {
        repository.findById(matricula).orElseThrow(()-> new ResourceNotFoundException("El odontologo con id: " + matricula +" no existe en la base de datos"));
        repository.deleteById(matricula);
    }

    public Optional<Odontologo> getById (int id){
        return repository.findById(id);
    }

}