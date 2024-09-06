package com.terminal.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * @author Franklin Pinto
 * @Project Gestion en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */


@ComponentScan(basePackages = "com.terminal.api")
@EntityScan("com.terminal.api.entity") 
@PropertySource("file:C:/Users/Usuario/Documents/workspace/terminal.api/src/main/resources/properties.properties")
@SpringBootApplication(scanBasePackages = {"com.terminal.api.service","com.terminal.api.repository","com.terminal.api"})


public class Application implements CommandLineRunner {

	// Crear un logger para esta clase
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 logger.info("INICIANDO PLATAFORMA DE GESTION DE TERMINALES");
		
	}
	
}
