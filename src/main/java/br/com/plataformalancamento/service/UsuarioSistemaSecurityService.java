package br.com.plataformalancamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.dto.UsuarioSistemaDTO;
import br.com.plataformalancamento.repository.UsuarioSistemaImplementacaoRepository;
import br.com.plataformalancamento.security.UsuarioSistemaSecurity;

@Service
public class UsuarioSistemaSecurityService implements UserDetailsService {
	
	@Autowired
	private UsuarioSistemaImplementacaoRepository usuarioSistemaImplementacaoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioSistemaDTO usuarioSistemaDTO = this.usuarioSistemaImplementacaoRepository.recuperarUsuarioSistema();
//		return new UsuarioSistemaSecurity(usuarioSistemaDTO.getCodigoPessoa(), usuarioSistemaDTO.getUsuario(), usuarioSistemaDTO.getSenha(), usuarioSistemaDTO.getPerfilUsuarioSistema());
		return new UsuarioSistemaSecurity();
	}

}
