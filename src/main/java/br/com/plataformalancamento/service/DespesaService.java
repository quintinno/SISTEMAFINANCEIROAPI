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
    
    @Autowired
    private ProdutoServicoService produtoServicoService;

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
    	despesaEntity.setTipoCanalPagamentoEnumeration(TipoCanalPagamentoEnumeration.TRANSACAO_FISICA);
    	this.prepararFormaPagamentoDespesa(despesaEntity);
    	this.prepararProdutoServicoDespesa(despesaEntity);
		return despesaEntity;
    }
    
    private DespesaEntity prepararFormaPagamentoDespesa(DespesaEntity despesaEntity) {
    	for(FormaPagamentoDespesaEntity formaPagamentoDespesaEntity : despesaEntity.getFormaPagamentoDespesaEntityList()) {
    		formaPagamentoDespesaEntity.setDespesaEntity(despesaEntity);
    		formaPagamentoDespesaEntity.setValorPagamento(despesaEntity.getValorPagamento());
    	}
    	return despesaEntity;
    }
    
    private DespesaEntity prepararProdutoServicoDespesa(DespesaEntity despesaEntity) {
    	for(ProdutoServicoEntity produtoServicoEntity : despesaEntity.getProdutoServicoEntityList()) {
    		if(this.produtoServicoService.isProdutoServicoDescricaoCadastrado(produtoServicoEntity.getDescricao())) {
    			ProdutoServicoEntity produtoServicoEntityRecuperado = this.produtoServicoService.findOne(produtoServicoEntity.getDescricao());
    			produtoServicoEntity.setDespesaEntity(despesaEntity);
    			if(produtoServicoEntity.getDescricao().equals(produtoServicoEntityRecuperado.getDescricao())) {
    				despesaEntity.getProdutoServicoEntityList().remove(produtoServicoEntity);
    				despesaEntity.getProdutoServicoEntityList().add(produtoServicoEntityRecuperado);
    			}
    		}
    		produtoServicoEntity.setDespesaEntity(despesaEntity);
    	}
    	return despesaEntity;
    }

}
