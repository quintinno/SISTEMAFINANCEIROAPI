package br.com.plataformalancamento.controller;

import java.io.Serializable;
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

import br.com.plataformalancamento.dto.CartaoBancarioDTO;
import br.com.plataformalancamento.entity.CartaoBancarioEntity;
import br.com.plataformalancamento.service.CartaoBancarioService;

@RestController
@RequestMapping("/cartao-bancario")
public class CartaoBancarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CartaoBancarioService cartaoBancarioService;

	@PostMapping
	public ResponseEntity<CartaoBancarioEntity> cadastrar(@RequestBody CartaoBancarioEntity cartaoBancarioEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.cartaoBancarioService.cadastrar(cartaoBancarioEntity));
	}
	
	@GetMapping
	public ResponseEntity<List<CartaoBancarioEntity>> recuperar() {
		List<CartaoBancarioEntity> cartaoBancarioEntityList = this.cartaoBancarioService.recuperar();
		return !cartaoBancarioEntityList.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(cartaoBancarioEntityList) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	public ResponseEntity<List<CartaoBancarioDTO>> recuperarCartaoBancarioVinculadoContaBancaria( @PathVariable Long codigoCartaoBancario ) {
		return ResponseEntity.ok().body(cartaoBancarioService.recuperarCartaoBancarioVinculadoContaBancaria(codigoCartaoBancario));
	}

}