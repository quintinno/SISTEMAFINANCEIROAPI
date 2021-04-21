package br.com.plataformalancamento.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.dto.UsuarioSistemaDTO;

@Repository
public class UsuarioSistemaImplementacaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public UsuarioSistemaDTO recuperarUsuarioSistema() {
		StringBuilder query = new StringBuilder("SELECT usuarioSistemaEntity ")
				.append("FROM UsuarioSistemaEntity usuarioSistemaEntity ");
		TypedQuery<UsuarioSistemaDTO> typedQuery = entityManager.createQuery(query.toString(), UsuarioSistemaDTO.class);
		return typedQuery.getSingleResult();
	}

}
