package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.ParcelamentoEntity;
import br.com.plataformalancamento.service.ParcelamentoService;

@RestController
@RequestMapping("/parcelamento")
public class ParcelamentoController implements Serializable {
	
	@Autowired
	private ParcelamentoService parcelamentoService;
	
	private static final long serialVersionUID = 1L;
	
	@GetMapping
	public ResponseEntity<List<ParcelamentoEntity>> recuperar() {
		return ResponseEntity.ok(this.parcelamentoService.recuperar());
	}
	
	@GetMapping("{codigo}")
	public ResponseEntity<ParcelamentoEntity> recuperar(@PathVariable Long codigo) {
		return ResponseEntity.ok(this.parcelamentoService.recuperar(codigo));
	}

}
