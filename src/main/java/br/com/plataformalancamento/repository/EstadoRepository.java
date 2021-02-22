package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.plataformalancamento.entity.EstadoEntity;

public interface EstadoRepository extends JpaRepository<EstadoEntity, Long> { }
