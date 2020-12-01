package com.ws.apirestfulstsmongodb.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ws.apirestfulstsmongodb.dominios.Usuario;
import com.ws.apirestfulstsmongodb.odt.ODTUsuario;
import com.ws.apirestfulstsmongodb.servicos.SrvcUsuario;

@RestController @RequestMapping(value = "/usuarios")
public class RcrsUsuario {
	
	@Autowired private SrvcUsuario srvcUsuario;
	
	// @GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity < List<ODTUsuario> > pesquisar() {
//		Usuario paula = new Usuario("1", "Paula", "maria@gmail.com");
//		Usuario fernanda = new Usuario("2", "Fernanda", "fernanda@gmail.com");
				
		List<Usuario> lista = srvcUsuario.pesquisar();
		List<ODTUsuario> listaODT = lista.stream().map(x -> new ODTUsuario(x)).collect(Collectors.toList());
//		lista.addAll(Arrays.asList(paula, fernanda));
		return ResponseEntity.ok().body(listaODT);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity <ODTUsuario> pesquisarId(@PathVariable String id) {		
		Usuario usuario = srvcUsuario.pesquisarId(id);
		return ResponseEntity.ok().body(new ODTUsuario(usuario));
	}
	
//	@PostMapping
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity <ODTUsuario> inserir(@RequestBody ODTUsuario odtUsuario) {		
		Usuario usuario = srvcUsuario.ODTUsuario(odtUsuario);
		usuario = srvcUsuario.inserir(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
