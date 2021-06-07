package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.UsuarioSistemaEntity;

@Repository
public interface UsuarioSistemaRepository extends JpaRepository<UsuarioSistemaEntity, Long> { }