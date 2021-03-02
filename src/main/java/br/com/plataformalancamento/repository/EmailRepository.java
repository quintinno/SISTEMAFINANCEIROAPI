package br.com.plataformalancamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.plataformalancamento.entity.EmailEntity;
import br.com.plataformalancamento.entity.PessoaEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
	public List<EmailEntity> findByPessoaEntity(PessoaEntity pessoaEntity);
}
