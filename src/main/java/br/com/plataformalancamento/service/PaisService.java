package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.PaisEntity;
import br.com.plataformalancamento.repository.PaisImplementacaoRepository;
import br.com.plataformalancamento.repository.PaisRepository;

@Service
public class PaisService implements Serializable {

	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private PaisImplementacaoRepository paisImplementacaoRepository;
	
	private static final long serialVersionUID = 1L;
	
	public List<PaisEntity> recuperar() {
		return this.paisRepository.findAll();
	}
	
	public PaisEntity cadastrar(PaisEntity paisEntity) {
		return this.paisRepository.save(paisEntity);
	}
	
	public PaisEntity recuperar(Long codigo) {
		Optional<PaisEntity> paisOptional = this.paisRepository.findById(codigo);
		return paisOptional.get();
	}
	
	public PaisEntity recuperar(String nome) {
		return this.paisRepository.findByNomeContains(nome);
	}
	
	public PaisEntity recuperar(Long codigo, String nome) {
		return this.paisImplementacaoRepository.recuperarPaisFiltroParametro(codigo, nome);
	}
	
	public PaisEntity atualizar(Long codigo, PaisEntity paisEntity) {
		PaisEntity paisEntityResult = this.recuperar(codigo);
		BeanUtils.copyProperties(paisEntity, paisEntityResult, "codigo");
		return this.paisRepository.save(paisEntityResult);
	}
	
	public void remover(Long codigo) {
		this.paisRepository.deleteById(codigo);
	}
	
}
