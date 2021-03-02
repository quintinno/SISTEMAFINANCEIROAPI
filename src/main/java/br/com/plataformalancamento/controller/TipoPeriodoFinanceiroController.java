package br.com.plataformalancamento.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.enumeration.TipoPeriodoFinanceiroEnumeration;
import br.com.plataformalancamento.service.TipoPeriodoFinanceiroService;

@RestController
@RequestMapping("/tipo-periodo_financeiro")
public class TipoPeriodoFinanceiroController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoPeriodoFinanceiroService tipoPeriodoFinanceiroService;
	
	@GetMapping
	public TipoPeriodoFinanceiroEnumeration[] recuperar() {
		return this.tipoPeriodoFinanceiroService.recuperar();
	}

}
