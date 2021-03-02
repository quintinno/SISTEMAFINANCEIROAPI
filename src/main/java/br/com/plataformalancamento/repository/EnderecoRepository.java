package br.com.plataformalancamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.plataformalancamento.entity.EnderecoEntity;
import br.com.plataformalancamento.entity.PessoaEntity;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
	public List<EnderecoEntity> findByPessoaEntity(PessoaEntity pessoaEntity);
}
