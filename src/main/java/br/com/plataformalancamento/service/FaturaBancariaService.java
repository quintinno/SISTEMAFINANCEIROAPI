package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.FaturaBancariaModel;
import br.com.plataformalancamento.repository.FaturaBancariaRepository;

@Service
public class FaturaBancariaService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FaturaBancariaRepository faturaBancariaRepository;
	
	public List<FaturaBancariaModel> recuperar() {
		return this.faturaBancariaRepository.findAll();
	}

}
