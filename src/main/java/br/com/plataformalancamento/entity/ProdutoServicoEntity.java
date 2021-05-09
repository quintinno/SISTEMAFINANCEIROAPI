package br.com.plataformalancamento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_PRODUTO_SERVICO")
public class ProdutoServicoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@SequenceGenerator(name = "SEQ_PRODUTO_SERVICO", sequenceName = "SEQ_PRODUTO_SERVICO", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;

	@Column(name = "DESCRICAO", unique = true)
	private String descricao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_DESPESA", referencedColumnName = "codigo", nullable = true)
	private DespesaEntity despesaEntity;
	
	public ProdutoServicoEntity() { }

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

	public DespesaEntity getDespesaEntity() {
		return despesaEntity;
	}

	public void setDespesaEntity(DespesaEntity despesaEntity) {
		this.despesaEntity = despesaEntity;
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
		ProdutoServicoEntity other = (ProdutoServicoEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
