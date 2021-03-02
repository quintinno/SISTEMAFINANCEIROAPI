package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.PaisEntity;

@Repository
public interface PaisRepository extends JpaRepository<PaisEntity, Long> {
	
	public PaisEntity findByNomeContains(String nome);
	
//	@Query(value = "SELECT pais FROM PaisEntity as pais WHERE pais.nome LIKE ?1")
//	public PaisEntity recuperarPaisPorNome(String nome);
	
}
