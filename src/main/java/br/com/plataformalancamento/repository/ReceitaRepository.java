package br.com.plataformalancamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.ReceitaEntity;
import br.com.plataformalancamento.enumeration.TipoReceitaEnumeration;

@Repository
public interface ReceitaRepository extends JpaRepository<ReceitaEntity, Long> {
	public List<ReceitaEntity> findByTipoReceitaEnumeration(TipoReceitaEnumeration tipoReceitaEnumeration);
}
