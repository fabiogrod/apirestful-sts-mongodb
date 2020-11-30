package com.ws.apirestfulstsmongodb.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ws.apirestfulstsmongodb.dominios.Usuario;

@Repository
public interface RptrUsuario extends MongoRepository<Usuario, String> {

}
