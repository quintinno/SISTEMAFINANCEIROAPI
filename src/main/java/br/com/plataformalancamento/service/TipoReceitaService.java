package br.com.plataformalancamento.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import br.com.plataformalancamento.enumeration.TipoReceitaEnumeration;

@Service
public class TipoReceitaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public TipoReceitaService() { }
	
	public TipoReceitaEnumeration[] recuperar() {
		return TipoReceitaEnumeration.values();
	}

}
