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
	
	// FIXME -- Refatorar Query unificando-a para credito e debito 
	public List<CartaoBancarioDTO> recuperarCartaoCreditoBancarioVinculadoContaBancaria() {
		StringBuilder query = new StringBuilder("SELECT NEW br.com.plataformalancamento.dto.CartaoBancarioDTO(cartaoBancarioEntity.codigo, ")
			.append("cartaoBancarioEntity.contaBancariaEntity.codigo, cartaoBancarioEntity.numero, funcaoCartaoBancarioEntity.descricao, ")
			.append("cartaoBancarioEntity.contaBancariaEntity.contratoEntity.pessoaContratado.nome ) ")
			.append("FROM FuncaoCartaoBancarioEntity funcaoCartaoBancarioEntity ")
			.append("JOIN funcaoCartaoBancarioEntity.cartaoBancarioEntity cartaoBancarioEntity ")
			.append("WHERE funcaoCartaoBancarioEntity.descricao = :funcaoCreditoParamenter ");
		TypedQuery<CartaoBancarioDTO> typeQuery = entityManager.createQuery(query.toString(), CartaoBancarioDTO.class);
			typeQuery.setParameter("funcaoCreditoParamenter", "Crédito");
		return typeQuery.getResultList();
	}
	
	// FIXME -- Refatorar Query unificando-a para credito e debito
	public List<CartaoBancarioDTO> recuperarCartaoDebitoBancarioVinculadoContaBancaria() {
		StringBuilder query = new StringBuilder("SELECT NEW br.com.plataformalancamento.dto.CartaoBancarioDTO(cartaoBancarioEntity.codigo, ")
			.append("cartaoBancarioEntity.contaBancariaEntity.codigo, cartaoBancarioEntity.numero, funcaoCartaoBancarioEntity.descricao, ")
			.append("contaBancariaEntity.pessoaInstituicaoFinanceira.nome) ")
			.append("FROM FuncaoCartaoBancarioEntity funcaoCartaoBancarioEntity ")
			.append("JOIN funcaoCartaoBancarioEntity.cartaoBancarioEntity cartaoBancarioEntity ")
			.append("JOIN cartaoBancarioEntity.contaBancariaEntity contaBancariaEntity ")
			.append("WHERE funcaoCartaoBancarioEntity.descricao = :funcaoDebitoParamenter ")
			.append("AND contaBancariaEntity.isBeneficio = :is_beneficio_ ");
		TypedQuery<CartaoBancarioDTO> typeQuery = entityManager.createQuery(query.toString(), CartaoBancarioDTO.class);
			typeQuery.setParameter("funcaoDebitoParamenter", "Débito");
			typeQuery.setParameter("is_beneficio_", false);
		return typeQuery.getResultList();
	}
	
	// FIXME -- Refatorar Query unificando-a para credito, debito e alimentacao
	public List<CartaoBancarioDTO> recuperarCartaoAlimentacaoVinculadoContaBancaria() {
		StringBuilder query = new StringBuilder("SELECT NEW br.com.plataformalancamento.dto.CartaoBancarioDTO(cartaoBancarioEntity.codigo, ")
			.append("cartaoBancarioEntity.contaBancariaEntity.codigo, cartaoBancarioEntity.numero, funcaoCartaoBancarioEntity.descricao, ")
			.append("contaBancariaEntity.pessoaInstituicaoFinanceira.nome) ")
			.append("FROM FuncaoCartaoBancarioEntity funcaoCartaoBancarioEntity ")
			.append("JOIN funcaoCartaoBancarioEntity.cartaoBancarioEntity cartaoBancarioEntity ")
			.append("JOIN cartaoBancarioEntity.contaBancariaEntity contaBancariaEntity ")
			.append("WHERE funcaoCartaoBancarioEntity.descricao = :funcaoDebitoParamenter ")
			.append("AND contaBancariaEntity.isBeneficio = :is_beneficio_ ");
		TypedQuery<CartaoBancarioDTO> typeQuery = entityManager.createQuery(query.toString(), CartaoBancarioDTO.class);
		typeQuery.setParameter("funcaoDebitoParamenter", "Débito");
		typeQuery.setParameter("is_beneficio_", true);
		return typeQuery.getResultList();
	}
	
}
