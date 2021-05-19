package br.com.plataformalancamento.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_COMPOSICAO_SALARIO")
public class ComposicaoSalarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_BENEFICIO", sequenceName = "SEQ_BENEFICIO", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@Column(name = "VALOR_SALARIO_BRUTO", nullable = false)
	private Double valorSalarioBruto;
	
	@Column(name = "VALOR_TOTAL_DESCONTO", nullable = false)
	private Double valorTotalDesconto;
	
	@Column(name = "VALOR_SALARIO_LIQUIDO", nullable = false)
	private Double valorSalarioLiquido;
	
	@Column(name = "DATA_REFERENCIA", unique = true, nullable = false)
	private String dataReferencia;
	
	@JsonProperty("beneficioValorList")
	@OneToMany(mappedBy = "composicaoSalarioEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<BeneficioValorEntity> beneficioValorEntityList  = new ArrayList<>();
	
	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isAtivo;
	
	public ComposicaoSalarioEntity() { }
	
	public void adicionarBeneficioValorDespesa(BeneficioValorEntity beneficioValorEntity) {
		beneficioValorEntity.setComposicaoSalarioEntity(this);
		this.beneficioValorEntityList.add(beneficioValorEntity);
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Double getValorSalarioBruto() {
		return valorSalarioBruto;
	}

	public void setValorSalarioBruto(Double valorSalarioBruto) {
		this.valorSalarioBruto = valorSalarioBruto;
	}

	public Double getValorSalarioLiquido() {
		return valorSalarioLiquido;
	}

	public void setValorSalarioLiquido(Double valorSalarioLiquido) {
		this.valorSalarioLiquido = valorSalarioLiquido;
	}

	public Double getValorTotalDesconto() {
		return valorTotalDesconto;
	}

	public void setValorTotalDesconto(Double valorTotalDesconto) {
		this.valorTotalDesconto = valorTotalDesconto;
	}

	public String getDataReferencia() {
		return dataReferencia;
	}

	public void setDataReferencia(String dataReferencia) {
		this.dataReferencia = dataReferencia;
	}

	public List<BeneficioValorEntity> getBeneficioValorEntityList() {
		return beneficioValorEntityList;
	}

	public void setBeneficioValorEntityList(List<BeneficioValorEntity> beneficioValorEntityList) {
		this.beneficioValorEntityList = beneficioValorEntityList;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
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
		ComposicaoSalarioEntity other = (ComposicaoSalarioEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
