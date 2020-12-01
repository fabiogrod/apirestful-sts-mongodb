package com.ws.apirestfulstsmongodb.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ws.apirestfulstsmongodb.dominios.Postagem;

@Repository
public interface RptrPostagem extends MongoRepository<Postagem, String> {

	List<Postagem> findByTituloContainingIgnoreCase(String texto);
	
}
