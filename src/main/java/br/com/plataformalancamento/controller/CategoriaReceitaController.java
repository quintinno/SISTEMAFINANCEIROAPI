package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.CategoriaReceitaEntity;
import br.com.plataformalancamento.service.CategoriaReceitaService;

@RestController
@RequestMapping("/categoria-receita")
public class CategoriaReceitaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaReceitaService categoriaReceitaService;
	
	@GetMapping
	public ResponseEntity<List<CategoriaReceitaEntity>> recuperar() {
		return ResponseEntity.status(HttpStatus.OK).body(this.categoriaReceitaService.recuperar());
	}
	
	@DeleteMapping("{codigo}")
	public ResponseEntity<Void> remover(@PathVariable Long codigo) {
		this.categoriaReceitaService.remover(codigo);
		return ResponseEntity.ok().build();
	}

}
