package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.ParcelamentoEntity;
import br.com.plataformalancamento.entity.ReceitaEntity;
import br.com.plataformalancamento.enumeration.TipoPeriodoFinanceiroEnumeration;
import br.com.plataformalancamento.enumeration.TipoReceitaEnumeration;
import br.com.plataformalancamento.repository.ParcelamentoRepository;
import br.com.plataformalancamento.repository.ReceitaRepository;
import br.com.plataformalancamento.utility.DateUtility;

@Service
public class ReceitaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private ParcelamentoRepository parcelamentoRepository;
	
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
			receitaEntity.setNumeroParcelamentoEntity(gerarParcelamento(receitaEntity));
		}
		return this.receitaRepository.save(receitaEntity);
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
	
	private ParcelamentoEntity gerarParcelamento(ReceitaEntity receitaEntity) {
		List<ParcelamentoEntity> parcelamentoEntityList = new ArrayList<>();
		ParcelamentoEntity parcelamentoEntity = new ParcelamentoEntity();
		for( int index = 1 ; index < receitaEntity.getQuantidadeParcela() ; index++ ) {
				parcelamentoEntity.setIsPago(false);
				parcelamentoEntity.setNumeroParcela(index);
				parcelamentoEntity.setValorParcela(receitaEntity.getValorPagamento());
				parcelamentoEntity.setValorTotalParcelamento(receitaEntity.getValorPagamento() * receitaEntity.getQuantidadeParcela());
				parcelamentoEntityList.add(parcelamentoEntity);
				parcelamentoRepository.save(parcelamentoEntity);
		}
		return parcelamentoEntity;
	}
	
}
