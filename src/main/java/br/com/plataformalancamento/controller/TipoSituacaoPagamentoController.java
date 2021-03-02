package br.com.plataformalancamento.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;
import br.com.plataformalancamento.service.TipoSituacaoPagamentoService;

@RestController
@RequestMapping("/tipo-situacao-pagamento")
public class TipoSituacaoPagamentoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoSituacaoPagamentoService tipoSituacaoPagamentoService;
	
	@GetMapping
	public TipoSituacaoPagamentoEnumeration[] recuperar() {
		return this.tipoSituacaoPagamentoService.recuperar();
	}

}
