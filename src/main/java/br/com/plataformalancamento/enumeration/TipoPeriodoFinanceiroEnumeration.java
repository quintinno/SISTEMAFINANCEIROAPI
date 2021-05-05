package br.com.plataformalancamento.enumeration;

public enum TipoPeriodoFinanceiroEnumeration {
	
	UNICO(1, "Único", "UN", 1), 
	DIARIO(2, "Diário", "DA", 1), 
	QUINZENAL(3, "Quinzenal", "QZ", 15), 
	MENSAL(4, "Mensal", "MS", 30), 
	ANUAL(5, "Anual", "AN", 12), 
	TRIENAL(6, "Trienal", "TN", 3);
	
	private Integer codigo;
	
	private String descricao;
	
	private String sigla;
	
	private Integer valor;

	private TipoPeriodoFinanceiroEnumeration(Integer codigo, String descricao, String sigla) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.sigla = sigla;
	}
	
	private TipoPeriodoFinanceiroEnumeration(Integer codigo, String descricao, String sigla, Integer valor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.sigla = sigla;
		this.valor = valor;
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

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
}
