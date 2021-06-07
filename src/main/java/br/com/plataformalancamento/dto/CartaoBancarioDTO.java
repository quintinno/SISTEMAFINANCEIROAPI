package br.com.plataformalancamento.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartaoBancarioDTO implements Serializable {

    private static final long serialVersionUID = -4718032504740630807L;

    @JsonProperty("codigoCartaoBancario")
    private Long codigoCartaoBancario;
    
    @JsonProperty("codigoContaBancaria")
    private Long codigoContaBancaria;
    
    @JsonProperty("numeroCartaoBancario")
    private String numero;
    
    @JsonProperty("funcaoCartaoBancario")
    private String descricao;
    
    @JsonProperty("nomeInstiticaoFinanceira")
    private String nomeInstiticaoFinanceira;
    
    public CartaoBancarioDTO() { }

	public CartaoBancarioDTO(Long codigoCartaoBancario, String numero, String descricao, String nomeInstiticaoFinanceira) {
		this.codigoCartaoBancario = codigoCartaoBancario;
		this.numero = numero;
		this.descricao = descricao;
		this.nomeInstiticaoFinanceira = nomeInstiticaoFinanceira;
	}
	
	public CartaoBancarioDTO(Long codigoCartaoBancario, Long codigoContaBancaria, String numero, String descricao, String nomeInstiticaoFinanceira) {
		this.codigoCartaoBancario = codigoCartaoBancario;
		this.codigoContaBancaria = codigoContaBancaria;
		this.numero = numero;
		this.descricao = descricao;
		this.nomeInstiticaoFinanceira = nomeInstiticaoFinanceira;
	}

	public Long getCodigoCartaoBancario() {
		return codigoCartaoBancario;
	}

	public void setCodigoCartaoBancario(Long codigoCartaoBancario) {
		this.codigoCartaoBancario = codigoCartaoBancario;
	}

	public Long getCodigoContaBancaria() {
		return codigoContaBancaria;
	}

	public void setCodigoContaBancaria(Long codigoContaBancaria) {
		this.codigoContaBancaria = codigoContaBancaria;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeInstiticaoFinanceira() {
		return nomeInstiticaoFinanceira;
	}

	public void setNomeInstiticaoFinanceira(String nomeInstiticaoFinanceira) {
		this.nomeInstiticaoFinanceira = nomeInstiticaoFinanceira;
	}
	
	@Override
	public String toString() {
		return "CartaoBancarioDTO [codigoCartaoBancario=" + codigoCartaoBancario + ", codigoContaBancaria=" + codigoContaBancaria + ", numero=" + numero + ", descricao=" + descricao + ", nomeInstiticaoFinanceira=" + nomeInstiticaoFinanceira + "]";
	}

}
