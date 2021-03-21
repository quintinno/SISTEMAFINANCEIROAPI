package br.com.plataformalancamento.dto;

import java.io.Serializable;

public class CartaoBancarioDTO implements Serializable {

    private static final long serialVersionUID = -4718032504740630807L;

    private Long codigo;
    
    private String numeroCartao;
    
    public CartaoBancarioDTO() { }

	public CartaoBancarioDTO(Long codigo, String numeroCartao) {
		this.codigo = codigo;
		this.numeroCartao = numeroCartao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

}
