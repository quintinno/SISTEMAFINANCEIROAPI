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

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_FUNCAO_CARTAO_BANCARIO")
public class FuncaoCartaoBancarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_FUNCAO_CARTAO_BANCARIO", sequenceName = "SEQ_FUNCAO_CARTAO_BANCARIO", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String descricao;
	
	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isAtivo;
	
	@JsonProperty("cartaoBancario")
	@ManyToOne
	@JoinColumn(name = "ID_CARTAO_BANCARIO", referencedColumnName = "codigo", nullable = false)
	private CartaoBancarioEntity cartaoBancarioEntity;
	
	public FuncaoCartaoBancarioEntity() { }

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

	public CartaoBancarioEntity getCartaoBancarioEntity() {
		return cartaoBancarioEntity;
	}

	public void setCartaoBancarioEntity(CartaoBancarioEntity cartaoBancarioEntity) {
		this.cartaoBancarioEntity = cartaoBancarioEntity;
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
		FuncaoCartaoBancarioEntity other = (FuncaoCartaoBancarioEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
