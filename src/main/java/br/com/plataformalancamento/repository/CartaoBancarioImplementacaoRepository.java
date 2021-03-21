package br.com.plataformalancamento.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.dto.CartaoBancarioDTO;

@Repository
public class CartaoBancarioImplementacaoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<CartaoBancarioDTO> recuperarCartaoBancarioVinculadoContaBancaria(Long codigoContaBancaria) {
//		StringBuilder query = new StringBuilder("SELECT * ")
//			.append("FROM CartaoBancarioEntity cartaoBancarioEntity_ ")
//			.append("WHERE cartaoBancarioEntity_. ");
		return null;
	}
	
}
