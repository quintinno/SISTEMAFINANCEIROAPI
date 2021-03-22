package br.com.plataformalancamento.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.PessoaEntity;

@Repository
public class PessoaImplementacaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<PessoaEntity> recuperarPessoaFinanceiraSistema() {
		StringBuilder query = new StringBuilder("SELECT pessoaEntity ")
			.append("FROM UsuarioSistemaEntity usuarioSistemaEntity ")
			.append("JOIN usuarioSistemaEntity.pessoaEntity pessoaEntity ")
			.append("JOIN usuarioSistemaEntity.tipoUsuarioSistemaEntity tipoUsuarioSistemaEntity ")
			.append("WHERE tipoUsuarioSistemaEntity.descricao = :papelUsuarioSistemaParameter ");
		TypedQuery<PessoaEntity> typedQuery = entityManager.createQuery(query.toString(), PessoaEntity.class);
			typedQuery.setParameter("papelUsuarioSistemaParameter", "Administrador Financeiro");
		return typedQuery.getResultList();
	}

}
