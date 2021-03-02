package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.EstadoEntity;
import br.com.plataformalancamento.repository.EstadoRepository;

@Service
public class EstadoService implements Serializable {

	@Autowired
	private EstadoRepository estadoRepository;
	
	private static final long serialVersionUID = 1L;
	
	public List<EstadoEntity> recuperar() {
		return this.estadoRepository.findAll();
	}
	
	public EstadoEntity cadastrar(EstadoEntity estadoEntity) {
		System.out.println(estadoEntity);
		return this.estadoRepository.save(estadoEntity);
	}

}
