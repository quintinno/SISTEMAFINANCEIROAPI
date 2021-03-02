package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.TipoEnderecoEntity;

@Repository
public interface TipoEnderecoRepository extends JpaRepository<TipoEnderecoEntity, Long> { }
