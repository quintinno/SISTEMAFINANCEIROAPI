package br.com.plataformalancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.BandeiraCartaoBancarioEntity;

@Repository
public interface BandeiraCartaoBancarioRepository extends JpaRepository<BandeiraCartaoBancarioEntity, Long> { }
