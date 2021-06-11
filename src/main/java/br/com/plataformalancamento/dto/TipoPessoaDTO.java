package br.com.plataformalancamento.dto;

import java.io.Serializable;

public class TipoPessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String descricao;
	
	private String sigla;
	
	public TipoPessoaDTO() { }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
