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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.PessoaEntity;
import br.com.plataformalancamento.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController implements Serializable {
	
	@Autowired
	private PessoaService pessoaService;
	
	private static final long serialVersionUID = 1L;
	
	@PostMapping
	public ResponseEntity<PessoaEntity> cadastrar(@RequestBody PessoaEntity PessoaEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.pessoaService.cadastrar(PessoaEntity));
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaEntity>> recuperar() {
		List<PessoaEntity> PessoaEntityList = this.pessoaService.recuperar();
		return !PessoaEntityList.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(PessoaEntityList) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/{codigo}")
	public PessoaEntity recuperar(@PathVariable Long codigo) {
		return this.pessoaService.recuperar(codigo);
	}
	
	@GetMapping("/filtro")
	public PessoaEntity recuperar(@RequestParam("nome") String nome) {
		return this.pessoaService.recuperar(nome);
	}
	
	@PostMapping("/{codigo}")
	public PessoaEntity atualizar(@PathVariable Long codigo, @RequestBody PessoaEntity PessoaEntity) {
		return this.pessoaService.atualizar(codigo, PessoaEntity);
	}
	
	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		this.pessoaService.remover(codigo);
	}
	
	@GetMapping("/juridica")
	public List<PessoaEntity> recuperarPessoaJuridica() {
		return this.pessoaService.recuperarPessoaJuridica();
	}
	
	@GetMapping("/fisica")
	public List<PessoaEntity> recuperarPessoaFisica() {
		return this.pessoaService.recuperarPessoaFisica();
	}
	
	@GetMapping("/recuperar-pessoa-financeira-sistema")
	public ResponseEntity<List<PessoaEntity>> recuperarPessoaFinanceiraSistema() {
		return ResponseEntity.ok().body(this.pessoaService.recuperarPessoaFinanceiraSistema());
	}
	
	@PutMapping
	public ResponseEntity<PessoaEntity> registrarPagamentoParcela(@RequestBody PessoaEntity pessoaEntity) {
		return ResponseEntity.ok(this.pessoaService.alterar(pessoaEntity));
	}

}
