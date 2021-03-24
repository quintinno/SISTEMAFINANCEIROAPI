package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.ContratoEntity;
import br.com.plataformalancamento.entity.FormaPagamentoEntity;
import br.com.plataformalancamento.repository.FormaPagamentoImplementacaoRepository;
import br.com.plataformalancamento.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private ContratoService contratoService;
	
	@Autowired
	private FormaPagamentoImplementacaoRepository formaPagamentoImplementacaoRepository;
	
	public List<FormaPagamentoEntity> recuperar() {
		return this.formaPagamentoRepository.findAll();
	}

	public FormaPagamentoEntity cadastrar(FormaPagamentoEntity formaPagamentoEntity) {
		return this.formaPagamentoRepository.save(formaPagamentoEntity);
	}
	
	public List<FormaPagamentoEntity> recuperarFormaPagamentoAtivo() {
		return this.formaPagamentoRepository.recuperarFormaPagamentoAtivo();
	}
	
	public List<FormaPagamentoEntity> recuperarFormaPagamentoPessoaVinculoContaBancaria(Long codigoResponsavelPagamento) {
		List<ContratoEntity> contratoEntityList = this.contratoService.recuperarContratoVinculoPessoaFinanceiraVinculoContaBancaria(codigoResponsavelPagamento);
		List<FormaPagamentoEntity> formaPagamentoEntityFiltradoList = new ArrayList<>();
		for (ContratoEntity contratoEntity : contratoEntityList) {
			if (codigoResponsavelPagamento.equals(contratoEntity.getPessoaContratante().getCodigo())) {
				if (contratoEntity.getTipoContratoEntity().getDescricao().equals("Contrato de Conta Especial")) {
					if(!formaPagamentoEntityFiltradoList.contains(recuperarFormaPagamento("DN"))) {
						formaPagamentoEntityFiltradoList.add(recuperarFormaPagamento("DN"));
					}
				}
				if (contratoEntity.getTipoContratoEntity().getDescricao().equals("Contrato de Conta Bancária")) {
					if(!formaPagamentoEntityFiltradoList.contains(recuperarFormaPagamento("CC"))) {
						formaPagamentoEntityFiltradoList.add(recuperarFormaPagamento("CC"));
					}
					if(!formaPagamentoEntityFiltradoList.contains(recuperarFormaPagamento("CD"))) {
						formaPagamentoEntityFiltradoList.add(recuperarFormaPagamento("CD"));
					}
				}
			}
		}
		return formaPagamentoEntityFiltradoList;
	}
	
	private FormaPagamentoEntity recuperarFormaPagamento(String siglaFormaPagamentoParameter) {
		return this.formaPagamentoImplementacaoRepository.recuperarFormaPagamentoNomeParametro(siglaFormaPagamentoParameter);
	}
	
}
