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

@Entity
@Table(name = "TB_CIDADE")
public class CidadeEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_CIDADE", sequenceName = "SEQ_CIDADE", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "NOME", length = 85, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "ID_ESTADO", referencedColumnName = "codigo", nullable = false)
	private EstadoEntity estadoEntity;
	
	public CidadeEntity() { }
	
	public CidadeEntity(String nome) {
		this.nome = nome;
	}

	public CidadeEntity(String nome, EstadoEntity estadoEntity) {
		this.nome = nome;
		this.estadoEntity = estadoEntity;
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
		CidadeEntity other = (CidadeEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EstadoEntity getEstadoEntity() {
		return estadoEntity;
	}

	public void setEstadoEntity(EstadoEntity estadoEntity) {
		this.estadoEntity = estadoEntity;
	}	

}
