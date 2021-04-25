package br.com.plataformalancamento.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.ProdutoServicoEntity;

@Repository
public class ProdutoServicoImplementacaoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Boolean isProdutoServicoDescricaoCadastrado(String descricao) {
		StringBuilder query = new StringBuilder("SELECT produtoServicoEntity ")
			.append("FROM ProdutoServicoEntity produtoServicoEntity ")
			.append("WHERE produtoServicoEntity.descricao LIKE :descricao_parameter_ ");
		TypedQuery<ProdutoServicoEntity> typeQuery = entityManager.createQuery(query.toString(), ProdutoServicoEntity.class)
			.setParameter("descricao_parameter_", "%".concat(descricao).concat("%"));
		List<ProdutoServicoEntity> produtoServicoEntityList = typeQuery.getResultList();
			if(produtoServicoEntityList.size() != 0) {
				return true;
			}
		return false;
	}

}
