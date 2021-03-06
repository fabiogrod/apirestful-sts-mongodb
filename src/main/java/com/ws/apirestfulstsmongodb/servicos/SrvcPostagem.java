package com.ws.apirestfulstsmongodb.servicos;

import java.util.Date;
import java.util.List;
//import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.apirestfulstsmongodb.dominios.Postagem;
import com.ws.apirestfulstsmongodb.repositorios.RptrPostagem;
import com.ws.apirestfulstsmongodb.servicos.excecoes.ExcecaoObjetoNaoEncontrado;

@Service public class SrvcPostagem {
	
	@Autowired RptrPostagem rptrPostagem; 
		
	public Postagem pesquisarId (String id) {
		Optional<Postagem> postagem = rptrPostagem.findById(id);
		return postagem.orElseThrow(() -> new ExcecaoObjetoNaoEncontrado("Objeto não encontrado. Id: " + id));
	}
	
	public List<Postagem> findByTitulo(String texto) {
		//return rptrPostagem.findByTituloContainingIgnoreCase(texto);
		return rptrPostagem.pesquisarTitulo(texto);
	}
	
	public List<Postagem> pesquisarGeral(String texto, Date dataMin, Date dataMax) {
						
//		dataMax = new Date(dataMax.getTime() + 24 * 60 * 60 * 1000);
		
//		System.out.println(dataMax);
		
		return rptrPostagem.pesquisarGeral(texto, dataMin, dataMax);
	}
}
