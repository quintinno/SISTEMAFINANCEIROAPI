package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.TipoContaBancariaEntity;

@Repository
public interface TipoContaBancariaRepository extends JpaRepository<TipoContaBancariaEntity, Long> { }
