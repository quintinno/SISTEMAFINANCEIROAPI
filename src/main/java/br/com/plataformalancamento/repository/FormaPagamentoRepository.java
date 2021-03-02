package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.FormaPagamentoEntity;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamentoEntity, Long> { }
