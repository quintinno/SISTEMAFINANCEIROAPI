package br.com.plataformalancamento.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.ContratoEntity;

@Repository
public class ContratoImplementacaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<ContratoEntity> recuperarContratoVinculoPessoaFinanceiraVinculoContaBancaria() {
		StringBuilder query = new StringBuilder("SELECT contratoEntity ")
			.append("FROM ContratoEntity contratoEntity ")
			.append("JOIN contratoEntity.pessoaContratante pessoaContratante ")
			.append("JOIN contratoEntity.pessoaContratado pessoaContratado ")
			.append("WHERE pessoaContratante.nome LIKE :usuarioLogadoParameter ");
		TypedQuery<ContratoEntity> typeQuery = entityManager.createQuery(query.toString(), ContratoEntity.class);
			typeQuery.setParameter("usuarioLogadoParameter", "%".concat("Quintin").concat("%"));
		return typeQuery.getResultList();
	}
	
	public List<ContratoEntity> recuperarContratoVinculoPessoaFinanceiraVinculoContaBancaria(Long codigoPessoaContratante) {
		StringBuilder query = new StringBuilder("SELECT contratoEntity ")
			.append("FROM ContratoEntity contratoEntity ")
			.append("JOIN contratoEntity.pessoaContratante pessoaContratante ")
			.append("JOIN contratoEntity.pessoaContratado pessoaContratado ")
			.append("WHERE pessoaContratante.codigo = :codigoUsuarioLogadoParameter ");
		TypedQuery<ContratoEntity> typeQuery = entityManager.createQuery(query.toString(), ContratoEntity.class);
			typeQuery.setParameter("codigoUsuarioLogadoParameter", codigoPessoaContratante);
		return typeQuery.getResultList();
	}
	
	public Boolean isExistePessoaContratadaVinculadaContrato(Long codigoPessoaContratada) {
		StringBuilder query = new StringBuilder("SELECT contratoEntity ")
			.append("FROM ContratoEntity contratoEntity ")
			.append("JOIN contratoEntity.pessoaContratado pessoaContratado ")
			.append("WHERE pessoaContratado.codigo = :codigoPessoaContratadaParameter ");
		TypedQuery<ContratoEntity> typeQuery = entityManager.createQuery(query.toString(), ContratoEntity.class);
			typeQuery.setParameter("codigoPessoaContratadaParameter", codigoPessoaContratada);
			List<ContratoEntity> contratoEntityList = typeQuery.getResultList();
		return contratoEntityList.size() == 0 ? false : true;
	}

}
