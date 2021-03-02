package br.com.plataformalancamento.enumeration;

public enum TipoPeriodoFinanceiroEnumeration {
	
	UNICO(1, "Único", "UN"), 
	DIARIO(2, "Diário", "DA"), 
	QUINZENAL(3, "Quinzenal", "QZ"), 
	MENSAL(4, "Mensal", "MS"), 
	ANUAL(5, "Anual", "AN"), 
	TRIENAL(6, "Trienal", "TN");
	
	private Integer codigo;
	
	private String descricao;
	
	private String sigla;

	private TipoPeriodoFinanceiroEnumeration(Integer codigo, String descricao, String sigla) {
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
