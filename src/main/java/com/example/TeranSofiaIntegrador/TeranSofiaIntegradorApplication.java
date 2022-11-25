package com.example.TeranSofiaIntegrador;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class TeranSofiaIntegradorApplication {
	private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";
	public static void main(String[] args) throws IOException, SQLException {
		SpringApplication.run(TeranSofiaIntegradorApplication.class, args);
		startLogger();



	}

	private static void startLogger() throws IOException {
		var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
		Configurator.initialize(null, source);
	}
	}


