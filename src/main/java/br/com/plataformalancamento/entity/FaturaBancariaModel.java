package br.com.plataformalancamento.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;

@Entity
@Table(name = "TB_FATURA_BANCARIA")
public class FaturaBancariaModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_FATURA_BANCARIA", sequenceName = "SEQ_FATURA_BANCARIA", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@OneToOne
	@JoinColumn(name = "ID_CARTAO_BANCARIO", referencedColumnName = "CODIGO", nullable = false)
	private CartaoBancarioEntity cartaoBancarioEntity;
	
	@JsonProperty("produtoServicoList")
	@OneToMany(mappedBy = "faturaBancariaModel", fetch = FetchType.LAZY)
	private List<ProdutoServicoEntity> produtoServicoEntityList = new ArrayList<>();
	
	@JsonProperty("tipoSituacaoPagamento")
	@Enumerated(EnumType.STRING)
	@Column(name = "ID_SITUACAO_PAGAMENTO")
	private TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration;
	
	@Column(name = "IDENTIFICADOR")
	private String identificador;
	
	@JsonFormat(pattern = "MM/yyyy")
	@Column(name = "DATA_REFERENCIA")
	private String dataReferencia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_VENCIMENTO")
	private Date dataVencimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_PAGAMENTO")
	private Date dataPagamento;
	
	@Column(name = "VALOR_TOTAL")
	private Double valorTotal;
	
	@Column(name = "VALOR_DESCONTO")
	private Double valorDesconto;
	
	@Column(name = "VALOR_JUROS")
	private Double valorJuros;
	
	@Column(name = "VALOR_ATRASO")
	private Double valorAtraso;
	
	@Column(name = "VALOR_TOTAL_PAGAMENTO")
	private Double valorTotalPagamento;
	
	public FaturaBancariaModel() { }
	
	public void adicionarProdutoServico(ProdutoServicoEntity produtoServicoEntity, FaturaBancariaModel faturaBancariaModel) {
		produtoServicoEntity.setFaturaBancariaModel(faturaBancariaModel);
		this.produtoServicoEntityList.add(produtoServicoEntity);
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public CartaoBancarioEntity getCartaoBancarioEntity() {
		return cartaoBancarioEntity;
	}

	public void setCartaoBancarioEntity(CartaoBancarioEntity cartaoBancarioEntity) {
		this.cartaoBancarioEntity = cartaoBancarioEntity;
	}

	public List<ProdutoServicoEntity> getProdutoServicoEntityList() {
		return produtoServicoEntityList;
	}

	public void setProdutoServicoEntityList(List<ProdutoServicoEntity> produtoServicoEntityList) {
		this.produtoServicoEntityList = produtoServicoEntityList;
	}

	public TipoSituacaoPagamentoEnumeration getTipoSituacaoPagamentoEnumeration() {
		return tipoSituacaoPagamentoEnumeration;
	}

	public void setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration) {
		this.tipoSituacaoPagamentoEnumeration = tipoSituacaoPagamentoEnumeration;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDataReferencia() {
		return dataReferencia;
	}

	public void setDataReferencia(String dataReferencia) {
		this.dataReferencia = dataReferencia;
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

	public Double getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(Double valorJuros) {
		this.valorJuros = valorJuros;
	}

	public Double getValorAtraso() {
		return valorAtraso;
	}

	public void setValorAtraso(Double valorAtraso) {
		this.valorAtraso = valorAtraso;
	}

	public Double getValorTotalPagamento() {
		return valorTotalPagamento;
	}

	public void setValorTotalPagamento(Double valorTotalPagamento) {
		this.valorTotalPagamento = valorTotalPagamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		FaturaBancariaModel other = (FaturaBancariaModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
