package br.com.plataformalancamento.dto;

import java.io.Serializable;

public class CartaoBancarioDTO implements Serializable {

    private static final long serialVersionUID = -4718032504740630807L;

    private Long codigo;
    
    private String numero;
    
    private String descricao;
    
    private String nomeInstiticaoFinanceira;
    
    public CartaoBancarioDTO() { }
    
	public CartaoBancarioDTO(Long codigo, String numero, String descricao) {
		this.codigo = codigo;
		this.numero = numero;
		this.descricao = descricao;
	}

	public CartaoBancarioDTO(Long codigo, String numero, String descricao, String nomeInstiticaoFinanceira) {
		this.codigo = codigo;
		this.numero = numero;
		this.descricao = descricao;
		this.nomeInstiticaoFinanceira = nomeInstiticaoFinanceira;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
		return "CartaoBancarioDTO [codigo=" + codigo + ", numero=" + numero + ", descricao=" + descricao + ", nomeInstiticaoFinanceira=" + nomeInstiticaoFinanceira + "]";
	}

}
