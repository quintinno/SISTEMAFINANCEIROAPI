package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.ContaBancariaEntity;
import br.com.plataformalancamento.repository.ContaBancariaRepository;

@Service
public class ContaBancariaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ContaBancariaRepository contaBancariaRepository;
	
	@Transactional
	public ContaBancariaEntity cadastrar(ContaBancariaEntity contaBancariaEntity) {
		return this.contaBancariaRepository.save(contaBancariaEntity);
	}
	
	@Transactional
	public List<ContaBancariaEntity> recuperar() {
		return this.contaBancariaRepository.findAll();
	}
	
}
