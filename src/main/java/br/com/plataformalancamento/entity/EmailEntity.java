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
@Table(name = "TB_EMAIL")
public class EmailEntity implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_EMAIL",sequenceName = "SEQ_EMAIL", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "DESCRICAO", length = 85, nullable = false)
	private String descricao;
	
	@Column(name = "IS_PRINCIPAL", nullable = false)
	private Boolean isPrincipal;
	
	@ManyToOne
	@JoinColumn(name = "ID_PESSOA", referencedColumnName = "codigo", nullable = false)
	private PessoaEntity pessoaEntity;

	public EmailEntity() { }

	public EmailEntity(String descricao, Boolean isPrincipal, PessoaEntity pessoaEntity) {
		this.descricao = descricao;
		this.isPrincipal = isPrincipal;
		this.pessoaEntity = pessoaEntity;
	}

	public EmailEntity(String descricao, Boolean isPrincipal) {
		this.descricao = descricao;
		this.isPrincipal = isPrincipal;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getIsPrincipal() {
		return isPrincipal;
	}

	public void setIsPrincipal(Boolean isPrincipal) {
		this.isPrincipal = isPrincipal;
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
		EmailEntity other = (EmailEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
