package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.TipoFormaPagamentoEntity;
import br.com.plataformalancamento.service.TipoFormaPagamentoService;

@RestController
@RequestMapping("/tipo-forma-pagamento")
public class TipoFormaPagamentoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoFormaPagamentoService tipoFormaPagamentoService;
	
	@GetMapping
	public List<TipoFormaPagamentoEntity> recuperar() {
		return this.tipoFormaPagamentoService.recuperar();
	}

}
