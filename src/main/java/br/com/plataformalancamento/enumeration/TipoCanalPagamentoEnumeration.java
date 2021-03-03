package br.com.plataformalancamento.enumeration;

public enum TipoCanalPagamentoEnumeration {
	
	TRANSACAO_FISICA(1, "Transação Física", "TRF"),
	TRANSACAO_ONLINE(2, "Transação Online", "TRO");
	
	private Integer codigo;
	
	private String descricao;
	
	private String sigla;

	private TipoCanalPagamentoEnumeration(Integer codigo, String descricao, String sigla) {
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
