package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.ContratoEntity;
import br.com.plataformalancamento.repository.ContratoImplementacaoRepository;
import br.com.plataformalancamento.repository.ContratoRepository;

@Service
public class ContratoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	@Autowired
	private ContratoImplementacaoRepository contratoImplementacaoRepository;
	
	public List<ContratoEntity> recuperar() {
		return this.contratoRepository.findAll();
	}
	
	@Transactional
	public ContratoEntity cadastrar(ContratoEntity contratoEntity) {
		return this.contratoRepository.save(contratoEntity);
	}
	
	public ContratoEntity recuperar(Long codigo) {
		Optional<ContratoEntity> contratoOptional = this.contratoRepository.findById(codigo);
		return contratoOptional.get();
	}
	
	public List<ContratoEntity> recuperarContratoVinculoPessoaFinanceiraVinculoContaBancaria() {
		return this.contratoImplementacaoRepository.recuperarContratoVinculoPessoaFinanceiraVinculoContaBancaria();
	}

}
