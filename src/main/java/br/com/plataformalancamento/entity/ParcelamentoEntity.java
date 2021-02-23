package br.com.plataformalancamento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "VALOR_PARCELA", scale = 10, precision = 2, nullable = false)
	private Double valorParcela;
	
	@Column(name = "VALOR_TOTAL_PARCELAMENTO", scale = 10, precision = 2, nullable = false)
	private Double valorTotalParcelamento;
	
	@Column(name = "IS_PAGO", nullable = false)
	private Boolean isPago;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_RECEITA", referencedColumnName = "codigo", nullable = false)
	private ReceitaEntity receitaEntity;
	
	public ParcelamentoEntity() { }

	public ParcelamentoEntity(Integer numeroParcela, Double valorParcela, Double valorTotalParcela, Boolean isPago) {
		this.numeroParcela = numeroParcela;
		this.valorParcela = valorParcela;
		this.valorTotalParcelamento = valorTotalParcela;
		this.isPago = isPago;
	}

	public ParcelamentoEntity(Boolean isPago) {
		this.isPago = isPago;
	}

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

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Double getValorTotalParcelamento() {
		return valorTotalParcelamento;
	}

	public void setValorTotalParcelamento(Double valorTotalParcela) {
		this.valorTotalParcelamento = valorTotalParcela;
	}

	public Boolean getIsPago() {
		return isPago;
	}

	public void setIsPago(Boolean isPago) {
		this.isPago = isPago;
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
