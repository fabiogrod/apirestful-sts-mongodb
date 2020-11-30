package com.ws.apirestfulstsmongodb.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.apirestfulstsmongodb.dominios.Usuario;
import com.ws.apirestfulstsmongodb.repositorios.RptrUsuario;

@Service public class SrvcUsuario {
	
	@Autowired RptrUsuario rptrUsuario; 

	public List<Usuario> pesquisar() {
		return rptrUsuario.findAll();
	}
}
