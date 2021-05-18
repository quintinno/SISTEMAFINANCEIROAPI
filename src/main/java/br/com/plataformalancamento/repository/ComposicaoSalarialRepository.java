package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.ComposicaoSalarioEntity;

@Repository
public interface ComposicaoSalarialRepository extends JpaRepository<ComposicaoSalarioEntity, Long> { }
