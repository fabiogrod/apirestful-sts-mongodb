package com.ws.apirestfulstsmongodb.servicos;

import java.util.List;
//import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.apirestfulstsmongodb.dominios.Usuario;
import com.ws.apirestfulstsmongodb.odt.ODTUsuario;
import com.ws.apirestfulstsmongodb.repositorios.RptrUsuario;
import com.ws.apirestfulstsmongodb.servicos.excecoes.ExcecaoObjetoNaoEncontrado;

@Service public class SrvcUsuario {
	
	@Autowired RptrUsuario rptrUsuario; 

	public List<Usuario> pesquisar() {
		return rptrUsuario.findAll();
	}
	
	public Usuario pesquisarId (String id) {
		Optional<Usuario> usuario = rptrUsuario.findById(id);
//		return usuario.orElseThrow(() -> new NoSuchElementException("Objeto não encontrado. Id: " + id));
		
		if (usuario.isPresent()) {
			return usuario.get();
		}
		else {
			throw new ExcecaoObjetoNaoEncontrado("Objeto não encontrado. Id: " + id);
		}
	}
	
	public void deletar(String id) {
		pesquisarId(id);
		rptrUsuario.deleteById(id);
	}
	
	public Usuario inserir(Usuario usuario) {
		return rptrUsuario.insert(usuario);
	}
	
	public Usuario atualizar(Usuario usuario) {
		Usuario novoUsuario = pesquisarId(usuario.getId());
		atualizarDados(novoUsuario, usuario);
		return rptrUsuario.save(novoUsuario);
	}
	
	private void atualizarDados(Usuario novoUsuario, Usuario usuario) {
		novoUsuario.setNome(usuario.getNome());
		novoUsuario.setEmail(usuario.getEmail());
	}

	public Usuario ODTUsuario (ODTUsuario odtUsuario) {
		return new Usuario(odtUsuario.getId(), odtUsuario.getNome(), odtUsuario.getEmail());
	}
}
