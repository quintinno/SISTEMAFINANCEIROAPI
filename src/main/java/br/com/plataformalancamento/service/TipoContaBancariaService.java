package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.TipoContaBancariaEntity;
import br.com.plataformalancamento.repository.TipoContaBancariaRepository;

@Service
public class TipoContaBancariaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoContaBancariaRepository tipoContaBancariaRepository;
	
	@Transactional
	public List<TipoContaBancariaEntity> recuperar() {
		return this.tipoContaBancariaRepository.findAll();
	}
	
}
