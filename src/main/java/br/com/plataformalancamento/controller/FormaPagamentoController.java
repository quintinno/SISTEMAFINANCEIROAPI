package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.FormaPagamentoEntity;
import br.com.plataformalancamento.service.FormaPagamentoService;

@RestController
@RequestMapping("/forma-pagamento")
public class FormaPagamentoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FormaPagamentoService tipoFormaPagamentoService;
	
	@GetMapping
	public List<FormaPagamentoEntity> recuperar() {
		return this.tipoFormaPagamentoService.recuperar();
	}

}
