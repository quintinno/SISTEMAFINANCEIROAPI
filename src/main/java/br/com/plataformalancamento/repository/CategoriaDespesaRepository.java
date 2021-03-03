package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.CategoriaDespesaEntity;

@Repository
public interface CategoriaDespesaRepository extends JpaRepository<CategoriaDespesaEntity, Long> { }
