package br.com.plataformalancamento.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TipoPerfilUsuarioSistemaEnumeration {
	
	@JsonProperty("Administrador Financeiro")
	ADMINISTRADOR_FINANCEIRO(1, "Administrador Financeiro", "ADMINISTRADOR_FINANCEIRO", "ROLE_ADMFIN"),
	
	@JsonProperty("Consultor Financeiro")
	CONSULTOR_FINANCEIRO(2, "Consultor Financeiro", "CONSULTOR_FINANCEIRO", "ROLE_CONFIN"),
	
	@JsonProperty("Devedor Empréstimo")
	DEVEDOR_EMPRESTIMO(3, "Devedor Empréstimo", "DEVEDOR_EMPRESTIMO", "ROLE_DVDEMP");
	
	private Integer codigo;
	
	private String descricao;
	
	private String sigla;
	
	private String prefixoSpring;

	private TipoPerfilUsuarioSistemaEnumeration(Integer codigo, String descricao, String sigla, String prefixoSpring) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.sigla = sigla;
		this.prefixoSpring = prefixoSpring;
	}
	
	public static TipoPerfilUsuarioSistemaEnumeration converterParaEnumeration(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		for(TipoPerfilUsuarioSistemaEnumeration tipoPerfilUsuarioSistemaEnumeration : TipoPerfilUsuarioSistemaEnumeration.values()) {
			if(codigo.equals(tipoPerfilUsuarioSistemaEnumeration.getCodigo())) {
				return tipoPerfilUsuarioSistemaEnumeration;
			}
		}
		throw new IllegalArgumentException("Código Inválido: " + codigo);
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

	public String getPrefixoSpring() {
		return prefixoSpring;
	}

	public void setPrefixoSpring(String prefixoSpring) {
		this.prefixoSpring = prefixoSpring;
	}
	
}
