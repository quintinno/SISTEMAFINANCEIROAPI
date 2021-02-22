package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.TipoFormaPagamentoEntity;

@Repository
public interface TipoFormaPagamentoRepository extends JpaRepository<TipoFormaPagamentoEntity, Long> { }
