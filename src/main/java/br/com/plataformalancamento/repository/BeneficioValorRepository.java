package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.BeneficioValorEntity;

@Repository
public interface BeneficioValorRepository extends JpaRepository<BeneficioValorEntity, Long> {}

