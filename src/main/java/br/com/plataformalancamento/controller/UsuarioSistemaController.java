package br.com.plataformalancamento.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.dto.UsuarioSistemaDTO;
import br.com.plataformalancamento.entity.UsuarioSistemaEntity;
import br.com.plataformalancamento.service.UsuarioSistemaService;

@RestController
@RequestMapping("/usuario-sistema")
public class UsuarioSistemaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioSistemaService usuarioSistemaService;
	
	@PostMapping
	public ResponseEntity<UsuarioSistemaEntity> autenticarDadosUsuarioSistema(@RequestParam String identificador, @RequestParam String senha) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioSistemaService.autenticarDadosUsuarioSistema(identificador, senha));
	}
	
	@PostMapping("/cadastrado")
	public ResponseEntity<Boolean> isUsuarioCadastrado(@RequestBody UsuarioSistemaDTO usuarioSistemaDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(this.usuarioSistemaService.isUsuarioCadastrado(usuarioSistemaDTO));
	}
	
}
