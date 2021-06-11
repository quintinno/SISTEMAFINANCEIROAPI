package br.com.plataformalancamento.dto;

import java.io.Serializable;

public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;

	private String nomePessoaJuridicaSistema;
	
	private TipoPessoaDTO tipoPessoaDTO;
	
	private Boolean isInstituicaoFinanceira;
	
	public PessoaDTO() { }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomePessoaJuridicaSistema() {
		return nomePessoaJuridicaSistema;
	}

	public void setNomePessoaJuridicaSistema(String nomePessoaJuridicaSistema) {
		this.nomePessoaJuridicaSistema = nomePessoaJuridicaSistema;
	}

	public Boolean getIsInstituicaoFinanceira() {
		return isInstituicaoFinanceira;
	}

	public void setIsInstituicaoFinanceira(Boolean isInstituicaoFinanceira) {
		this.isInstituicaoFinanceira = isInstituicaoFinanceira;
	}

	public TipoPessoaDTO getTipoPessoaDTO() {
		return tipoPessoaDTO;
	}

	public void setTipoPessoaDTO(TipoPessoaDTO tipoPessoaDTO) {
		this.tipoPessoaDTO = tipoPessoaDTO;
	}

}
