package br.com.plataformalancamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.entity.ArquivoEntity;

@Repository
public interface ArquivoRepository extends JpaRepository<ArquivoEntity, Long> {
	
	@Query("SELECT new ArquivoEntity(arquivo_.codigo, arquivo_.dataCadastro, arquivo_.nome, arquivo_.tamanho) FROM ArquivoEntity arquivo_ ORDER BY arquivo_.dataCadastro DESC")
	public List<ArquivoEntity> recuperarInformacaoArquivo();
	
}
