package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.net.URI;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		ReceitaEntity receitaEntityCadastrada = this.receitaService.cadastrar(receitaEntity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(receitaEntityCadastrada.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(receitaEntityCadastrada);
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> remover(@PathVariable Long codigo) {
		this.receitaService.remover(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("{codigo}")
	public ResponseEntity<ReceitaEntity> recuperar(@PathVariable Long codigo) {
		return ResponseEntity.ok(this.receitaService.recuperar(codigo));
	}

	@GetMapping("/totalizador-receita-recebida")
	public ResponseEntity<Double> recuperarTotalizadorReceitasRecebidas() {
		return ResponseEntity.ok().body(this.receitaService.recuperarTotalizadorReceitaRecebida());
	}

	@GetMapping("/totalizador-receita-pendente")
	public ResponseEntity<Double> recuperarTotalizadorReceitasPendentes() {
		return ResponseEntity.ok().body(this.receitaService.recuperarTotalizadorReceitaPendente());
	}


}
