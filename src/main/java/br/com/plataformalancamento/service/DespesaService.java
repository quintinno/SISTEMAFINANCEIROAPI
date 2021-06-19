package br.com.plataformalancamento.service;

import br.com.plataformalancamento.dto.DespesaFixaDTO;
import br.com.plataformalancamento.entity.*;
import br.com.plataformalancamento.repository.DespesaImplementacaoRepository;
import br.com.plataformalancamento.repository.DespesaRepository;
import br.com.plataformalancamento.repository.ParcelamentoImplementacaoRepository;
import br.com.plataformalancamento.utility.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class DespesaService implements Serializable {

    private static final long serialVersionUID = -4543690869198261058L;

    @Autowired
    private DespesaRepository despesaRepository;
    
    @Autowired
    private ProdutoServicoService produtoServicoService;
    
    @Autowired
    private CategoriaDespesaService categoriaDespesaService;
    
    @Autowired
    private DespesaImplementacaoRepository despesaImplementacaoRepository;

	@Autowired
	private ParcelamentoImplementacaoRepository parcelamentoImplementacaoRepository;

    public DespesaService() { }

    public List<DespesaEntity> recuperar() {
        return this.despesaRepository.findAll();
    }

    @Transactional
	public DespesaEntity cadastrar(DespesaEntity despesaEntity) {
    	if(despesaEntity.getCategoriaDespesaEntity() == null) {
    		despesaEntity.setCategoriaDespesaEntity(this.recuperarCategoriaDespesaFixa());
    	}
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
    
    public String recuperarInformacaoDespesa() {
    	return new DespesaEntity().toJson();
    }
    
    public List<DespesaFixaDTO> recuperarDespesaFixaMensal() throws ParseException {
    	return this.despesaImplementacaoRepository.recuperarParcelamentoDespesaFixaPendente();
    }

	public Double recuperarValorTotalDespesasAnoFinanceiro(Boolean isPago) {
		return this.parcelamentoImplementacaoRepository.recuperarTotalDespesasAnoFinanceiroSituacao(isPago);
	}

}
