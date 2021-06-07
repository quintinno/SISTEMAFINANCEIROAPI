package br.com.plataformalancamento.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.DocumentoEntity;
import br.com.plataformalancamento.service.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DocumentoService documentoService;
	
	@PostMapping
	public ResponseEntity<DocumentoEntity> cadastrar(@RequestBody DocumentoEntity documentoEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.documentoService.cadastrar(documentoEntity));
	}

}
