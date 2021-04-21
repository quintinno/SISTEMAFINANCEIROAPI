package br.com.plataformalancamento.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UsuarioSistemaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigoPessoa;
	
	private String usuario;
	
	private String senha;
	
	private Set<Integer> perfilUsuarioSistema = new HashSet<>();
	
	public UsuarioSistemaDTO() { }

	public UsuarioSistemaDTO(Long codigoPessoa, String usuario, String senha) {
		this.codigoPessoa = codigoPessoa;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Long getCodigoPessoa() {
		return codigoPessoa;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setCodigoPessoa(Long codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Integer> getPerfilUsuarioSistema() {
		return perfilUsuarioSistema;
	}

	public void setPerfilUsuarioSistema(Set<Integer> perfilUsuarioSistema) {
		this.perfilUsuarioSistema = perfilUsuarioSistema;
	}

}
