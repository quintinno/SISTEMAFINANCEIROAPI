package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.TipoContaBancariaEntity;
import br.com.plataformalancamento.service.TipoContaBancariaService;

@RestController
@RequestMapping("/tipo-conta-bancaria")
public class TipoContaBancariaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoContaBancariaService tipoContaBancariaService;
	
	@GetMapping
	public List<TipoContaBancariaEntity> recuperar() {
		return this.tipoContaBancariaService.recuperar();
	}

}
