package br.com.plataformalancamento.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.PessoaEntity;
import br.com.plataformalancamento.entity.UsuarioSistemaEntity;

@Repository
public class PessoaImplementacaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<PessoaEntity> recuperarPessoaFinanceiraSistema() {
		StringBuilder query = new StringBuilder("SELECT pessoaEntity ")
			.append("FROM UsuarioSistemaEntity usuarioSistemaEntity ")
			.append("JOIN usuarioSistemaEntity.pessoaEntity pessoaEntity ")
			.append("JOIN usuarioSistemaEntity.perfilUsuarioSistema perfilUsuarioSistemaEntity ")
			.append("WHERE perfilUsuarioSistemaEntity.perfil_usuario_sistema = :tipoPerfilUsuarioSistemaParameter ");
		TypedQuery<PessoaEntity> typedQuery = entityManager.createQuery(query.toString(), PessoaEntity.class);
			typedQuery.setParameter("tipoPerfilUsuarioSistemaParameter", 1);
		return typedQuery.getResultList();
	}
	
	public Boolean isPessoaFinanceiraVinculoContaBancaria(String nomePessoa) {
		StringBuilder query = new StringBuilder("SELECT pessoaContratante ")
			.append("FROM ContratoEntity contratoEntity ")
			.append("JOIN contratoEntity.pessoaContratante pessoaContratante ")
			.append("JOIN contratoEntity.pessoaContratado pessoaContratado ")
			.append("WHERE pessoaContratante.nome LIKE :usuarioLogadoParameter ");
		TypedQuery<PessoaEntity> typeQuery = entityManager.createQuery(query.toString(), PessoaEntity.class);
			typeQuery.setParameter("usuarioLogadoParameter", "%".concat(nomePessoa).concat("%"));
			if(typeQuery.getResultList().size() > 0) {
				return true;
			}
		return false;
	}

}
