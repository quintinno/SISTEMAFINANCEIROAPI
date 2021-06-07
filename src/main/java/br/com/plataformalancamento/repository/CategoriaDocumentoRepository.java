package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.CategoriaDocumentoModel;

@Repository
public interface CategoriaDocumentoRepository extends JpaRepository<CategoriaDocumentoModel, Long> { }
