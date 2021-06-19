package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.TipoContratoEntity;
import br.com.plataformalancamento.repository.TipoContratoRepository;

@Service
public class TipoContratoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoContratoRepository tipoContratoRepository;
	
	@Transactional
	public List<TipoContratoEntity> recuperar() {
		return this.tipoContratoRepository.findAll();
	}

	@Transactional
	public TipoContratoEntity cadastrar(TipoContratoEntity tipoContratoEntity) {
		return this.tipoContratoRepository.save(tipoContratoEntity);
	}
	
}
