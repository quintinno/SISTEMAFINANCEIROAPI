package br.com.plataformalancamento.repository;

import br.com.plataformalancamento.dto.DespesaFixaDTO;
import br.com.plataformalancamento.utility.DateUtility;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.text.ParseException;
import java.util.List;

@Repository
public class DespesaImplementacaoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<DespesaFixaDTO> recuperarParcelamentoDespesaFixaPendente() throws ParseException {
		StringBuilder query = new StringBuilder("SELECT NEW br.com.plataformalancamento.dto.DespesaFixaDTO ( despesaEntity.codigo, parcelamentoEntity.codigo, despesaEntity.pessoaFavorecido.nome, ")
			.append("parcelamentoEntity.dataVencimentoParcela, parcelamentoEntity.valorPrevistoParcela, parcelamentoEntity.tipoSituacaoPagamentoEnumeration )")
			.append("FROM ParcelamentoEntity parcelamentoEntity ")
			.append("JOIN parcelamentoEntity.despesaEntity despesaEntity ")
			.append("WHERE parcelamentoEntity.dataVencimentoParcela BETWEEN :primeiroDiaMesCorrente AND :ultimoDiaMesCorrente ");
		TypedQuery<DespesaFixaDTO> typedQuery = entityManager.createQuery(query.toString(), DespesaFixaDTO.class);
			typedQuery.setParameter("primeiroDiaMesCorrente", DateUtility.primeiroDiaMesCorrente());
			typedQuery.setParameter("ultimoDiaMesCorrente", DateUtility.ultimoDiaMesCorrente());
		return typedQuery.getResultList();
	}
	
}
