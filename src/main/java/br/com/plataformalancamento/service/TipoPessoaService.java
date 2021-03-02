package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.TipoPessoaEntity;
import br.com.plataformalancamento.repository.TipoPessoaRepository;

@Service
public class TipoPessoaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoPessoaRepository tipoPessoaRepository;
	
	public List<TipoPessoaEntity> recuperar() {
		return this.tipoPessoaRepository.findAll();
	}
	
	public TipoPessoaEntity recuperar(Long codigo) {
		Optional<TipoPessoaEntity> tipoPessoaEntityOptional = this.tipoPessoaRepository.findById(codigo);
		return tipoPessoaEntityOptional.get();
	}
	
}
