package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.plataformalancamento.entity.TipoPessoaEntity;

@Repository
@CrossOrigin(origins = "http://localhost:8080", originPatterns = "http://localhost:8080")
public interface TipoPessoaRepository extends JpaRepository<TipoPessoaEntity, Long> {
	public TipoPessoaEntity findBySigla(String sigla);
}
