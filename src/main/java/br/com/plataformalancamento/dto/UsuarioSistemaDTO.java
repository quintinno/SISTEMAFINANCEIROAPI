package br.com.plataformalancamento.dto;

import java.io.Serializable;

public class UsuarioSistemaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String identificador;
	
	private String senha;
	
	public UsuarioSistemaDTO() { }
	
	public UsuarioSistemaDTO(String identificador, String senha) {
		this.identificador = identificador;
		this.senha = senha;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
