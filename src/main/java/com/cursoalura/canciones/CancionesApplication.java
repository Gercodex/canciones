package com.cursoalura.canciones;

import com.cursoalura.canciones.principal.Principal;
import com.cursoalura.canciones.repository.CantanteRepositorio;
import org.hibernate.event.spi.PreInsertEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CancionesApplication implements CommandLineRunner {

	@Autowired
	private CantanteRepositorio cantanteRepositorio;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CancionesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(cantanteRepositorio);
		principal.mostrarMenu();

	}
}
