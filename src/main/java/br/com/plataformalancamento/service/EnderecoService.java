package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.EnderecoEntity;
import br.com.plataformalancamento.repository.EnderecoRepository;

@Service
public class EnderecoService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<EnderecoEntity> recuperar() {
		return this.enderecoRepository.findAll();
	}

}
