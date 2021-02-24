package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.ParcelamentoEntity;
import br.com.plataformalancamento.repository.ParcelamentoRepository;

@Service
public class ParcelamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ParcelamentoRepository parcelamentoRepository;
	
	@Transactional
	public List<ParcelamentoEntity> recuperar() {
		return this.parcelamentoRepository.findAll();
	}
	
	@Transactional
	public ParcelamentoEntity recuperar(Long codigo) {
		Optional<ParcelamentoEntity> parcelamentoOptional = this.parcelamentoRepository.findById(codigo);
		return parcelamentoOptional.get();
	}
	
}
