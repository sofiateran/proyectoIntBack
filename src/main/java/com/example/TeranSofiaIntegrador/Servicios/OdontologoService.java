package com.example.TeranSofiaIntegrador.Servicios;

import com.example.TeranSofiaIntegrador.Daos.OdontologoDaoH2;
import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OdontologoService {
    private final static Logger logger = LogManager.getLogger(OdontologoDaoH2.class);

    private final OdontologoDaoH2 odontologoDaoH2;

    public void agregar(Odontologo odontologo){
        odontologoDaoH2.agregar(odontologo);
    }

    public List<Odontologo> listar()  {
        return odontologoDaoH2.listar();
    }

    public void modificar(Odontologo odontologo){
        odontologoDaoH2.modificar(odontologo);
    }

    public void eliminar(int matricula)  {
        odontologoDaoH2.eliminar(matricula);
    }

    public Optional<Odontologo> getByMatricula (int matricula){
        return  odontologoDaoH2.getById(matricula);
    }

}