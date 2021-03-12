package br.com.plataformalancamento.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.plataformalancamento.enumeration.TipoCanalPagamentoEnumeration;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_DESPESA")
public class DespesaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@SequenceGenerator(name = "SEQ_DESPESA", sequenceName = "SEQ_DESPESA", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@OneToOne
	@JoinColumn(name = "ID_PESSOA_ESTABELECIMENTO", referencedColumnName = "codigo", nullable = false)
	private PessoaEntity pessoaEstabelecimento;

	@JsonProperty("categoriaDespesa")
	@OneToOne
	@JoinColumn(name = "ID_CATEGORIA_DESPESA", referencedColumnName = "codigo", nullable = false)
	private CategoriaDespesaEntity categoriaDespesaEntity;

	@JsonProperty("produtoServicoList")
	@OneToMany(mappedBy = "despesaEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ProdutoServicoEntity> produtoServicoEntityList = new ArrayList<>();
	
	@JsonProperty("formaPagamentoDespesaList")
	@OneToMany(mappedBy = "despesaEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<FormaPagamentoDespesaEntity> formaPagamentoDespesaEntityList = new ArrayList<>();

	@JsonProperty("canalPagamento")
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_CANAL_PAGAMENTO", nullable = false)
	private TipoCanalPagamentoEnumeration tipoCanalPagamentoEnumeration;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_VENCIMENTO")
	private Date dataVencimento;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_PAGAMENTO")
	private Date dataPagamento;

	@Column(name = "VALOR_TOTAL", scale = 10, precision = 2, nullable = false)
	private Double valorTotal;

	@Column(name = "VALOR_DESCONTO", scale = 10, precision = 2, nullable = false)
	private Double valorDesconto;

	@Column(name = "VALOR_PAGAMENTO", scale = 10, precision = 2, nullable = false)
	private Double valorPagamento;

	@Column(name = "OBSERVACAO")
	private String observacao;

	public DespesaEntity() { }
	
	public void adicionarProdutoServicoDespesa(ProdutoServicoEntity produtoServicoEntity) {
		produtoServicoEntity.setDespesaEntity(this);
		this.produtoServicoEntityList.add(produtoServicoEntity);
	}
	
	public void adicionarFormaPagamentoDespesa(FormaPagamentoDespesaEntity formaPagamentoDespesaEntity) {
		formaPagamentoDespesaEntity.setDespesaEntity(this);
		this.formaPagamentoDespesaEntityList.add(formaPagamentoDespesaEntity);
	}

	public PessoaEntity getPessoaEstabelecimento() {
		return pessoaEstabelecimento;
	}

	public void setPessoaEstabelecimento(PessoaEntity pessoaEstabelecimento) {
		this.pessoaEstabelecimento = pessoaEstabelecimento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public CategoriaDespesaEntity getCategoriaDespesaEntity() {
		return categoriaDespesaEntity;
	}

	public void setCategoriaDespesaEntity(CategoriaDespesaEntity categoriaDespesaEntity) {
		this.categoriaDespesaEntity = categoriaDespesaEntity;
	}

	public List<ProdutoServicoEntity> getProdutoServicoEntityList() {
		return produtoServicoEntityList;
	}

	public void setProdutoServicoEntityList(List<ProdutoServicoEntity> produtoServicoEntityList) {
		this.produtoServicoEntityList = produtoServicoEntityList;
	}
	
	public List<FormaPagamentoDespesaEntity> getFormaPagamentoDespesaEntityList() {
		return formaPagamentoDespesaEntityList;
	}

	public void setFormaPagamentoDespesaEntityList(List<FormaPagamentoDespesaEntity> formaPagamentoDespesaEntityList) {
		this.formaPagamentoDespesaEntityList = formaPagamentoDespesaEntityList;
	}

	public TipoCanalPagamentoEnumeration getTipoCanalPagamentoEnumeration() {
		return tipoCanalPagamentoEnumeration;
	}

	public void setTipoCanalPagamentoEnumeration(TipoCanalPagamentoEnumeration tipoCanalPagamentoEnumeration) {
		this.tipoCanalPagamentoEnumeration = tipoCanalPagamentoEnumeration;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
		DespesaEntity other = (DespesaEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
