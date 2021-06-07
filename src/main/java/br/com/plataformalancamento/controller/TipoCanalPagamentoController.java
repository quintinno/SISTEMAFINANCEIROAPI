package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.dto.TipoCanalPagamentoDTO;
import br.com.plataformalancamento.service.TipoCanalPagamentoService;

@RestController
@RequestMapping("/tipo-canal-pagamento")
public class TipoCanalPagamentoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoCanalPagamentoService tipoCanalPagamentoService;
	
	@GetMapping
	public List<TipoCanalPagamentoDTO> recuperar() {
		return this.tipoCanalPagamentoService.recuperar();
	}

}
