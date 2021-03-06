package br.com.plataformalancamento.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;

@Entity
@Table(name = "TB_PARCELAMENTO")
public class ParcelamentoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PARCELAMENTO", sequenceName = "SEQ_PARCELAMENTO", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "NUMERO_PARCELA", nullable = false)
	private Integer numeroParcela;
	
	@Column(name = "VALOR_PREVISTO_PARCELA", scale = 10, precision = 2, nullable = false)
	private Double valorPrevistoParcela;
	
	@Column(name = "VALOR_EFETIVO_PARCELA", scale = 10, precision = 2)
	private Double valorEfetivoParcela;
	
	@Column(name = "VALOR_TOTAL_PARCELAMENTO", scale = 10, precision = 2, nullable = false)
	private Double valorTotalParcelamento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_VENCIMENTO_PARCELA")
	private Date dataVencimentoParcela;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_PAGAMENTO_PARCELA")
	private Date dataPagamentoParcela;
	
	@JsonProperty("situacaoPagamento")
	@Enumerated(EnumType.STRING)
	@Column(name = "SITUACAO_PAGAMENTO")
	private TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration;
	
//	@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name = "ID_RECEITA", referencedColumnName = "codigo", nullable = false)
//	private ReceitaEntity receitaEntity;
	
	@ManyToOne
	@JoinColumn(name = "ID_DESPESA", referencedColumnName = "codigo")
	private DespesaEntity despesaEntity;
	
	public ParcelamentoEntity() { }
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public Double getValorPrevistoParcela() {
		return valorPrevistoParcela;
	}

	public void setValorPrevistoParcela(Double valorPrevistoParcela) {
		this.valorPrevistoParcela = valorPrevistoParcela;
	}

	public Double getValorEfetivoParcela() {
		return valorEfetivoParcela;
	}

	public void setValorEfetivoParcela(Double valorEfetivoParcela) {
		this.valorEfetivoParcela = valorEfetivoParcela;
	}

	public Double getValorTotalParcelamento() {
		return valorTotalParcelamento;
	}

	public void setValorTotalParcelamento(Double valorTotalParcelamento) {
		this.valorTotalParcelamento = valorTotalParcelamento;
	}

	public Date getDataVencimentoParcela() {
		return dataVencimentoParcela;
	}

	public void setDataVencimentoParcela(Date dataVencimentoParcela) {
		this.dataVencimentoParcela = dataVencimentoParcela;
	}

	public Date getDataPagamentoParcela() {
		return dataPagamentoParcela;
	}

	public void setDataPagamentoParcela(Date dataPagamentoParcela) {
		this.dataPagamentoParcela = dataPagamentoParcela;
	}

	public TipoSituacaoPagamentoEnumeration getTipoSituacaoPagamentoEnumeration() {
		return tipoSituacaoPagamentoEnumeration;
	}

	public void setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration) {
		this.tipoSituacaoPagamentoEnumeration = tipoSituacaoPagamentoEnumeration;
	}

//	public ReceitaEntity getReceitaEntity() {
//		return receitaEntity;
//	}
//
//	public void setReceitaEntity(ReceitaEntity receitaEntity) {
//		this.receitaEntity = receitaEntity;
//	}

	public DespesaEntity getDespesaEntity() {
		return despesaEntity;
	}

	public void setDespesaEntity(DespesaEntity despesaEntity) {
		this.despesaEntity = despesaEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParcelamentoEntity other = (ParcelamentoEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
