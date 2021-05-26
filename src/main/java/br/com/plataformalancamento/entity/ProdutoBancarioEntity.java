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

@Entity
@Table(name = "TB_PRODUTO_BANCARIO")
public class ProdutoBancarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PRODUTO_BANCARIO", sequenceName = "SEQ_PRODUTO_BANCARIO", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "ID_CONTA_BANCARIA", referencedColumnName = "codigo", nullable = false)
	private ContaBancariaEntity contaBancariaEntity;
	
	@OneToOne
	@JoinColumn(name = "ID_TIPO_CONTA_BANCARIA", referencedColumnName = "codigo", nullable = false)
	private TipoContaBancariaEntity tipoContaBancariaEntity;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "NUMERO_CONTA", nullable = false)
	private String numeroConta;
	
	@Column(name = "IS_ATIVO")
	private Boolean isAtivo;
	
	public ProdutoBancarioEntity() { }
	
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

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public ContaBancariaEntity getContaBancariaEntity() {
		return contaBancariaEntity;
	}

	public void setContaBancariaEntity(ContaBancariaEntity contaBancariaEntity) {
		this.contaBancariaEntity = contaBancariaEntity;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public TipoContaBancariaEntity getTipoContaBancariaEntity() {
		return tipoContaBancariaEntity;
	}

	public void setTipoContaBancariaEntity(TipoContaBancariaEntity tipoContaBancariaEntity) {
		this.tipoContaBancariaEntity = tipoContaBancariaEntity;
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
		ProdutoBancarioEntity other = (ProdutoBancarioEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
