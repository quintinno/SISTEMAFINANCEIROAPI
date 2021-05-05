package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.CategoriaDespesaEntity;
import br.com.plataformalancamento.entity.ContratoEntity;
import br.com.plataformalancamento.entity.DespesaEntity;
import br.com.plataformalancamento.entity.FormaPagamentoDespesaEntity;
import br.com.plataformalancamento.entity.ProdutoServicoEntity;
import br.com.plataformalancamento.repository.DespesaRepository;
import br.com.plataformalancamento.utility.DateUtility;

@Service
public class DespesaService implements Serializable {

    private static final long serialVersionUID = -4543690869198261058L;

    @Autowired
    private DespesaRepository despesaRepository;
    
    @Autowired
    private ProdutoServicoService produtoServicoService;
    
    @Autowired
    private CategoriaDespesaService categoriaDespesaService;

    public DespesaService() { }

    public List<DespesaEntity> recuperar() {
        return this.despesaRepository.findAll();
    }

    @Transactional
	public DespesaEntity cadastrar(DespesaEntity despesaEntity) {
    	if(despesaEntity.getCategoriaDespesaEntity().getSigla().equals("DVA")) {
    		despesaEntity = this.prepararDespesaVariavel(despesaEntity);
    	}
    	return this.despesaRepository.save(despesaEntity);
	}
    
    private DespesaEntity prepararDespesaVariavel(DespesaEntity despesaEntity) {
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
    
    public DespesaEntity gerarDespesaFixaContrato(ContratoEntity contratoEntity) {
		DespesaEntity despesaEntity = new DespesaEntity();
			despesaEntity.setCategoriaDespesaEntity(this.recuperarCategoriaDespesaFixa());
			despesaEntity.setDataCadastro(new Date());
			despesaEntity.setDataPagamento(null);
			despesaEntity.setDataVencimento(DateUtility.gerarDataVencimentoPorNumeroMesses(contratoEntity.getDataInicioVigencia(), 1));
			despesaEntity.setFormaPagamentoDespesaEntityList(null);
			despesaEntity.setObservacao(null);
			despesaEntity.setPessoaFavorecido(contratoEntity.getPessoaContratado());
			despesaEntity.setProdutoServicoEntityList(null);
			despesaEntity.setTipoCanalPagamentoEnumeration(null);
			despesaEntity.setValorDesconto(null);
			despesaEntity.setValorJurosAtraso(null);
			despesaEntity.setValorMultaAtraso(null);
			despesaEntity.setValorPagamento(contratoEntity.getValorMensalPagamento());
			despesaEntity.setValorTotal(null);
		return this.cadastrar(despesaEntity);
	}
    
    private CategoriaDespesaEntity recuperarCategoriaDespesaFixa() {
    	for(CategoriaDespesaEntity categoriaDespesaEntity : this.categoriaDespesaService.recuperar()) {
    		if(categoriaDespesaEntity.getSigla().equals("DFI")) {
    			return categoriaDespesaEntity;
    		}
    	}
    	return null;
    }

}
