package br.com.plataformalancamento.dto;

import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class DespesaFixaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigoDespesa;
	private Long codigoContrato;

	private Long codigoParcela;
	private String nomeFavorecido;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	private Date dataPagamento;

	private Double valorParcela;

	@JsonProperty("situacaoPagamento")
	private TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration;

	public DespesaFixaDTO() { }

	public DespesaFixaDTO(Long codigoDespesa, Long codigoParcela, String nomeFavorecido, Date dataVencimento, Double valorParcela, TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration) {
		this.codigoDespesa = codigoDespesa;
		this.codigoParcela = codigoParcela;
		this.nomeFavorecido = nomeFavorecido;
		this.dataVencimento = dataVencimento;
		this.valorParcela = valorParcela;
		this.tipoSituacaoPagamentoEnumeration = tipoSituacaoPagamentoEnumeration;
	}

	public Long getCodigoDespesa() {
		return codigoDespesa;
	}

	public void setCodigoDespesa(Long codigoDespesa) {
		this.codigoDespesa = codigoDespesa;
	}

	public Long getCodigoContrato() {
		return codigoContrato;
	}

	public void setCodigoContrato(Long codigoContrato) {
		this.codigoContrato = codigoContrato;
	}

	public String getNomeFavorecido() {
		return nomeFavorecido;
	}

	public void setNomeFavorecido(String nomeFavorecido) {
		this.nomeFavorecido = nomeFavorecido;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public TipoSituacaoPagamentoEnumeration getTipoSituacaoPagamentoEnumeration() {
		return tipoSituacaoPagamentoEnumeration;
	}

	public void setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration) {
		this.tipoSituacaoPagamentoEnumeration = tipoSituacaoPagamentoEnumeration;
	}

	public Long getCodigoParcela() {
		return codigoParcela;
	}

	public void setCodigoParcela(Long codigoParcela) {
		this.codigoParcela = codigoParcela;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
