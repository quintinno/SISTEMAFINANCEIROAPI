package br.com.plataformalancamento.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.DocumentoEntity;

@Repository
public class DocumentoImplementacaoRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<DocumentoEntity> recuperarCategoriaDocumentosVinculadoPessoa(Long codigoPessoa) {
		StringBuilder query = new StringBuilder("SELECT documentoEntity ")
			.append("FROM DocumentoEntity documentoEntity ")
			.append("WHERE documentoEntity.pessoaEntity.codigo = :codigoPessoa ");
		TypedQuery<DocumentoEntity> typedQuery = entityManager.createQuery(query.toString(), DocumentoEntity.class);
			typedQuery.setParameter("codigoPessoa", codigoPessoa);
		return typedQuery.getResultList();
	}
	
}
