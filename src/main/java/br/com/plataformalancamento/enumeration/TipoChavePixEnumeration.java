package br.com.plataformalancamento.enumeration;

public enum TipoChavePixEnumeration {
	
	TELEFONE_CELULAR(1, "Telefone Celular"),
	
	TELEFONE_FIXO(2, "Telefone Fixo"),
	
	EMAIL(3, "E-mail"),
	
	CPF(4, "CPF"),
	
	CNPJ(5, "CNPJ"),
	
	CHAVE_ALEATORIA(6, "Chave Aleatória");
	
	private Integer codigo;
	
	private String descricao;
	
	private TipoChavePixEnumeration(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static TipoChavePixEnumeration recuperarTipoCanalPagamentoEnumeration(String valor) {
		return TipoChavePixEnumeration.valueOf(valor);
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
	
}
