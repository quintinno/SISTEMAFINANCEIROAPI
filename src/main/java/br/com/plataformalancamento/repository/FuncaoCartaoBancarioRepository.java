package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.FuncaoCartaoBancarioEntity;

@Repository
public interface FuncaoCartaoBancarioRepository extends JpaRepository<FuncaoCartaoBancarioEntity, Long> { }
