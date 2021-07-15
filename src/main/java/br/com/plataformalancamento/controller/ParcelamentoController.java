package br.com.plataformalancamento.controller;

import br.com.plataformalancamento.entity.ParcelamentoEntity;
import br.com.plataformalancamento.service.ParcelamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

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

	@GetMapping("/receita/{codigoReceita}")
	public ResponseEntity<List<ParcelamentoEntity>> recuperarPorCodigoReceita( @PathVariable Long codigoReceita) {
		return ResponseEntity.ok().body(this.parcelamentoService.recuperarPorCodigoReceita(codigoReceita));
	}
	
	@GetMapping("{codigo}")
	public ResponseEntity<ParcelamentoEntity> recuperar(@PathVariable Long codigo) {
		return ResponseEntity.ok(this.parcelamentoService.recuperar(codigo));
	}
	
	@PutMapping
	public ResponseEntity<ParcelamentoEntity> registrarPagamentoParcela(@RequestBody ParcelamentoEntity parcelamentoEntity) {
		return ResponseEntity.ok(this.parcelamentoService.registrarPagamentoParcela(parcelamentoEntity));
	}
	
	@DeleteMapping("{codigo}")
	public ResponseEntity<Void> remover(@PathVariable Long codigo) {
		this.parcelamentoService.remover(codigo);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("recuperar-totalizador-parcelamento-despesa-fixa-mensal")
	public ResponseEntity<Double> recuperarTotalizadorParcelamentoDespesaFixaMensal() {
		return ResponseEntity.ok().body(this.parcelamentoService.recuperarTotalizadorParcelamentoDespesaFixaMensal());
	}

	@GetMapping("/despesa-fixa/{codigoParcelamento}")
	public ResponseEntity<ParcelamentoEntity> recuperarParcelamentoPorCodigo(@PathVariable Long codigoParcelamento) {
		return ResponseEntity.ok(this.parcelamentoService.recuperarParcelamentoPorCodigo(codigoParcelamento));
	}

}
