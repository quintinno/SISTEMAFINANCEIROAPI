package br.com.plataformalancamento.entity;

import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_RECEITA", referencedColumnName = "codigo", nullable = false)
	private ReceitaEntity receitaEntity;
	
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

	public ReceitaEntity getReceitaEntity() {
		return receitaEntity;
	}

	public void setReceitaEntity(ReceitaEntity receitaEntity) {
		this.receitaEntity = receitaEntity;
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
