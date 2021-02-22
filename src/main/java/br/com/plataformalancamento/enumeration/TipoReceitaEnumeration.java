package br.com.plataformalancamento.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TipoReceitaEnumeration {
	
	@JsonProperty("Receita Fixa")
	RECEITA_FIXA(1, "Receita Fixa", "RF"),
	
	@JsonProperty("Receita Variável")
	RECEITA_VARIAVEL(2, "Receita Variável", "RV");
	
	private Integer codigo;
	
	private String descricao;
	
	private String sigla;

	private TipoReceitaEnumeration(Integer codigo, String descricao, String sigla) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.sigla = sigla;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

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
