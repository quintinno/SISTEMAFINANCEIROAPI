package br.com.plataformalancamento.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;

@Service
public class TipoSituacaoPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public TipoSituacaoPagamentoService() { }
	
	public TipoSituacaoPagamentoEnumeration[] recuperar() {
		return TipoSituacaoPagamentoEnumeration.values();
	}

}
