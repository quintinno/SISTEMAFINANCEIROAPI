package br.com.plataformalancamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.FormaPagamentoEntity;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamentoEntity, Long> {
	
	@Query("SELECT	formaPagamentoEntity FROM FormaPagamentoEntity formaPagamentoEntity")
	public List<FormaPagamentoEntity> recuperarFormaPagamento();
	
	@Query("SELECT	formaPagamentoEntity FROM FormaPagamentoEntity formaPagamentoEntity WHERE formaPagamentoEntity.isAtivo = true")
	public List<FormaPagamentoEntity> recuperarFormaPagamentoAtivo();
	
}
