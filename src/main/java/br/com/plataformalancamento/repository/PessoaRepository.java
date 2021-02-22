package br.com.plataformalancamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.plataformalancamento.entity.PessoaEntity;
import br.com.plataformalancamento.entity.TipoPessoaEntity;

@Repository
@CrossOrigin(origins = "http://localhost:8080", originPatterns = "http://localhost:8080")
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
	public PessoaEntity findByNomeContains(String nome);
	public List<PessoaEntity> findByTipoPessoaEntity(TipoPessoaEntity tipoPessoaEntity);
}
