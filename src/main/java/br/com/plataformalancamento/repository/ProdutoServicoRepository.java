package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.ProdutoServicoEntity;

@Repository
public interface ProdutoServicoRepository extends JpaRepository<ProdutoServicoEntity, Long> {
	public ProdutoServicoEntity findByDescricaoContains(String descricao);
}
