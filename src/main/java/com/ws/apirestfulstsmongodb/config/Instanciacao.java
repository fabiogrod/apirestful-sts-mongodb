package com.ws.apirestfulstsmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ws.apirestfulstsmongodb.dominios.Usuario;
import com.ws.apirestfulstsmongodb.repositorios.RptrUsuario;

@Configuration
public class Instanciacao implements CommandLineRunner{

	@Autowired private RptrUsuario rptrUsuario;
	
	@Override
	public void run(String... args) throws Exception {
		
		rptrUsuario.deleteAll();
		
		Usuario paula = new Usuario( null, "Paula", "paula@gmail.com");
		Usuario fernanda = new Usuario( null, "Fernanda", "fernanda@gmail.com");
		Usuario andressa = new Usuario( null, "Andressa", "andressa@gmail.com");
		
		rptrUsuario.saveAll(Arrays.asList(paula, fernanda, andressa));
	}
}
