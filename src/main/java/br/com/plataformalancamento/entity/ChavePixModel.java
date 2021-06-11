package br.com.plataformalancamento.entity;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.plataformalancamento.enumeration.TipoChavePixEnumeration;

@Entity
@Table(name = "TB_CHAVE_PIX")
public class ChavePixModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_CHAVE_PIX", sequenceName = "SEQ_CHAVE_PIX", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "CHAVE_PIX", unique = true)
	private String chavePix;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_CONTRATO", referencedColumnName = "codigo", nullable = true)
	private ContratoEntity contratoEntity;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_CHAVE_PIX")
	private TipoChavePixEnumeration tipoChavePixEnumeration;

	public ChavePixModel() { }
	
	public ChavePixModel(String chavePix) {
		super();
		this.chavePix = chavePix;
	}
	
	public ChavePixModel(TipoChavePixEnumeration tipoChavePixEnumeration, String chavePix) {
		this.chavePix = chavePix;
		this.tipoChavePixEnumeration = tipoChavePixEnumeration;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getChavePix() {
		return chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}

	public TipoChavePixEnumeration getTipoChavePixEnumeration() {
		return tipoChavePixEnumeration;
	}

	public void setTipoChavePixEnumeration(TipoChavePixEnumeration tipoChavePixEnumeration) {
		this.tipoChavePixEnumeration = tipoChavePixEnumeration;
	}

	public ContratoEntity getContratoEntity() {
		return contratoEntity;
	}

	public void setContratoEntity(ContratoEntity contratoEntity) {
		this.contratoEntity = contratoEntity;
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
		ChavePixModel other = (ChavePixModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
