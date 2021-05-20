package br.com.plataformalancamento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PARCELAMENTO_RECEITA")
public class ParcelamentoReceitaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PARCELAMENTO_RECEITA", sequenceName = "SEQ_PARCELAMENTO_RECEITA", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	private ReceitaEntity receitaEntity;
	
	private ParcelamentoEntity parcelamentoEntity;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public ReceitaEntity getReceitaEntity() {
		return receitaEntity;
	}

	public void setReceitaEntity(ReceitaEntity receitaEntity) {
		this.receitaEntity = receitaEntity;
	}

	public ParcelamentoEntity getParcelamentoEntity() {
		return parcelamentoEntity;
	}

	public void setParcelamentoEntity(ParcelamentoEntity parcelamentoEntity) {
		this.parcelamentoEntity = parcelamentoEntity;
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
		ParcelamentoReceitaEntity other = (ParcelamentoReceitaEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
