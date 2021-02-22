package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.TipoFormaPagamentoEntity;
import br.com.plataformalancamento.repository.TipoFormaPagamentoRepository;

@Service
public class TipoFormaPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoFormaPagamentoRepository tipoFormaPagamentoRepository;
	
	public List<TipoFormaPagamentoEntity> recuperar() {
		return this.tipoFormaPagamentoRepository.findAll();
	}
	
}
