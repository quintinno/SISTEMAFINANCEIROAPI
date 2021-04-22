package br.com.plataformalancamento.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.UsuarioSistemaEntity;

@Repository
public class UsuarioSistemaImplementacaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public UsuarioSistemaEntity recuperarUsuarioSistema(String username) {
		StringBuilder query = new StringBuilder("SELECT usuarioSistemaEntity ")
			.append("FROM UsuarioSistemaEntity usuarioSistemaEntity ")
			.append("WHERE usuarioSistemaEntity.nomeUsuario = :nomeUsuarioParameter ");
		TypedQuery<UsuarioSistemaEntity> typedQuery = entityManager.createQuery(query.toString(), UsuarioSistemaEntity.class);
			typedQuery.setParameter("nomeUsuarioParameter", username);
		return typedQuery.getSingleResult();
	}

}
