package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.BeneficioEntity;

@Repository
public interface BeneficioRepository extends JpaRepository<BeneficioEntity, Long> {}

