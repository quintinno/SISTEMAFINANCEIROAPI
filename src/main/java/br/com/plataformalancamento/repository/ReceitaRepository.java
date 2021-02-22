package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.ReceitaEntity;

@Repository
public interface ReceitaRepository extends JpaRepository<ReceitaEntity, Long> { }
