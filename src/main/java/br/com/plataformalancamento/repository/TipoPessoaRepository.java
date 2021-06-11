package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.TipoPessoaEntity;

@Repository
public interface TipoPessoaRepository extends JpaRepository<TipoPessoaEntity, Long> {
	public TipoPessoaEntity findBySigla(String sigla);
	public TipoPessoaEntity findByDescricaoAndSigla(String descricao, String sigla);
}
