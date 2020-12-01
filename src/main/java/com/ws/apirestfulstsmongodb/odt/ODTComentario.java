package com.ws.apirestfulstsmongodb.odt;

import java.io.Serializable;
import java.util.Date;

public class ODTComentario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String texto;
	private Date data;
	private ODTAutor autor;
	
	public  ODTComentario() {}

	public ODTComentario(String texto, Date data, ODTAutor autor) {
		super();
		this.texto = texto;
		this.data = data;
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public ODTAutor getAutor() {
		return autor;
	}

	public void setAutor(ODTAutor autor) {
		this.autor = autor;
	}		
}
