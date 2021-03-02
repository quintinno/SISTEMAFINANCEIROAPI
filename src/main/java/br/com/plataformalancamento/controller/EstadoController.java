package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.EstadoEntity;
import br.com.plataformalancamento.service.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController implements Serializable {
	
	@Autowired
	private EstadoService estadoService;
	
	private static final long serialVersionUID = 1L;
	
	@GetMapping
	public List<EstadoEntity> recuperar() {
		return this.estadoService.recuperar();
	}
	
	@PostMapping
	public EstadoEntity cadastrar(@RequestBody EstadoEntity estadoEntity) {
		System.out.println(estadoEntity);
		return this.estadoService.cadastrar(estadoEntity);
	}

}
