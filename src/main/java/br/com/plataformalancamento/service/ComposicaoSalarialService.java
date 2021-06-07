package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.ComposicaoSalarioEntity;
import br.com.plataformalancamento.repository.ComposicaoSalarialRepository;

@Service
public class ComposicaoSalarialService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ComposicaoSalarialRepository composicaoSalarialRepository;
	
	public List<ComposicaoSalarioEntity> recuperar() {
		return this.composicaoSalarialRepository.findAll();
	}

}
