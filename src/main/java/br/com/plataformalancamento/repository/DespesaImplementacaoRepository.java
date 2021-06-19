package br.com.plataformalancamento.repository;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.plataformalancamento.dto.DespesaFixaDTO;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;
import br.com.plataformalancamento.utility.DateUtility;

@Repository
public class DespesaImplementacaoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<DespesaFixaDTO> recuperarParcelamentoDespesaFixaPendente() throws ParseException {
		StringBuilder query = new StringBuilder("SELECT NEW br.com.plataformalancamento.dto.DespesaFixaDTO ( despesaEntity.codigo, parcelamentoEntity.codigo, despesaEntity.pessoaFavorecido.nome, ")
			.append("parcelamentoEntity.dataVencimentoParcela, parcelamentoEntity.valorPrevistoParcela, parcelamentoEntity.tipoSituacaoPagamentoEnumeration )")
			.append("FROM ParcelamentoEntity parcelamentoEntity ")
			.append("JOIN parcelamentoEntity.despesaEntity despesaEntity ")
			.append("WHERE parcelamentoEntity.dataVencimentoParcela BETWEEN :primeiroDiaMesCorrente AND :ultimoDiaMesCorrente ")
			.append("AND parcelamentoEntity.tipoSituacaoPagamentoEnumeration = :descricaoTipoSituacaoPendente ");
		TypedQuery<DespesaFixaDTO> typedQuery = entityManager.createQuery(query.toString(), DespesaFixaDTO.class);
			typedQuery.setParameter("primeiroDiaMesCorrente", DateUtility.primeiroDiaMesCorrente());
			typedQuery.setParameter("ultimoDiaMesCorrente", DateUtility.ultimoDiaMesCorrente());
			typedQuery.setParameter("descricaoTipoSituacaoPendente", TipoSituacaoPagamentoEnumeration.PENDENTE);
		return typedQuery.getResultList();
	}
	
}
