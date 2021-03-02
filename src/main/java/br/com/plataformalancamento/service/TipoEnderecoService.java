package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.TipoEnderecoEntity;
import br.com.plataformalancamento.repository.TipoEnderecoRepository;

@Service
public class TipoEnderecoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoEnderecoRepository tipoEnderecoRepository;
	
	public List<TipoEnderecoEntity> recuperar() {
		return this.tipoEnderecoRepository.findAll();
	}
	
}
