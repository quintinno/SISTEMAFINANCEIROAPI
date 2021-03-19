package br.com.plataformalancamento.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import br.com.plataformalancamento.enumeration.TipoCanalPagamentoEnumeration;

@Service
public class TipoCanalPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public TipoCanalPagamentoEnumeration[] recuperar() {
		return TipoCanalPagamentoEnumeration.values();
	}

}
