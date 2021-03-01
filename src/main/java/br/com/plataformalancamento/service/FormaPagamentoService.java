package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.FormaPagamentoEntity;
import br.com.plataformalancamento.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FormaPagamentoRepository tipoFormaPagamentoRepository;
	
	public List<FormaPagamentoEntity> recuperar() {
		return this.tipoFormaPagamentoRepository.findAll();
	}
	
}
