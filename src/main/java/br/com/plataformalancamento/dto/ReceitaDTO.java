package br.com.plataformalancamento.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.plataformalancamento.entity.ReceitaEntity;
import br.com.plataformalancamento.enumeration.TipoReceitaEnumeration;
import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;

public class ReceitaDTO implements Serializable {

    private static final long serialVersionUID = -4718032504740630807L;

    private Long codigo;
    
    private String identificador;
    
    @JsonProperty("tipoReceita")
	private TipoReceitaEnumeration tipoReceitaEnumeration;
    
    private Double valorPago;
    
    @JsonProperty("situacaoPagamento")
    private TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration;

    public ReceitaDTO(ReceitaEntity receitaEntity) {
        this.codigo = receitaEntity.getCodigo();
        this.identificador = receitaEntity.getIdentificador();
        this.valorPago = receitaEntity.getValorPagamento();
        this.tipoSituacaoPagamentoEnumeration = receitaEntity.getTipoSituacaoPagamentoEnumeration();
        this.tipoReceitaEnumeration = receitaEntity.getTipoReceitaEnumeration();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public TipoSituacaoPagamentoEnumeration getTipoSituacaoPagamentoEnumeration() {
        return tipoSituacaoPagamentoEnumeration;
    }

    public void setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration) {
        this.tipoSituacaoPagamentoEnumeration = tipoSituacaoPagamentoEnumeration;
    }

	public TipoReceitaEnumeration getTipoReceitaEnumeration() {
		return tipoReceitaEnumeration;
	}

	public void setTipoReceitaEnumeration(TipoReceitaEnumeration tipoReceitaEnumeration) {
		this.tipoReceitaEnumeration = tipoReceitaEnumeration;
	}

}
