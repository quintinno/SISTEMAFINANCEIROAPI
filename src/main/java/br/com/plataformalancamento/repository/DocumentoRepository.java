package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.DocumentoEntity;

@Repository
public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Long> { }
