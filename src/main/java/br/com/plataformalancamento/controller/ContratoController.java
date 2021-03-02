package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.ContratoEntity;
import br.com.plataformalancamento.service.ContratoService;

@RestController
@RequestMapping("/contrato")
public class ContratoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ContratoService contratoService;

	@PostMapping
	public ResponseEntity<ContratoEntity> cadastrar(@RequestBody ContratoEntity contratoEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.contratoService.cadastrar(contratoEntity));
	}
	
	@GetMapping
	public ResponseEntity<List<ContratoEntity>> recuperar() {
		List<ContratoEntity> contratoEntityList = this.contratoService.recuperar();
		return !contratoEntityList.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(contratoEntityList) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<ContratoEntity> recuperar( @PathVariable Long codigo ) {
		return ResponseEntity.status(HttpStatus.OK).body(this.contratoService.recuperar(codigo));
	}

}