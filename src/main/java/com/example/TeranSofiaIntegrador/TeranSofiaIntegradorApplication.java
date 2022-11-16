package com.example.TeranSofiaIntegrador;

import com.example.TeranSofiaIntegrador.Daos.OdontologoDaoH2;
import com.example.TeranSofiaIntegrador.Daos.PacienteDaoH2;
import com.example.TeranSofiaIntegrador.Entidades.Odontologo;
import com.example.TeranSofiaIntegrador.Entidades.Paciente;
import com.example.TeranSofiaIntegrador.Servicios.OdontologoService;
import com.example.TeranSofiaIntegrador.Servicios.PacienteService;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@SpringBootApplication
public class TeranSofiaIntegradorApplication {
	private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";
	public static void main(String[] args) throws IOException, SQLException {
		SpringApplication.run(TeranSofiaIntegradorApplication.class, args);

		startLogger();
		var serviceOdontologo = new OdontologoService(new OdontologoDaoH2());
		var servicePaciente = new PacienteService(new PacienteDaoH2());

		var odontologo1 = new Odontologo(1323, "Sofia","Teran");
		var odontologo2 = new Odontologo(132553, "Juan","Gonzales");
		var odontologo3 = new Odontologo(1666, "Horacion","GarciaMarquez");
//		System.out.println(servicePaciente.modificar());

//        var paciente1 = new Paciente(1,"luciana","jojo","dumas33","45098654","2020-09-08");
//        var paciente2 = new Paciente(2,"marcos","jojo","tukitiki","45092345","2020-10-10");
//        serviceOdontologo.eliminar(1323);
//
//        serviceOdontologo.agregar(odontologo1);
//        serviceOdontologo.agregar(odontologo2);
//        serviceOdontologo.agregar(odontologo3);
//			servicePaciente.eliminar(100);
//
//        odontologo3.setApellido("Garcia");
//        serviceOdontologo.modificar(odontologo3);
//		servicePaciente.agregar(paciente1);
//		servicePaciente.agregar(paciente2);
//		serviceOdontologo.eliminar(0);
//		serviceOdontologo.listar();

//		servicePaciente.listar();



	}

	private static void startLogger() throws IOException {
		var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
		Configurator.initialize(null, source);
	}
	}


