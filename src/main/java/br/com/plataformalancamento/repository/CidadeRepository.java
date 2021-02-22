package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.CidadeEntity;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeEntity, Long> { }
