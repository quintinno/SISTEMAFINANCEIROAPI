package br.com.plataformalancamento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_PESSOA")
public class PessoaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PESSOA",sequenceName = "SEQ_PESSOA", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "NOME", unique = true)
	private String nome;

	@Column(name = "NOME_PESSOA_SISTEMA")
	private String nomePessoaJuridicaSistema;
	
	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isAtivo;
	
	@Column(name = "IS_INSTITUICAO_FINANCEIRA", nullable = false)
	private Boolean isInstituicaoFinanceira;
	
	@Column(name = "IS_PESSOA_FINANCEIRA", nullable = false)
	private Boolean isPessoaFinanceira;

	@JsonProperty("tipoPessoa")
	@OneToOne
	@JoinColumn(name = "ID_TIPO_PESSOA", referencedColumnName = "codigo", nullable = false)
	private TipoPessoaEntity tipoPessoaEntity;

	public PessoaEntity() { }

	public PessoaEntity(String nome, String nomeFantasia, Boolean isAtivo, TipoPessoaEntity tipoPessoaEntity) {
		this.nome = nome;
		this.isAtivo = isAtivo;
		this.tipoPessoaEntity = tipoPessoaEntity;
	}

	public PessoaEntity(String nome, Boolean isAtivo, Boolean isInstituicaoFinanceira, TipoPessoaEntity tipoPessoaEntity) {
		this.nome = nome;
		this.isAtivo = isAtivo;
		this.isInstituicaoFinanceira = isInstituicaoFinanceira;
		this.tipoPessoaEntity = tipoPessoaEntity;
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

	public String getNomePessoaJuridicaSistema() {
		return nomePessoaJuridicaSistema;
	}

	public void setNomePessoaJuridicaSistema(String nomePessoaJuridicaSistema) {
		this.nomePessoaJuridicaSistema = nomePessoaJuridicaSistema;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Boolean getIsInstituicaoFinanceira() {
		return isInstituicaoFinanceira;
	}

	public void setIsInstituicaoFinanceira(Boolean isInstituicaoFinanceira) {
		this.isInstituicaoFinanceira = isInstituicaoFinanceira;
	}

	public Boolean getIsPessoaFinanceira() {
		return isPessoaFinanceira;
	}

	public void setIsPessoaFinanceira(Boolean isPessoaFinanceira) {
		this.isPessoaFinanceira = isPessoaFinanceira;
	}

	public TipoPessoaEntity getTipoPessoaEntity() {
		return tipoPessoaEntity;
	}

	public void setTipoPessoaEntity(TipoPessoaEntity tipoPessoaEntity) {
		this.tipoPessoaEntity = tipoPessoaEntity;
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
		PessoaEntity other = (PessoaEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PessoaEntity [codigo=" + codigo + ", nome=" + nome + ", isAtivo=" + isAtivo
				+ ", isInstituicaoFinanceira=" + isInstituicaoFinanceira + ", tipoPessoaEntity=" + tipoPessoaEntity
				+ "]";
	}

}
