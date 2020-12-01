package com.ws.apirestfulstsmongodb.odt;

import java.io.Serializable;

import com.ws.apirestfulstsmongodb.dominios.Usuario;

public class ODTAutor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public ODTAutor() {}
	
	public ODTAutor(Usuario usuario) {		
		id = usuario.getId();
		nome = usuario.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
