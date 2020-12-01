package com.ws.apirestfulstsmongodb.recursos.excecoes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ws.apirestfulstsmongodb.servicos.excecoes.ExcecaoObjetoNaoEncontrado;

@ControllerAdvice
public class ManipuladorExcecoesRcrs {
	
	@ExceptionHandler(ExcecaoObjetoNaoEncontrado.class)
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ExcecaoObjetoNaoEncontrado e, HttpServletRequest requisicao) {
		
		HttpStatus estado = HttpStatus.NOT_FOUND;
		
		ErroPadrao err = new ErroPadrao(System.currentTimeMillis(), estado.value(), "Não encontrado", e.getMessage(), requisicao.getRequestURI());
		
		return ResponseEntity.status(estado).body(err);
	}
}
