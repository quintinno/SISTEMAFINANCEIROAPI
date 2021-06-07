package br.com.plataformalancamento.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.FormaPagamentoEntity;

@Repository
public class FormaPagamentoImplementacaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public FormaPagamentoEntity recuperarFormaPagamentoNomeParametro(String siglaFormaPagamentoParameter) {
		StringBuilder query = new StringBuilder("SELECT	formaPagamentoEntity ")
			.append("FROM FormaPagamentoEntity formaPagamentoEntity ")
			.append("WHERE formaPagamentoEntity.sigla = :siglaFormaPagamentoParameter ");
		TypedQuery<FormaPagamentoEntity> typeQuery = entityManager.createQuery(query.toString(), FormaPagamentoEntity.class);
			typeQuery.setParameter("siglaFormaPagamentoParameter", siglaFormaPagamentoParameter);
		return typeQuery.getSingleResult();
	}
	
	public List<FormaPagamentoEntity> recuperarFormaPagamentoPessoaVinculoContaBancaria(Long contrato) {
		return null;
	}

}
