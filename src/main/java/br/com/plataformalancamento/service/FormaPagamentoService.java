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
	private FormaPagamentoRepository formaPagamentoRepository;
	
	public List<FormaPagamentoEntity> recuperar() {
		return this.formaPagamentoRepository.findAll();
	}

	public FormaPagamentoEntity cadastrar(FormaPagamentoEntity formaPagamentoEntity) {
		return this.formaPagamentoRepository.save(formaPagamentoEntity);
	}
	
	// FIXME -- Configurar Formas de Pagamentos personalizadas para um determinado usuario de acordo com o tipo de conta bancaria vinculada ao contrato
	public List<FormaPagamentoEntity> recuperarFormaPagamentoAtivo() {
		return this.formaPagamentoRepository.recuperarFormaPagamentoAtivo();
	}
	
}
