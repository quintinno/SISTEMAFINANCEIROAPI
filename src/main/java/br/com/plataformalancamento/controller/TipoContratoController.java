package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.TipoContratoEntity;
import br.com.plataformalancamento.service.TipoContratoService;

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

}
