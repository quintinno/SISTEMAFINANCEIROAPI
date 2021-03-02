package br.com.plataformalancamento.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.enumeration.TipoReceitaEnumeration;
import br.com.plataformalancamento.service.TipoReceitaService;

@RestController
@RequestMapping("/tipo-receita")
public class TipoReceitaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoReceitaService tipoReceitaService;
	
	@GetMapping
	public TipoReceitaEnumeration[] recuperar() {
		return this.tipoReceitaService.recuperar();
	}

}
