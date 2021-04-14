package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.UsuarioSistemaEntity;
import br.com.plataformalancamento.repository.UsuarioSistemaRepository;

@Service
public class UsuarioSistemaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioSistemaRepository usuarioSistemaRepository;
	
	@Autowired
	private BCryptPasswordEncoder bBCryptPasswordEncoder;
	
	@Transactional
	public UsuarioSistemaEntity cadastrar(UsuarioSistemaEntity usuarioSistemaEntity) {
		usuarioSistemaEntity.setSenha(bBCryptPasswordEncoder.encode(usuarioSistemaEntity.getSenha()));
		return this.usuarioSistemaRepository.save(usuarioSistemaEntity);
	}
	
	@Transactional
	public List<UsuarioSistemaEntity> recuperar() {
		return this.usuarioSistemaRepository.findAll();
	}
	
}
