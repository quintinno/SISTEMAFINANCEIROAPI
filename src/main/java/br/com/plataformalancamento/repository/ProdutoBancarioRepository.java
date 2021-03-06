package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.ProdutoBancarioEntity;

@Repository
public interface ProdutoBancarioRepository extends JpaRepository<ProdutoBancarioEntity, Long> { }
