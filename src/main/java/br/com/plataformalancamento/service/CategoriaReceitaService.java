package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.CategoriaReceitaEntity;
import br.com.plataformalancamento.repository.CategoriaReceitaRepository;

@Service
public class CategoriaReceitaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaReceitaRepository categoriaReceitaRepository;
	
	public List<CategoriaReceitaEntity> recuperar() {
		return this.categoriaReceitaRepository.findAll();
	}
	
	public CategoriaReceitaEntity recuperar(Long codigo) {
		Optional<CategoriaReceitaEntity> CategoriaReceitaEntityOptional = this.categoriaReceitaRepository.findById(codigo);
		return CategoriaReceitaEntityOptional.get();
	}
	
}
