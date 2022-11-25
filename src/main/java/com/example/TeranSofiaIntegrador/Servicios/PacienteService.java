package com.example.TeranSofiaIntegrador.Servicios;


import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import com.example.TeranSofiaIntegrador.Repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository repository;

    public void agregar(Paciente paciente){
        repository.save(paciente);
    }

    public List<Paciente> listar()  {
        return repository.findAll();
    }

    public void modificar(Paciente paciente) {
        repository.save(paciente);
    }

    public void eliminar(int id)  {
        repository.deleteById(id);
    }
    public Optional<Paciente> getById (int id){
        return repository.findById(id);
    }

}
