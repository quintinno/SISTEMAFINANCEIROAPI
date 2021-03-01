package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.ParcelamentoEntity;
import br.com.plataformalancamento.entity.ReceitaEntity;
import br.com.plataformalancamento.enumeration.TipoPeriodoFinanceiroEnumeration;
import br.com.plataformalancamento.enumeration.TipoReceitaEnumeration;
import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;
import br.com.plataformalancamento.exception.ConfiguradorErrorException;
import br.com.plataformalancamento.exception.ObjectNotFoundException;
import br.com.plataformalancamento.repository.ReceitaImplementacaoDao;
import br.com.plataformalancamento.repository.ReceitaRepository;
import br.com.plataformalancamento.utility.DateUtility;

@Service
public class ReceitaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReceitaRepository receitaRepository;

	@Autowired
	private ReceitaImplementacaoDao receitaImplementacaoDao;
	
	@Transactional
	public List<ReceitaEntity> recuperar() {
		return this.receitaRepository.findAll();
	}
	
	public void remover(Long codigo) {
		try {
			this.receitaRepository.deleteById(codigo);
		} catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			new ObjectNotFoundException(ConfiguradorErrorException.recuperarMensagemErroObjetoNaoEncontradoRequisicao(codigo));
		} catch (DataIntegrityViolationException dataIntegrityViolationException) {
			throw new br.com.plataformalancamento.exception.DataIntegrityViolationException(ConfiguradorErrorException.recuperarMensagemErroObjetoNaoPodeSerDeletadoRequisicao(codigo));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Transactional
	public ReceitaEntity cadastrar(ReceitaEntity receitaEntity) throws ParseException {
		receitaEntity.setIdentificador(gerarIdentificadorReceita(receitaEntity));
		if(receitaEntity.getTipoReceitaEnumeration().equals(TipoReceitaEnumeration.RECEITA_VARIAVEL)) {
			receitaEntity.setQuantidadeParcela(0);
			receitaEntity.setTipoPeriodoFinanceiroEnumeration(TipoPeriodoFinanceiroEnumeration.UNICO);
		}
		if(receitaEntity.getTipoReceitaEnumeration().equals(TipoReceitaEnumeration.RECEITA_FIXA)) {
			this.gerarParcelamento(receitaEntity);
		}
		return this.receitaRepository.save(receitaEntity);
	}
	
	@Transactional
	public List<ReceitaEntity> recuperarReceitasFixas() {
		return this.receitaRepository.findByTipoReceitaEnumeration(TipoReceitaEnumeration.RECEITA_FIXA);
	}
	
	@Transactional
	public List<ReceitaEntity> recuperarReceitasVariaveis() {
		return this.receitaRepository.findByTipoReceitaEnumeration(TipoReceitaEnumeration.RECEITA_VARIAVEL);
	}
	
	@Transactional
	public ReceitaEntity recuperar(Long codigo) {
		Optional<ReceitaEntity> receitaEntityOptional = this.receitaRepository.findById(codigo);
		return receitaEntityOptional.orElseThrow( () -> new ObjectNotFoundException(ConfiguradorErrorException.recuperarMensagemErroObjetoNaoEncontradoRequisicao(codigo)));
	}
	
	/**
	 * Receita Fixa = REC<ANO><MES_PREVISAO_PAGAMENTO><DIA_PREVISAO_PAGAMENTO>[00]<CONTROLE_DIARIO><FIX>
	 * Receita Variavel = REC<ANO><MES_PREVISAO_PAGAMENTO><DIA_PREVISAO_PAGAMENTO>[00]<CONTROLE_DIARIO><VAR>
	 * @throws ParseException 
	 */
	private String gerarIdentificadorReceita(ReceitaEntity receitaEntity) throws ParseException {
		StringBuilder identificador = new StringBuilder("REC");
		if(receitaEntity.getTipoReceitaEnumeration().equals(TipoReceitaEnumeration.RECEITA_FIXA)) {
			return identificador
					.append(DateUtility.extrairAnoData(receitaEntity.getDataPrevisaoRecebimento()))
					.append(DateUtility.extrairMesData(receitaEntity.getDataPrevisaoRecebimento()))
					.append(DateUtility.extrairDiaData(receitaEntity.getDataPrevisaoRecebimento()))
					.append("00")
					.append("1")
					.append("FIX")
					.toString();
		} else {
			identificador
			.append(DateUtility.extrairAnoData(receitaEntity.getDataRecebimentoPagamento()))
			.append(DateUtility.extrairMesData(receitaEntity.getDataRecebimentoPagamento()))
			.append(DateUtility.extrairDiaData(receitaEntity.getDataRecebimentoPagamento()))
			.append("00");
			if(this.recuperarNumeroControleDiario(receitaEntity.getTipoReceitaEnumeration(), receitaEntity.getDataRecebimentoPagamento()) <= 9) {
				identificador.append("0").append(this.recuperarNumeroControleDiario(receitaEntity.getTipoReceitaEnumeration(), receitaEntity.getDataRecebimentoPagamento()));
			} else {
				identificador.append(this.recuperarNumeroControleDiario(receitaEntity.getTipoReceitaEnumeration(), receitaEntity.getDataRecebimentoPagamento()));
			}
			identificador
			.append("VAR")
			.toString();
			return identificador.toString();
		}
	}
	
	private Integer recuperarNumeroControleDiario(TipoReceitaEnumeration tipoReceitaEnumeration, Date dataRecebimentoPagamento) {
		return this.receitaImplementacaoDao.recuperarNumeroControleDiario(tipoReceitaEnumeration, dataRecebimentoPagamento);
	}
	
	private void gerarParcelamento(ReceitaEntity receitaEntity) {
		for( int index = 0 ; index < receitaEntity.getQuantidadeParcela() ; index++ ) {
			ParcelamentoEntity parcelamentoEntity = new ParcelamentoEntity();
				parcelamentoEntity.setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration.PENDENTE);
				parcelamentoEntity.setNumeroParcela(index+1);
				parcelamentoEntity.setValorPrevistoParcela(receitaEntity.getValorPagamento());
				parcelamentoEntity.setValorTotalParcelamento(receitaEntity.getValorPagamento() * receitaEntity.getQuantidadeParcela());
				parcelamentoEntity.setDataVencimentoParcela(gerarDataVencimentoParcelamento(index, receitaEntity.getDataPrevisaoRecebimento()));
				parcelamentoEntity.setReceitaEntity(receitaEntity);
				receitaEntity.adicionarParcelamentoReceita(parcelamentoEntity);
		}
	}
	
	private Date gerarDataVencimentoParcelamento(int numeroMes, Date dataPrevisaoRecebimentoReceita) {
		return DateUtility.gerarDataVencimentoPorNumeroDias(numeroMes, dataPrevisaoRecebimentoReceita);
	}

	public ReceitaEntity atualizarValorPago(Long codigoReceita, Double valorPagamento) {
		ReceitaEntity receitaEntity = this.recuperar(codigoReceita);
			receitaEntity.setValorPagamento(receitaEntity.getValorPagamento() + valorPagamento);
			receitaEntity.setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration.PARCIALMENTE_PAGO);
		return this.receitaRepository.save(receitaEntity);
	}

	public Double recuperarTotalizadorReceitaRecebida() {
		return this.receitaImplementacaoDao.recuperarReceitasVariavelRecebidas() + this.receitaImplementacaoDao.recuperarReceitasFixasRecebidas();
	}

	public Double recuperarTotalizadorReceitaPendente() {
		return this.receitaImplementacaoDao.recuperarReceitasVariaveisPendentes() + this.receitaImplementacaoDao.recuperarReceitasFixasPendentes();
	}
	
}
