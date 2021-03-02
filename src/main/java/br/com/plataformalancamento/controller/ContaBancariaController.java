package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.ContaBancariaEntity;
import br.com.plataformalancamento.service.ContaBancariaService;

@RestController
@RequestMapping("/conta-bancaria")
public class ContaBancariaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ContaBancariaService contaBancariaService;

	@PostMapping
	public ResponseEntity<ContaBancariaEntity> cadastrar(@RequestBody ContaBancariaEntity ContaBancariaEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.contaBancariaService.cadastrar(ContaBancariaEntity));
	}
	
	@GetMapping
	public ResponseEntity<List<ContaBancariaEntity>> recuperar() {
		List<ContaBancariaEntity> ContaBancariaEntityList = this.contaBancariaService.recuperar();
		return !ContaBancariaEntityList.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(ContaBancariaEntityList) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}