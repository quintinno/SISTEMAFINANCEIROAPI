package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.FaturaBancariaModel;
import br.com.plataformalancamento.service.FaturaBancariaService;

@RestController
@RequestMapping("/fatura-bancaria")
public class FaturaBancariaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FaturaBancariaService faturaBancariaService;
	
	@GetMapping
	public ResponseEntity<List<FaturaBancariaModel>> recuperar() {
		return ResponseEntity.ok().body(this.faturaBancariaService.recuperar());
	}
	
}
