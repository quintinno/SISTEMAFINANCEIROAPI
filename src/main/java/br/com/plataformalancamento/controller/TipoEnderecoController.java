package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.TipoEnderecoEntity;
import br.com.plataformalancamento.service.TipoEnderecoService;

@RestController
@RequestMapping("/tipo-endereco")
public class TipoEnderecoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoEnderecoService tipoEnderecoService;
	
	@GetMapping
	public List<TipoEnderecoEntity> recuperar() {
		return this.tipoEnderecoService.recuperar();
	}

}
