package com.ws.apirestfulstsmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ws.apirestfulstsmongodb.dominios.Postagem;
import com.ws.apirestfulstsmongodb.dominios.Usuario;
import com.ws.apirestfulstsmongodb.repositorios.RptrPostagem;
import com.ws.apirestfulstsmongodb.repositorios.RptrUsuario;

@Configuration
public class Instanciacao implements CommandLineRunner{

	@Autowired private RptrUsuario rptrUsuario;
	@Autowired private RptrPostagem rptrPostagem;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		rptrUsuario.deleteAll();
		rptrPostagem.deleteAll();
		
		Usuario paula = new Usuario( null, "Paula", "paula@gmail.com");
		Usuario fernanda = new Usuario( null, "Fernanda", "fernanda@gmail.com");
		Usuario andressa = new Usuario( null, "Andressa", "andressa@gmail.com");
		
		Postagem post1 = new Postagem(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP, abraços", paula);
		
		Postagem post2 = new Postagem(null, sdf.parse("23/03/2018"), "Salve pra geral", "Na luta pra aprender essa caralha!!!", paula);
		
		rptrUsuario.saveAll(Arrays.asList(paula, fernanda, andressa));
		rptrPostagem.saveAll(Arrays.asList(post1, post2));
	}
}
