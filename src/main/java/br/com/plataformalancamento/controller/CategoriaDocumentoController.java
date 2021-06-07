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

import br.com.plataformalancamento.entity.CategoriaDocumentoModel;
import br.com.plataformalancamento.service.CategoriaDocumentoService;

@RestController
@RequestMapping("/categoria-documento")
public class CategoriaDocumentoController implements Serializable {
	
	@Autowired
	private CategoriaDocumentoService categoriaDocumentoService;
	
	private static final long serialVersionUID = 1L;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDocumentoModel>> recuperar() {
		List<CategoriaDocumentoModel> categoriaDocumentoModelList = this.categoriaDocumentoService.recuperar();
		return !categoriaDocumentoModelList.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(categoriaDocumentoModelList) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/categoria-documento-sem-vinculo-pessoa/{nomePessoa}")
	public ResponseEntity<List<CategoriaDocumentoModel>> recuperarDocumentosNaoVinculadoPessoa(@PathVariable String nomePessoa) {
		return ResponseEntity.ok().body(this.categoriaDocumentoService.recuperarCategoriaDocumentosNaoVinculadoPessoa(nomePessoa));
	}

}
