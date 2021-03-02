package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.ContaBancariaEntity;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancariaEntity, Long> { }
