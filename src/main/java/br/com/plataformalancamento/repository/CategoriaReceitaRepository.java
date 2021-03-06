package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.CategoriaReceitaEntity;

@Repository
public interface CategoriaReceitaRepository extends JpaRepository<CategoriaReceitaEntity, Long> { }
