package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.net.URI;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.plataformalancamento.entity.UsuarioSistemaEntity;
import br.com.plataformalancamento.service.UsuarioSistemaSecurityService;
import br.com.plataformalancamento.service.UsuarioSistemaService;

@RestController
@RequestMapping("/usuario-sistema")
public class UsuarioSistemaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioSistemaService usuarioSistemaService;
	
	@Autowired
	private UsuarioSistemaSecurityService usuarioSistemaSecurityService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioSistemaEntity>> recuperar() {
		return ResponseEntity.ok(this.usuarioSistemaService.recuperar());
	}
	
	@PostMapping
	public ResponseEntity<UsuarioSistemaEntity> cadastrar(@Valid @RequestBody UsuarioSistemaEntity usuarioSistemaEntity) throws ParseException {
		UsuarioSistemaEntity usuarioSistemaEntityCadastrado = this.usuarioSistemaService.cadastrar(usuarioSistemaEntity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioSistemaEntityCadastrado.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(usuarioSistemaEntityCadastrado);
	}
	
	// TODO -- Excluir esse metodo apos os testes
	// TODO -- http://localhost:9090/usuario-sistema/usuariosistemasecurity/00000000000
	@SuppressWarnings("rawtypes")
	@GetMapping("/usuariosistemasecurity/{username}")
	public ResponseEntity recuperarUsuarioSistemaSecurity(@PathVariable String username) {
		return ResponseEntity.ok(this.usuarioSistemaSecurityService.loadUserByUsername(username));
	}
	
}
