package br.com.plataformalancamento.controller;

import br.com.plataformalancamento.entity.TipoContratoEntity;
import br.com.plataformalancamento.service.TipoContratoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/tipo-contrato")
public class TipoContratoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoContratoService tipoContratoService;
	
	@GetMapping
	public List<TipoContratoEntity> recuperar() {
		return this.tipoContratoService.recuperar();
	}

	@PostMapping
	public ResponseEntity<TipoContratoEntity> cadastrar(@RequestBody TipoContratoEntity tipoContratoEntity) {
		return ResponseEntity.ok().body(this.tipoContratoService.cadastrar(tipoContratoEntity));
	}

}
