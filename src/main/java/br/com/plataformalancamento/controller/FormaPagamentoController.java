package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.FormaPagamentoEntity;
import br.com.plataformalancamento.service.FormaPagamentoService;

@RestController
@RequestMapping("/forma-pagamento")
public class FormaPagamentoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FormaPagamentoService formaPagamentoService;
	
	@GetMapping
	public List<FormaPagamentoEntity> recuperar() {
		return this.formaPagamentoService.recuperar();
	}

	@PostMapping
	public ResponseEntity<FormaPagamentoEntity> cadstrar(@Valid @RequestBody FormaPagamentoEntity formaPagamentoEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.formaPagamentoService.cadastrar(formaPagamentoEntity));
	}
	
	@GetMapping("/ativo")
	public ResponseEntity<List<FormaPagamentoEntity>> recuperarFormaPagamentoAtivo() {
		return ResponseEntity.ok().body(this.formaPagamentoService.recuperarFormaPagamentoAtivo());
	}

}
