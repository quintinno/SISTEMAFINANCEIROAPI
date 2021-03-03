package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.DespesaEntity;

@Repository
public interface DespesaRepository extends JpaRepository<DespesaEntity, Long> { }
