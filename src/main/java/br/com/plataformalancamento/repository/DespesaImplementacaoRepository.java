package br.com.plataformalancamento.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.DespesaEntity;
import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;
import br.com.plataformalancamento.utility.DateUtility;

@Repository
public class DespesaImplementacaoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<DespesaEntity> recuperarParcelamentoDespesaFixaPendente() {
		StringBuilder query = new StringBuilder("SELECT despesaEntity ")
			.append("FROM ParcelamentoEntity parcelamentoEntity ")
			.append("JOIN parcelamentoEntity.despesaEntity despesaEntity ")
			.append("WHERE parcelamentoEntity.dataVencimentoParcela BETWEEN :primeiroDiaMesCorrente AND :ultimoDiaMesCorrente ")
			.append("AND parcelamentoEntity.tipoSituacaoPagamentoEnumeration = :descricaoTipoSituacaoPendente ");
		TypedQuery<DespesaEntity> typedQuery = entityManager.createQuery(query.toString(), DespesaEntity.class);
		typedQuery.setParameter("primeiroDiaMesCorrente", DateUtility.converterNumeroDiaMesEmDataDoMesAnoParametro(DateUtility.recuperarMesCorrente(), DateUtility.recuperarPrimeiroDiaMesCorrente()));
			typedQuery.setParameter("ultimoDiaMesCorrente", DateUtility.converterNumeroDiaMesEmDataDoMesAnoParametro(DateUtility.recuperarMesCorrente(), DateUtility.recuperarUltimoDiaMesCorrente()));
			typedQuery.setParameter("descricaoTipoSituacaoPendente", TipoSituacaoPagamentoEnumeration.PENDENTE);
		return typedQuery.getResultList();
	}
	
}
