package br.com.plataformalancamento.service;

import br.com.plataformalancamento.entity.ContratoEntity;
import br.com.plataformalancamento.entity.DespesaEntity;
import br.com.plataformalancamento.entity.ParcelamentoEntity;
import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;
import br.com.plataformalancamento.exception.ConfiguradorErrorException;
import br.com.plataformalancamento.exception.ObjectNotFoundException;
import br.com.plataformalancamento.repository.ParcelamentoImplementacaoRepository;
import br.com.plataformalancamento.repository.ParcelamentoRepository;
import br.com.plataformalancamento.utility.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParcelamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ParcelamentoRepository parcelamentoRepository;

	@Autowired
	private ParcelamentoImplementacaoRepository parcelamentoImplementacaoRepository;

//	@Autowired
//	private ReceitaService receitaService;
	
	@Transactional
	public List<ParcelamentoEntity> recuperar() {
		return this.parcelamentoRepository.findAll();
	}

	@Transactional
	public List<ParcelamentoEntity> recuperarPorCodigoReceita(Long codigo) {
		return this.parcelamentoImplementacaoRepository.recuperarParcelamentoPorCodigoReceita(codigo);
	}
	
	@Transactional
	public ParcelamentoEntity recuperar(Long codigo) {
		Optional<ParcelamentoEntity> parcelamentoOptional = this.parcelamentoRepository.findById(codigo);
		return parcelamentoOptional.orElseThrow( () -> new ObjectNotFoundException( ConfiguradorErrorException.recuperarMensagemErroObjetoNaoEncontradoRequisicao(codigo)));
	}

	@Transactional
	public ParcelamentoEntity registrarPagamentoParcela(ParcelamentoEntity parcelamentoEntity) {
		parcelamentoEntity.setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration.PAGO);
		parcelamentoEntity.setDataPagamentoParcela(DateUtility.corrigirData(parcelamentoEntity.getDataPagamentoParcela()));
		return this.parcelamentoRepository.save(parcelamentoEntity);
	}
	 
//	private ReceitaEntity recuperarReceitaParcelamento(ParcelamentoEntity parcelamentoEntity) {
//		return this.recuperar(parcelamentoEntity.getCodigo()).getReceitaEntity();
//	}
	
	public void remover(Long codigo) {
		try {
			this.parcelamentoRepository.deleteById(codigo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			new Throwable(e.getMessage());
		}
	}
	
	public void gerarParcelamentoDespesaFixa(ContratoEntity contratoEntity, DespesaEntity despesaEntity) {
		List<ParcelamentoEntity> parcelamentoEntityList = new ArrayList<>();
		for(int index = 1; index <= contratoEntity.getNumeroMesesVigenciaContrato() ; index++) {
			ParcelamentoEntity parcelamentoEntity = new ParcelamentoEntity();
				parcelamentoEntity.setNumeroParcela(index);
				parcelamentoEntity.setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration.PENDENTE);
				parcelamentoEntity.setValorPrevistoParcela(contratoEntity.getValorMensalPagamento());
				parcelamentoEntity.setValorTotalParcelamento(contratoEntity.getValorMensalPagamento() * contratoEntity.getNumeroMesesVigenciaContrato());
				parcelamentoEntity.setDespesaEntity(despesaEntity);
				parcelamentoEntity.setDataVencimentoParcela(DateUtility.gerarDataVencimentoPorNumeroDiaVencimento(contratoEntity.getDiaVencimentoFatura(), contratoEntity.getDataInicioVigencia(), index));
				parcelamentoEntityList.add(parcelamentoEntity);
		}
		this.parcelamentoRepository.saveAll(parcelamentoEntityList);
	}

	public Double recuperarTotalizadorParcelamentoDespesaFixaMensal() {
		return this.parcelamentoImplementacaoRepository.recuperarTotalizadorParcelamentoDespesaFixaMensal();
	}

	public ParcelamentoEntity recuperarParcelamentoPorCodigo(Long codigoParcelamento) {
		Optional<ParcelamentoEntity> parcelamentoEntityOptional = this.parcelamentoRepository.findById(codigoParcelamento);
		return parcelamentoEntityOptional.get();
	}
	
}
