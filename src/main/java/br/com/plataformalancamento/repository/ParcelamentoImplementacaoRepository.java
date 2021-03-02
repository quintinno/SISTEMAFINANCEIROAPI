package br.com.plataformalancamento.repository;

import br.com.plataformalancamento.entity.ParcelamentoEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ParcelamentoImplementacaoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<ParcelamentoEntity> recuperarParcelamentoPorCodigoReceita(Long codigoReceita) {
		StringBuilder query = new StringBuilder(" SELECT parcelamentoEntity_ ")
			.append("FROM ParcelamentoEntity as parcelamentoEntity_ ")
			.append("WHERE parcelamentoEntity_.receitaEntity.codigo = :codigo_receita_ ");
		TypedQuery<ParcelamentoEntity> typedQuery = entityManager.createQuery(query.toString(), ParcelamentoEntity.class);
			typedQuery.setParameter("codigo_receita_", codigoReceita);
		return typedQuery.getResultList();
	}
	
}
