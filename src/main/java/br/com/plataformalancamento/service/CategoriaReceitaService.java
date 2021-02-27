package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.CategoriaReceitaEntity;
import br.com.plataformalancamento.exception.ConfiguradorErrorException;
import br.com.plataformalancamento.repository.CategoriaReceitaRepository;

@Service
public class CategoriaReceitaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaReceitaRepository categoriaReceitaRepository;
	
	public List<CategoriaReceitaEntity> recuperar() {
		List<CategoriaReceitaEntity> receitaEntityList = this.categoriaReceitaRepository.findAll();
		if(receitaEntityList.isEmpty()) {
			throw new br.com.plataformalancamento.exception.EmptyResultDataAccessException(ConfiguradorErrorException.recuperarMensagemErroObjetoNaoEncontradoRequisicao());
		}
		return this.categoriaReceitaRepository.findAll();
	}
	
	public CategoriaReceitaEntity recuperar(Long codigo) {
		Optional<CategoriaReceitaEntity> CategoriaReceitaEntityOptional = this.categoriaReceitaRepository.findById(codigo);
		return CategoriaReceitaEntityOptional.get();
	}
	
	public void remover(Long codigo) {
		try {
			this.categoriaReceitaRepository.deleteById(codigo);
		} catch (DataIntegrityViolationException dataIntegrityViolationException) {
			throw new br.com.plataformalancamento.exception.DataIntegrityViolationException(ConfiguradorErrorException.recuperarMensagemErroObjetoNaoPodeSerDeletadoRequisicao(codigo));
		} catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			throw new br.com.plataformalancamento.exception.EmptyResultDataAccessException(ConfiguradorErrorException.recuperarMensagemErroObjetoNaoEncontradoRequisicao(codigo));
		}
	}
	
}
