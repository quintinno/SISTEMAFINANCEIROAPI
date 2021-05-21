package br.com.plataformalancamento.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	
	private PessoaEntity estabelecimentoPessoa;
	
	private CartaoBancarioEntity cartaoBancarioEntity;
	
	private List<ProdutoServicoEntity> produtoServicoEntityList;
	
	private TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration;
	
	private String identificador;
	
	private Date mesReferencia;
	
	private Date dataVencimento;
	
	private Date dataPagamento;
	
	private Double valorTotal;
	
	private Double valorDesconto;
	
	private Double valorJuros;
	
	private Double valorAtraso;
	
	private Double valorTotalPagamento;
	
	public FaturaBancariaModel() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public PessoaEntity getEstabelecimentoPessoa() {
		return estabelecimentoPessoa;
	}

	public void setEstabelecimentoPessoa(PessoaEntity estabelecimentoPessoa) {
		this.estabelecimentoPessoa = estabelecimentoPessoa;
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

	public Date getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(Date mesReferencia) {
		this.mesReferencia = mesReferencia;
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
