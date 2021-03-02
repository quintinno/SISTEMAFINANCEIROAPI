package br.com.plataformalancamento.repository;

import br.com.plataformalancamento.entity.ParcelamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelamentoRepository extends JpaRepository<ParcelamentoEntity, Long> { }
