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
@Table(name = "TB_PRODUTO_SERVICO_OCORRENCIA")
public class ProdutoServicoOcorrenciaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PRODUTO_SERVICO_OCORRENCIA", sequenceName = "SEQ_PRODUTO_SERVICO_OCORRENCIA", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "QUANTIDADE", nullable = false)
	private Integer quantidade;
	
	@Column(name = "VALOR_UNITARIO", nullable = false)
	private Double valorUnitario;
	
	@JsonProperty("produtoServico")
	@OneToOne
	@JoinColumn(name = "ID_PRODUTO_SERVICO", referencedColumnName = "CODIGO", nullable = false)
	private ProdutoServicoEntity produtoServicoEntity;
	
	public ProdutoServicoOcorrenciaEntity() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public ProdutoServicoEntity getProdutoServicoEntity() {
		return produtoServicoEntity;
	}

	public void setProdutoServicoEntity(ProdutoServicoEntity produtoServicoEntity) {
		this.produtoServicoEntity = produtoServicoEntity;
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
		ProdutoServicoOcorrenciaEntity other = (ProdutoServicoOcorrenciaEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
