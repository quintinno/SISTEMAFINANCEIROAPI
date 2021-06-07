package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.ComposicaoSalarioEntity;
import br.com.plataformalancamento.service.ComposicaoSalarialService;

@RestController
@RequestMapping("/composicao-salarial")
public class ComposicaoSalarialController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ComposicaoSalarialService composicaoSalarialService;
	
	@GetMapping
	public ResponseEntity<List<ComposicaoSalarioEntity>> recuperar() {
		return ResponseEntity.ok().body(this.composicaoSalarialService.recuperar());
	}
	
}
