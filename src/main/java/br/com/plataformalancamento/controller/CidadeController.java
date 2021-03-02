package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.CidadeEntity;
import br.com.plataformalancamento.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping
	public ResponseEntity<List<CidadeEntity>> recuperar() {
		List<CidadeEntity> cidadeEntityList = this.cidadeService.recuperar();
		return !cidadeEntityList.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(cidadeEntityList) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
