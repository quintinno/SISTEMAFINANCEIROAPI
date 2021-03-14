package br.com.plataformalancamento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_FORMA_PAGAMENTO_DESPESA")
public class FormaPagamentoDespesaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@SequenceGenerator(name = "SEQ_CATEGORIA_DESPESA", sequenceName = "SEQ_CATEGORIA_DESPESA", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@JsonProperty("formaPagamento")
	@OneToOne
	@JoinColumn(name = "ID_FORMA_PAGAMENTO", referencedColumnName = "codigo", nullable = false)
	private FormaPagamentoEntity formaPagamentoEntity;
	
	@JsonProperty("pessoaPagamento")
	@OneToOne
	@JoinColumn(name = "ID_PESSOA_PAGAMENTO", referencedColumnName = "codigo", nullable = false)
	private PessoaEntity pessoaPagamento;
	
	@Column(name = "NUMERO_PARCELAMENTO", nullable = false)
	private Integer numeroParcelamento;
	
	@Column(name = "VALOR_PAGAMENTO", nullable = false)
	private Double valorPagamento;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_DESPESA", referencedColumnName = "codigo", nullable = false)
	private DespesaEntity despesaEntity;

	public FormaPagamentoDespesaEntity() { }
	
	public FormaPagamentoDespesaEntity(FormaPagamentoEntity formaPagamentoEntity, PessoaEntity pessoaPagamento, Integer numeroParcelamento, Double valorPagamento) {
		this.formaPagamentoEntity = formaPagamentoEntity;
		this.pessoaPagamento = pessoaPagamento;
		this.numeroParcelamento = numeroParcelamento;
		this.valorPagamento = valorPagamento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public FormaPagamentoEntity getFormaPagamentoEntity() {
		return formaPagamentoEntity;
	}

	public void setFormaPagamentoEntity(FormaPagamentoEntity formaPagamentoEntity) {
		this.formaPagamentoEntity = formaPagamentoEntity;
	}

	public PessoaEntity getPessoaPagamento() {
		return pessoaPagamento;
	}

	public void setPessoaPagamento(PessoaEntity pessoaPagamento) {
		this.pessoaPagamento = pessoaPagamento;
	}

	public Integer getNumeroParcelamento() {
		return numeroParcelamento;
	}

	public void setNumeroParcelamento(Integer numeroParcelamento) {
		this.numeroParcelamento = numeroParcelamento;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
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
		FormaPagamentoDespesaEntity other = (FormaPagamentoDespesaEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
