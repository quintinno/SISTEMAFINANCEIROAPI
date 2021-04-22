package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.plataformalancamento.entity.UsuarioSistemaEntity;

@Repository
@CrossOrigin(origins = "http://localhost:8080", originPatterns = "http://localhost:8080")
public interface UsuarioSistemaRepository extends JpaRepository<UsuarioSistemaEntity, Long> { }