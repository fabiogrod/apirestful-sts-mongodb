package com.ws.apirestfulstsmongodb.odt;

import java.io.Serializable;

import com.ws.apirestfulstsmongodb.dominios.Usuario;

public class ODTUsuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String email;
		
	public  ODTUsuario() {}
	
	public ODTUsuario(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
		email = usuario.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
