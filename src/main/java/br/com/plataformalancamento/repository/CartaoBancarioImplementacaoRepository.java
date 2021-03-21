package br.com.plataformalancamento.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.dto.CartaoBancarioDTO;

@Repository
public class CartaoBancarioImplementacaoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<CartaoBancarioDTO> recuperarCartaoCreditoBancarioVinculadoContaBancaria() {
		StringBuilder query = new StringBuilder("SELECT NEW br.com.plataformalancamento.dto.CartaoBancarioDTO(cartaoBancarioEntity.codigo, ")
			.append("cartaoBancarioEntity.numero, funcaoCartaoBancarioEntity.descricao, ")
			.append("cartaoBancarioEntity.contaBancariaEntity.contratoEntity.pessoaContratado.nome ) ")
			.append("FROM FuncaoCartaoBancarioEntity funcaoCartaoBancarioEntity ")
			.append("JOIN funcaoCartaoBancarioEntity.cartaoBancarioEntity cartaoBancarioEntity ")
			.append("WHERE funcaoCartaoBancarioEntity.descricao = :funcaoCreditoParamenter ");
		TypedQuery<CartaoBancarioDTO> typeQuery = entityManager.createQuery(query.toString(), CartaoBancarioDTO.class);
			typeQuery.setParameter("funcaoCreditoParamenter", "Crédito");
		return typeQuery.getResultList();
	}
	
	public List<CartaoBancarioDTO> recuperarCartaoDebitoBancarioVinculadoContaBancaria() {
		StringBuilder query = new StringBuilder("SELECT NEW br.com.plataformalancamento.dto.CartaoBancarioDTO(cartaoBancarioEntity.codigo, ")
			.append("cartaoBancarioEntity.numero, funcaoCartaoBancarioEntity.descricao) ")
			.append("FROM FuncaoCartaoBancarioEntity funcaoCartaoBancarioEntity ")
			.append("JOIN funcaoCartaoBancarioEntity.cartaoBancarioEntity cartaoBancarioEntity ")
			.append("WHERE funcaoCartaoBancarioEntity.descricao = :funcaoDebitoParamenter ");
		TypedQuery<CartaoBancarioDTO> typeQuery = entityManager.createQuery(query.toString(), CartaoBancarioDTO.class);
			typeQuery.setParameter("funcaoDebitoParamenter", "Débito");
		return typeQuery.getResultList();
	}
	
}
