package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.ParcelamentoEntity;
import br.com.plataformalancamento.entity.ReceitaEntity;
import br.com.plataformalancamento.enumeration.TipoPeriodoFinanceiroEnumeration;
import br.com.plataformalancamento.enumeration.TipoReceitaEnumeration;
import br.com.plataformalancamento.repository.ReceitaRepository;
import br.com.plataformalancamento.utility.DateUtility;

@Service
public class ReceitaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Transactional
	public List<ReceitaEntity> recuperar() {
		return this.receitaRepository.findAll();
	}
	
	@Transactional
	public ReceitaEntity cadastrar(ReceitaEntity receitaEntity) throws ParseException {
		receitaEntity.setIdentificador(gerarIdentificadorReceita(receitaEntity));
		if(receitaEntity.getTipoReceitaEnumeration().equals(TipoReceitaEnumeration.RECEITA_VARIAVEL)) {
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
			return identificador
					.append(DateUtility.extrairAnoData(receitaEntity.getDataRecebimentoPagamento()))
					.append(DateUtility.extrairMesData(receitaEntity.getDataRecebimentoPagamento()))
					.append(DateUtility.extrairDiaData(receitaEntity.getDataRecebimentoPagamento()))
					.append("00")
					.append("1")
					.append("VAR")
					.toString();
		}
	}
	
	private void gerarParcelamento(ReceitaEntity receitaEntity) {
		for( int index = 0 ; index < receitaEntity.getQuantidadeParcela() ; index++ ) {
			ParcelamentoEntity parcelamentoEntity = new ParcelamentoEntity();
				parcelamentoEntity.setIsPago(false);
				parcelamentoEntity.setNumeroParcela(index+1);
				parcelamentoEntity.setValorParcela(receitaEntity.getValorPagamento());
				parcelamentoEntity.setValorTotalParcelamento(receitaEntity.getValorPagamento() * receitaEntity.getQuantidadeParcela());
				parcelamentoEntity.setReceitaEntity(receitaEntity);
				receitaEntity.adicionarParcelamentoReceita(parcelamentoEntity);
		}
	}
	
}
