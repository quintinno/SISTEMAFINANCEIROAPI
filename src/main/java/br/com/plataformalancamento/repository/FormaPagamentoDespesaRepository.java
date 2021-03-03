package br.com.plataformalancamento.repository;

import br.com.plataformalancamento.entity.FormaPagamentoDespesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoDespesaRepository extends JpaRepository<FormaPagamentoDespesaEntity, Long> { }
