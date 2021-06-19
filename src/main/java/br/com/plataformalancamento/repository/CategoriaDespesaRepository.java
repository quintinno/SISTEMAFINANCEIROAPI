package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.CategoriaDespesaEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:8080", originPatterns = "http://localhost:8080")
public interface CategoriaDespesaRepository extends JpaRepository<CategoriaDespesaEntity, Long> { }
