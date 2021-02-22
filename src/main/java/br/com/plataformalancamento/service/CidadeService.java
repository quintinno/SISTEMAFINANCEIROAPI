package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.CidadeEntity;
import br.com.plataformalancamento.repository.CidadeRepository;

@Service
public class CidadeService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public CidadeEntity cadastrar(CidadeEntity cidadeEntity) {
		return this.cidadeRepository.save(cidadeEntity);
	}
	
	public List<CidadeEntity> recuperar() {
		return this.cidadeRepository.findAll();
	}
	
	public CidadeEntity recuperar(Long codigo) {
		Optional<CidadeEntity> cidadeEntityOptional = this.cidadeRepository.findById(codigo);
		return cidadeEntityOptional.get();
	}

}
