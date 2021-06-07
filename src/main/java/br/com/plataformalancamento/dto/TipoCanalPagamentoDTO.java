package br.com.plataformalancamento.dto;

import java.io.Serializable;

public class TipoCanalPagamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	
	private String descricao;
	
	private String sigla;
	
	private String valor;
	
	public TipoCanalPagamentoDTO() { }
	
	public TipoCanalPagamentoDTO(Integer codigo, String descricao, String sigla) {
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
