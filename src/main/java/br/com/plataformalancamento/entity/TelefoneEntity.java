package br.com.plataformalancamento.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

@Entity
@Table(name = "TB_TELEFONE")
public class TelefoneEntity implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_TELEFONE",sequenceName = "SEQ_TELEFONE", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "IDENTIFICADOR_DDI")
	private String identidicadorDDI;
	
	@Column(name = "IDENTIFICADOR_DDD")
	private String identidicadorDDD;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "IS_MENSAGERIA")
	private Boolean isMensageria;
	
	@OneToOne
	@JoinColumn(name = "ID_TIPO_TELEFONE", referencedColumnName = "codigo", nullable = false)
	private TipoTelefoneEntity tipoTelefoneEntity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PESSOA", referencedColumnName = "codigo", nullable = false)
	private PessoaEntity pessoaEntity;
	
	public TelefoneEntity() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getIdentidicadorDDI() {
		return identidicadorDDI;
	}

	public void setIdentidicadorDDI(String identidicadorDDI) {
		this.identidicadorDDI = identidicadorDDI;
	}

	public String getIdentidicadorDDD() {
		return identidicadorDDD;
	}

	public void setIdentidicadorDDD(String identidicadorDDD) {
		this.identidicadorDDD = identidicadorDDD;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Boolean getIsMensageria() {
		return isMensageria;
	}

	public void setIsMensageria(Boolean isMensageria) {
		this.isMensageria = isMensageria;
	}

	public TipoTelefoneEntity getTipoTelefoneEntity() {
		return tipoTelefoneEntity;
	}

	public void setTipoTelefoneEntity(TipoTelefoneEntity tipoTelefoneEntity) {
		this.tipoTelefoneEntity = tipoTelefoneEntity;
	}

	public PessoaEntity getPessoaEntity() {
		return pessoaEntity;
	}

	public void setPessoaEntity(PessoaEntity pessoaEntity) {
		this.pessoaEntity = pessoaEntity;
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
		TelefoneEntity other = (TelefoneEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
