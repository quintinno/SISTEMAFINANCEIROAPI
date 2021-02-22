package br.com.plataformalancamento.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.PaisEntity;

@Repository
public class PaisImplementacaoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public PaisEntity recuperarPaisFiltroParametro(Long codigo, String nome) {
		StringBuilder queryStringBuilder = new StringBuilder(" SELECT pais_ FROM PaisEntity as pais_ ");
		String condicao = " WHERE ";
		if(codigo != null) {
			queryStringBuilder.append(condicao.concat(" pais_.codigo = :codigo "));
			condicao = " AND ";
		}
		if(nome != null) {
			queryStringBuilder.append(condicao.concat(" pais_.nome LIKE CONCAT('%', :nome, '%') "));
		}
		
		Query query = entityManager.createQuery(queryStringBuilder.toString(), PaisEntity.class);
		
		if(codigo != null) {
			query.setParameter("codigo", codigo);
		}
		if(nome != null) {
			query.setParameter("nome", nome);
		}
		List<PaisEntity> paisEntityList = query.getResultList();
		System.out.println(paisEntityList);
		return paisEntityList.get(0);
	}
	
}
