package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.TipoContratoEntity;

@Repository
public interface TipoContratoRepository extends JpaRepository<TipoContratoEntity, Long> { }
