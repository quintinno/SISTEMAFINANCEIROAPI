package br.com.plataformalancamento.dto;

public class FontePagamentoDTO {
	
	private Long codigoInstituicaoFinanceira;
	
	private String nomeInstituicaoFinanceira;
	
	private String descricaoFormaPagamento;
	
	private String numeroCartaoFormaPagamento;
	
	public FontePagamentoDTO() { }

	public Long getCodigoInstituicaoFinanceira() {
		return codigoInstituicaoFinanceira;
	}

	public void setCodigoInstituicaoFinanceira(Long codigoInstituicaoFinanceira) {
		this.codigoInstituicaoFinanceira = codigoInstituicaoFinanceira;
	}

	public String getNomeInstituicaoFinanceira() {
		return nomeInstituicaoFinanceira;
	}

	public void setNomeInstituicaoFinanceira(String nomeInstituicaoFinanceira) {
		this.nomeInstituicaoFinanceira = nomeInstituicaoFinanceira;
	}

	public String getDescricaoFormaPagamento() {
		return descricaoFormaPagamento;
	}

	public void setDescricaoFormaPagamento(String descricaoFormaPagamento) {
		this.descricaoFormaPagamento = descricaoFormaPagamento;
	}

	public String getNumeroCartaoFormaPagamento() {
		return numeroCartaoFormaPagamento;
	}

	public void setNumeroCartaoFormaPagamento(String numeroCartaoFormaPagamento) {
		this.numeroCartaoFormaPagamento = numeroCartaoFormaPagamento;
	}
	
}
