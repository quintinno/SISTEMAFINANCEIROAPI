package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.EnderecoEntity;
import br.com.plataformalancamento.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoControler implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public ResponseEntity<List<EnderecoEntity>> recuperar() {
		return ResponseEntity.status(HttpStatus.OK).body(this.enderecoService.recuperar());
	}

}
