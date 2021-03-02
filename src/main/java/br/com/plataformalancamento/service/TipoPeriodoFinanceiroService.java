package br.com.plataformalancamento.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import br.com.plataformalancamento.enumeration.TipoPeriodoFinanceiroEnumeration;

@Service
public class TipoPeriodoFinanceiroService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public TipoPeriodoFinanceiroEnumeration[] recuperar() {
		return TipoPeriodoFinanceiroEnumeration.values();
	}
	
}
