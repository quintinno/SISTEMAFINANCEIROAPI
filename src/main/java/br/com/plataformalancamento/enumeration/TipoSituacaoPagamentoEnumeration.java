package br.com.plataformalancamento.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TipoSituacaoPagamentoEnumeration {
	
	@JsonProperty("Pendente")
	PENDENTE(1, "Pendente", "PND"),
	
	@JsonProperty("Pago")
	PAGO(2, "Pago", "PG"),

	@JsonProperty("Parcialmente Pago")
	PARCIALMENTE_PAGO(2, "Pago", "PG"),

	@JsonProperty("Vencido")
	VENCIDO(3, "Vencido", "VC"),
	
	@JsonProperty("Aguardando Confirmação de Depósito")
	AGUARDANDO_CONFIRMACAO_DEPOSITO(4, "Aguardando Confirmação de Depósito", "ACD"),
	
	@JsonProperty("Aguardando Confirmação de Transferência")
	AGUARDANDO_CONFIRMACAO_TRANSFERENCIA(5, "Aguardando Confirmação de Transferência", "ACT");
	
	private Integer codigo;
	
	private String descricao;
	
	private String sigla;

	private TipoSituacaoPagamentoEnumeration(Integer codigo, String descricao, String sigla) {
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
