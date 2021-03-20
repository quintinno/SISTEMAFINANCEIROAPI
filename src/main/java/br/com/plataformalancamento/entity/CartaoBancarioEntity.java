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

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_CARTAO_BANCARIO")
public class CartaoBancarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_CARTAO_BANCARIO", sequenceName = "SEQ_CARTAO_BANCARIO", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "DESCRICAO", length = 50, unique = true, nullable = false)
	private String descricao;
	
	@Column(name = "DATA_VALIDADE", nullable = false)
	private String dataValidade;
	
	@Column(name = "NOME_IMPRESSO", length = 50, nullable = false)
	private String nomeImpresso;
	
	@ManyToOne
	@JoinColumn(name = "ID_CONTA_BANCARIA", referencedColumnName = "codigo", nullable = false)
	private ContaBancariaEntity contaBancariaEntity;
	
	@JsonProperty("categoriaCartaoBancario")
	@OneToOne
	@JoinColumn(name = "ID_CATEGORIA_CARTAO_BANCARIO", referencedColumnName = "CODIGO", nullable = false)
	private CategoriaCartaoBancarioEntity categoriaCartaoBancarioEntity;
	
	@JsonProperty("bandeiraCartaoBancario")
	@OneToOne
	@JoinColumn(name = "ID_BANDEIRA_CARTAO_BANCARIO", referencedColumnName = "CODIGO", nullable = false)
	private BandeiraCartaoBancarioEntity bandeiraCartaoBancarioEntity;
	
	public CartaoBancarioEntity() { }

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

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getNomeImpresso() {
		return nomeImpresso;
	}

	public void setNomeImpresso(String nomeImpresso) {
		this.nomeImpresso = nomeImpresso;
	}

	public ContaBancariaEntity getContaBancariaEntity() {
		return contaBancariaEntity;
	}

	public void setContaBancariaEntity(ContaBancariaEntity contaBancariaEntity) {
		this.contaBancariaEntity = contaBancariaEntity;
	}

	public CategoriaCartaoBancarioEntity getCategoriaCartaoBancarioEntity() {
		return categoriaCartaoBancarioEntity;
	}

	public void setCategoriaCartaoBancarioEntity(CategoriaCartaoBancarioEntity categoriaCartaoBancarioEntity) {
		this.categoriaCartaoBancarioEntity = categoriaCartaoBancarioEntity;
	}

	public BandeiraCartaoBancarioEntity getBandeiraCartaoBancarioEntity() {
		return bandeiraCartaoBancarioEntity;
	}

	public void setBandeiraCartaoBancarioEntity(BandeiraCartaoBancarioEntity bandeiraCartaoBancarioEntity) {
		this.bandeiraCartaoBancarioEntity = bandeiraCartaoBancarioEntity;
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
		CartaoBancarioEntity other = (CartaoBancarioEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
