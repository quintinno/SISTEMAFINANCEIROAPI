package br.com.plataformalancamento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_BENEFICIO_VALOR")
public class BeneficioValorEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_BENEFICIO_VALOR", sequenceName = "SEQ_BENEFICIO_VALOR", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@Column(name = "VALOR", nullable = false)
	private Double valor;
	
	@Column(name = "IS_CREDITO", nullable = false)
	private Boolean isCredito;

	@OneToOne
	@JoinColumn(name = "ID_BENEFICIO", referencedColumnName = "CODIGO", nullable = false)
	private BeneficioEntity beneficioEntity;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_COMPOSICAO_SALARIO", referencedColumnName = "codigo", nullable = true)
	private ComposicaoSalarioEntity composicaoSalarioEntity;
	
	public BeneficioValorEntity() { }

	public BeneficioValorEntity(BeneficioEntity beneficioEntity, Double valor, Boolean isCredito) {
		this.beneficioEntity = beneficioEntity;
		this.valor = valor;
		this.isCredito = isCredito;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public BeneficioEntity getBeneficioEntity() {
		return beneficioEntity;
	}

	public void setBeneficioEntity(BeneficioEntity beneficioEntity) {
		this.beneficioEntity = beneficioEntity;
	}

	public Boolean getIsCredito() {
		return isCredito;
	}

	public void setIsCredito(Boolean isCredito) {
		this.isCredito = isCredito;
	}

	public ComposicaoSalarioEntity getComposicaoSalarioEntity() {
		return composicaoSalarioEntity;
	}

	public void setComposicaoSalarioEntity(ComposicaoSalarioEntity composicaoSalarioEntity) {
		this.composicaoSalarioEntity = composicaoSalarioEntity;
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
		BeneficioValorEntity other = (BeneficioValorEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
