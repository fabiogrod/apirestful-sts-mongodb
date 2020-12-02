package com.ws.apirestfulstsmongodb.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ws.apirestfulstsmongodb.dominios.Postagem;

@Repository
public interface RptrPostagem extends MongoRepository<Postagem, String> {

	List<Postagem> findByTituloContainingIgnoreCase(String texto);
	
	//Operador de Avaliaçõo Expressão Regular { <field>: { $regex: /patern/, $options: '<options>' } }
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Postagem> pesquisarTitulo(String texto);
	
	//Operador lógico E - { $and: [ { <expression1> }, { <expression2> } , ... , { <expressionN> } ] }
	//Operador de comparação MAIOR IGUAL {field: {$gte: value} }
	//Operador de comparação MENOR IGUAL { field: { $lte: value} }
	//Operador lógico OU{ $or: [ { <expression1> }, { <expression2> }, ... , { <expressionN> } ] }
	 @Query("{ $and: [ { data: { $gte: ?1 } }, { data: { $lte: ?2 } }, { $or: [ { titulo: { $regex: ?0, $options: 'i' } }, { corpo: { $regex: ?0, $options: 'i' } }, { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Postagem> pesquisarGeral(String texto, Date dataMin, Date dataMax);
}
