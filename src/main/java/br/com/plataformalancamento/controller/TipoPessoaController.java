package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.TipoPessoaEntity;
import br.com.plataformalancamento.service.TipoPessoaService;

@RestController
@RequestMapping("/tipo-pessoa")
public class TipoPessoaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoPessoaService tipoPessoaService;
	
	@GetMapping
	public List<TipoPessoaEntity> recuperar() {
		return this.tipoPessoaService.recuperar();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<TipoPessoaEntity> recuperar(@PathVariable Long codigo) {
		TipoPessoaEntity tipoPessoaEntity = this.tipoPessoaService.recuperar(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(tipoPessoaEntity);
	}

}
