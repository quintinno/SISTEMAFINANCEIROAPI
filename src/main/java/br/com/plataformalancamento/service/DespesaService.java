package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.DespesaEntity;
import br.com.plataformalancamento.entity.FormaPagamentoDespesaEntity;
import br.com.plataformalancamento.entity.ProdutoServicoEntity;
import br.com.plataformalancamento.enumeration.TipoCanalPagamentoEnumeration;
import br.com.plataformalancamento.repository.DespesaRepository;

@Service
public class DespesaService implements Serializable {

    private static final long serialVersionUID = -4543690869198261058L;

    @Autowired
    private DespesaRepository despesaRepository;

    public DespesaService() { }

    public List<DespesaEntity> recuperar() {
        return this.despesaRepository.findAll();
    }

    @Transactional
	public DespesaEntity cadastrar(DespesaEntity despesaEntity) {
    	if(despesaEntity.getCategoriaDespesaEntity().getSigla().equals("DVA")) {
    		despesaEntity = this.prepararDespesaVariavel(despesaEntity);
	    	return this.despesaRepository.save(despesaEntity);
    	} else {
    		return this.despesaRepository.save(despesaEntity);
    	}
	}
    
    private DespesaEntity prepararDespesaVariavel(DespesaEntity despesaEntity) {
    	despesaEntity.setValorDesconto(null);
    	despesaEntity.setValorPagamento(calcularValorPagamentoDespesa(despesaEntity));
    	despesaEntity.setTipoCanalPagamentoEnumeration(TipoCanalPagamentoEnumeration.TRANSACAO_FISICA);
    	this.prepararFormaPagamentoDespesa(despesaEntity);
    	this.prepararProdutoServicoDespesa(despesaEntity);
    	if(despesaEntity.getValorDesconto() == null) {
    		despesaEntity.setValorTotal(this.calcularValorPagamentoDespesa(despesaEntity));
    	}
		return despesaEntity;
    }
    
    private Double calcularValorPagamentoDespesa(DespesaEntity despesaEntity) {
    	Double valorPagamentoCalculado = 0.0;
    	for(ProdutoServicoEntity produtoServicoEntity : despesaEntity.getProdutoServicoEntityList()) {
    		valorPagamentoCalculado = produtoServicoEntity.getValorUnitario() * produtoServicoEntity.getQuantidade();
    	}
    	return valorPagamentoCalculado;
    }
    
    private DespesaEntity prepararFormaPagamentoDespesa(DespesaEntity despesaEntity) {
    	for(FormaPagamentoDespesaEntity formaPagamentoDespesaEntity : despesaEntity.getFormaPagamentoDespesaEntityList()) {
    		formaPagamentoDespesaEntity.setValorPagamento(this.calcularValorPagamentoDespesa(despesaEntity));
    		formaPagamentoDespesaEntity.setDespesaEntity(despesaEntity);
    	}
    	return despesaEntity;
    }
    
    private DespesaEntity prepararProdutoServicoDespesa(DespesaEntity despesaEntity) {
    	for(ProdutoServicoEntity produtoServicoEntity : despesaEntity.getProdutoServicoEntityList()) {
    		produtoServicoEntity.setDespesaEntity(despesaEntity);
    	}
    	return despesaEntity;
    }

}
