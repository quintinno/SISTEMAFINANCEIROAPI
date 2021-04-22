package br.com.plataformalancamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.dto.UsuarioSistemaDTO;
import br.com.plataformalancamento.entity.UsuarioSistemaEntity;
import br.com.plataformalancamento.repository.UsuarioSistemaImplementacaoRepository;
import br.com.plataformalancamento.security.UsuarioSistemaSecurity;

@Service
public class UsuarioSistemaSecurityService implements UserDetailsService {
	
	@Autowired
	private UsuarioSistemaImplementacaoRepository usuarioSistemaImplementacaoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioSistemaEntity usuarioSistemaEntity = this.usuarioSistemaImplementacaoRepository.recuperarUsuarioSistema(username);
		UsuarioSistemaDTO usuarioSistemaDTO = new UsuarioSistemaDTO(usuarioSistemaEntity.getPessoaEntity().getCodigo(), usuarioSistemaEntity.getNomeUsuario(), usuarioSistemaEntity.getSenha());
		return new UsuarioSistemaSecurity(usuarioSistemaDTO.getCodigoPessoa(), usuarioSistemaDTO.getUsuario(), usuarioSistemaDTO.getSenha(), usuarioSistemaEntity.getPerfilUsuarioSistema());
	}

}
