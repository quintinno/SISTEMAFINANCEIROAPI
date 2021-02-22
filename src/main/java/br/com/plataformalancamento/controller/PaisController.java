package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.PaisEntity;
import br.com.plataformalancamento.service.PaisService;

@RestController
@RequestMapping("/pais")
public class PaisController implements Serializable {
	
	@Autowired
	private PaisService paisService;
	
	private static final long serialVersionUID = 1L;
	
	@PostMapping
	public ResponseEntity<PaisEntity> cadastrar(@RequestBody PaisEntity paisEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.paisService.cadastrar(paisEntity));
	}
	
	@GetMapping
	public ResponseEntity<List<PaisEntity>> recuperar() {
		List<PaisEntity> paisEntityList = this.paisService.recuperar();
		return !paisEntityList.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(paisEntityList) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/{codigo}")
	public PaisEntity recuperar(@PathVariable Long codigo) {
		return this.paisService.recuperar(codigo);
	}
	
	@GetMapping("/filtro")
	public PaisEntity recuperar(@RequestParam("nome") String nome) {
		return this.paisService.recuperar(nome);
	}
	
	@GetMapping("/filtro/parametros")
	public PaisEntity recuperar(
		@RequestParam(value = "codigo", required = false) Long codigo, 
		@RequestParam(value = "nome", required = false) String nome) {
		return this.paisService.recuperar(codigo, nome);
	}
	
	@PostMapping("/{codigo}")
	public PaisEntity atualizar(@PathVariable Long codigo, @RequestBody PaisEntity paisEntity) {
		return this.paisService.atualizar(codigo, paisEntity);
	}
	
	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		this.paisService.remover(codigo);
	}

}
