package com.example.TeranSofiaIntegrador.servicios;


import com.example.TeranSofiaIntegrador.entidades.Paciente;
import com.example.TeranSofiaIntegrador.exceptions.ResourceNotFoundException;
import com.example.TeranSofiaIntegrador.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository repository;

    public void agregar(Paciente paciente) throws ResourceNotFoundException {
        repository.save(paciente);
    }

    public List<Paciente> listar()  {
        return repository.findAll();
    }

    public void modificar(Paciente paciente) {
        repository.save(paciente);
    }

    public void eliminar(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El paciente con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }
    public Optional<Paciente> getById (int id){
        return repository.findById(id);
    }

}
