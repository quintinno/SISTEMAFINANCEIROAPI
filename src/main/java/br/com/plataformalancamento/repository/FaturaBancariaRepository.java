package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.FaturaBancariaModel;

@Repository
public interface FaturaBancariaRepository extends JpaRepository<FaturaBancariaModel, Long> {}
