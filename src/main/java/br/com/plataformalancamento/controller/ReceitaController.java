package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.text.ParseException;
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

import br.com.plataformalancamento.entity.ReceitaEntity;
import br.com.plataformalancamento.service.ReceitaService;

@RestController
@RequestMapping("/receita")
public class ReceitaController implements Serializable {
	
	@Autowired
	private ReceitaService receitaService;
	
	private static final long serialVersionUID = 1L;
	
	@GetMapping
	public ResponseEntity<List<ReceitaEntity>> recuperar() {
		return ResponseEntity.ok(this.receitaService.recuperar());
	}
	
	@GetMapping("fixa")
	public ResponseEntity<List<ReceitaEntity>> recuperarReceitasFixas() {
		return ResponseEntity.ok(this.receitaService.recuperarReceitasFixas());
	}
	
	@GetMapping("variavel")
	public ResponseEntity<List<ReceitaEntity>> recuperarReceitasVariaveis() {
		return ResponseEntity.ok(this.receitaService.recuperarReceitasVariaveis());
	}
	
	@PostMapping
	public ResponseEntity<ReceitaEntity> cadastrar(@RequestBody ReceitaEntity receitaEntity) throws ParseException {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.receitaService.cadastrar(receitaEntity));
	}
	
	@GetMapping("{codigo}")
	public ResponseEntity<ReceitaEntity> recuperar(@PathVariable Long codigo) {
		return ResponseEntity.ok(this.receitaService.recuperar(codigo));
	}

}
