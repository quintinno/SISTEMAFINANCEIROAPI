package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.ParcelamentoEntity;

@Repository
public interface ParcelamentoRepository extends JpaRepository<ParcelamentoEntity, Long> { }
