package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.ContratoEntity;
import br.com.plataformalancamento.entity.DespesaEntity;
import br.com.plataformalancamento.enumeration.TipoPeriodoFinanceiroEnumeration;
import br.com.plataformalancamento.repository.ContratoImplementacaoRepository;
import br.com.plataformalancamento.repository.ContratoRepository;
import br.com.plataformalancamento.utility.DateUtility;

@Service
public class ContratoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	@Autowired
	private DespesaService despesaService;
	
	@Autowired
	private ContratoImplementacaoRepository contratoImplementacaoRepository;
	
	@Autowired
	private ParcelamentoService parcelamentoService;
	
	public List<ContratoEntity> recuperar() {
		return this.contratoRepository.findAll();
	}
	
	@Transactional
	public ContratoEntity cadastrar(ContratoEntity contratoEntity) {
		if(Arrays.asList("Contrato de Serviços de Internet Fixa", "Contrato de Serviços de Internet Móvel", "Associação de Entidade Religiosa").contains(contratoEntity.getTipoContratoEntity().getDescricao())) {
			this.gerarParcelamentoDespesaFixaContrato(contratoEntity, this.gerarDespesaFixaContrato(contratoEntity));
		}
		return this.contratoRepository.save(this.configurarContratoCadastrar(contratoEntity));
	}
	
	public ContratoEntity recuperar(Long codigo) {
		Optional<ContratoEntity> contratoOptional = this.contratoRepository.findById(codigo);
		return contratoOptional.get();
	}
	
	public List<ContratoEntity> recuperarContratoVinculoPessoaFinanceiraVinculoContaBancaria() {
		return this.contratoImplementacaoRepository.recuperarContratoVinculoPessoaFinanceiraVinculoContaBancaria();
	}
	
	public List<ContratoEntity> recuperarContratoVinculoPessoaFinanceiraVinculoContaBancaria(Long codigoPessoaContratante) {
		return this.contratoImplementacaoRepository.recuperarContratoVinculoPessoaFinanceiraVinculoContaBancaria(codigoPessoaContratante);
	}
	
	private ContratoEntity configurarContratoCadastrar(ContratoEntity contratoEntity) {
		contratoEntity.setDataInicioVigencia(DateUtility.corrigirData(contratoEntity.getDataInicioVigencia()));
		contratoEntity.setIdentificador(this.gerarIdentificadorContrato(contratoEntity.getDataInicioVigencia(), contratoEntity.getPessoaContratado().getCodigo()));
		contratoEntity.setTipoPeriodoFinanceiroEnumeration(TipoPeriodoFinanceiroEnumeration.ANUAL);
		return contratoEntity;
	}
	
	private DespesaEntity gerarDespesaFixaContrato(ContratoEntity contratoEntity) {
		return this.despesaService.gerarDespesaFixaContrato(contratoEntity);
	}
	
	/**
	 * Valor: 	CONTRATO0<DIA_INICIO_VIGENCIA>0<MES_INICIO_VIGENCIA>0<ANO_INICIO_VIGENCIA><ID_PESSOA_CONTRATADA><SEQUENCIAL_DIARIO>
	 * Exemplo: CONTRATO0190042021XX01
	 */
	private String gerarIdentificadorContrato(Date dataInicioVigencia, Long codigoPessoaContratada) {
		StringBuilder identificadorContrato = new StringBuilder("CONTRATO0");
		try {
			identificadorContrato.append(DateUtility.extrairDiaData(dataInicioVigencia));
			identificadorContrato.append(DateUtility.extrairMesData(dataInicioVigencia));
			identificadorContrato.append(DateUtility.extrairAnoData(dataInicioVigencia));
			identificadorContrato.append(codigoPessoaContratada);
			identificadorContrato.append("01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return identificadorContrato.toString();
	}
	
	// TODO Implementar 
	private void gerarParcelamentoDespesaFixaContrato(ContratoEntity contratoEntity, DespesaEntity despesaEntity) { 
		this.parcelamentoService.gerarParcelamentoDespesaFixa(contratoEntity, despesaEntity);
	}
	
	public Boolean isExistePessoaContratadaVinculadaContrato(Long codigoPessoaContrada) {
		return this.contratoImplementacaoRepository.isExistePessoaContratadaVinculadaContrato(codigoPessoaContrada);
	}

}
