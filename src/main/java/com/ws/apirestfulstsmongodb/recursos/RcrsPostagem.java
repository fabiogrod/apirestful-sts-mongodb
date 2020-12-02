package com.ws.apirestfulstsmongodb.recursos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ws.apirestfulstsmongodb.dominios.Postagem;
import com.ws.apirestfulstsmongodb.recursos.utils.URL;
import com.ws.apirestfulstsmongodb.servicos.SrvcPostagem;

@RestController @RequestMapping(value = "/postagens")
public class RcrsPostagem {
	
	@Autowired private SrvcPostagem srvcPostagem;
		
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity <Postagem> pesquisarId(@PathVariable String id) {		
		Postagem postagem = srvcPostagem.pesquisarId(id);
		return ResponseEntity.ok().body(postagem);
	}
	
	@RequestMapping(value="/findbytitulo", method = RequestMethod.GET)
	public ResponseEntity < List<Postagem> > findByTitulo(@RequestParam(value="text", defaultValue="") String texto) {				
		texto = URL.decodificarParam(texto);		
		List<Postagem> lista = srvcPostagem.findByTitulo(texto);
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value="/pesquisargeral", method = RequestMethod.GET)
	public ResponseEntity < List<Postagem> > pesquisarGeral(
			@RequestParam(value="text", defaultValue="") String texto,
			@RequestParam(value="dataMin", defaultValue="") String dataMin,
			@RequestParam(value="dataMax", defaultValue="") String dataMax) {				
		texto = URL.decodificarParam(texto);
		Date dtMin = URL.converterData(dataMin, new Date(0L));
		Date dtMax = URL.converterData(dataMax, new Date());
		
		List<Postagem> lista = srvcPostagem.pesquisarGeral(texto, dtMin, dtMax);
		return ResponseEntity.ok().body(lista);
	}
}
