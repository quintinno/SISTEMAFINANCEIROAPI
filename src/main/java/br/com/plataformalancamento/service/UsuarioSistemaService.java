package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.dto.UsuarioSistemaDTO;
import br.com.plataformalancamento.entity.UsuarioSistemaEntity;
import br.com.plataformalancamento.repository.UsuarioSistemaImplementacaoRepository;
import br.com.plataformalancamento.repository.UsuarioSistemaRepository;

@Service
public class UsuarioSistemaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioSistemaRepository usuarioSistemaRepository;
	
	@Autowired
	private UsuarioSistemaImplementacaoRepository usuarioSistemaImplementacaoRepository;
	
	@Transactional
	public UsuarioSistemaEntity autenticarDadosUsuarioSistema(UsuarioSistemaDTO usuarioSistemaDTO) {
		return this.usuarioSistemaImplementacaoRepository.autenticarDadosUsuarioSistema(usuarioSistemaDTO.getIdentificador(), usuarioSistemaDTO.getSenha());
	}
	
	@Transactional
	public Boolean isUsuarioCadastrado(UsuarioSistemaDTO usuarioSistemaDTO) {
		if(this.usuarioSistemaImplementacaoRepository.isUsuarioCadastrado(usuarioSistemaDTO) != null) {
			return true;
		}
		return false;
	}
	
	@Transactional
	public List<UsuarioSistemaEntity> recuperar() {
		return this.usuarioSistemaRepository.findAll();
	}
	
}
