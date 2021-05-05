package br.com.plataformalancamento.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.plataformalancamento.enumeration.TipoPeriodoFinanceiroEnumeration;
import br.com.plataformalancamento.enumeration.TipoReceitaEnumeration;
import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;

@Entity
@Table(name = "TB_RECEITA")
public class ReceitaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_RECEITA", sequenceName = "SEQ_RECEITA", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_PREVISAO_PAGAMENTO")
	private Date dataPrevisaoRecebimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_RECEBIMENTO_PAGAMENTO")
	private Date dataRecebimentoPagamento;

	@Column(name = "VALOR_PAGAMENTO", scale = 10, precision = 2, nullable = false)
	private Double valorPagamento;

	@NotEmpty(message = "O campo do Identificador não pode ser Vazio")
	@NotNull(message = "O campo do Identificador não pode ser Nullo")
	@Length(min = 5, max = 45,message = "O campo do Identificador precisa ter entre {min} e {max} caracteres")
	@Column(name = "IDENTIFICADOR", unique = true, nullable = false)
	private String identificador;
	
	@Column(name = "QUANTIDADE_PARCELA")
	private Integer quantidadeParcela;
	
	@JsonProperty("tipoReceita")
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_RECEITA")
	private TipoReceitaEnumeration tipoReceitaEnumeration;
	
	@OneToOne
	@JoinColumn(name = "ID_RESPONSAVEL_PAGAMENTO", referencedColumnName = "codigo", nullable = false)
	private PessoaEntity responsavelPagamento;
	
//	@JsonProperty("parcelamento")
//	@OneToMany(mappedBy = "receitaEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//	private List<ParcelamentoEntity> parcelamentoEntityList = new ArrayList<>();
	
	@JsonProperty("tipoFormaPagamento")
	@OneToOne
	@JoinColumn(name = "TIPO_FORMA_PAGAMENTO", referencedColumnName = "codigo", nullable = false)
	private FormaPagamentoEntity tipoFormaPagamentoEntity;
	
	@OneToOne
	@JoinColumn(name = "ID_CONTA_BANCARIA_DEPOSITO", referencedColumnName = "codigo", nullable = false)
	private ContaBancariaEntity contaBancariaDeposito;

	@JsonProperty("tipoSituacaoPagamento")
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_SITUACAO_PAGAMENTO")
	private TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration;
	
	@JsonProperty("tipoPeriodoFinanceiro")
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_PERIODO_FINANCEIRO")
	private TipoPeriodoFinanceiroEnumeration tipoPeriodoFinanceiroEnumeration;
	
	@JsonProperty("categoriaReceita")
	@OneToOne
	@JoinColumn(name = "ID_CATEGORIA_RECEITA", referencedColumnName = "codigo", nullable = false)
	private CategoriaReceitaEntity categoriaReceitaEntity;

	public ReceitaEntity() { }
	
//	public void adicionarParcelamentoReceita(ParcelamentoEntity parcelamentoEntity) {
//		parcelamentoEntity.setReceitaEntity(this);
//		this.parcelamentoEntityList.add(parcelamentoEntity);
//	}O
	
//	@SuppressWarnings("unlikely-arg-type")
//	public void removerParcelamentoReceita(Integer index) {
//		this.parcelamentoEntityList.remove(index);
//	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataPrevisaoRecebimento() {
		return dataPrevisaoRecebimento;
	}

	public void setDataPrevisaoRecebimento(Date dataPrevisaoRecebimento) {
		this.dataPrevisaoRecebimento = dataPrevisaoRecebimento;
	}

	public Date getDataRecebimentoPagamento() {
		return dataRecebimentoPagamento;
	}

	public void setDataRecebimentoPagamento(Date dataRecebimento) {
		this.dataRecebimentoPagamento = dataRecebimento;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Integer getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(Integer quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public TipoReceitaEnumeration getTipoReceitaEnumeration() {
		return tipoReceitaEnumeration;
	}

	public void setTipoReceitaEnumeration(TipoReceitaEnumeration tipoReceitaEnumeration) {
		this.tipoReceitaEnumeration = tipoReceitaEnumeration;
	}

	public PessoaEntity getResponsavelPagamento() {
		return responsavelPagamento;
	}

	public void setResponsavelPagamento(PessoaEntity responsavelPagamento) {
		this.responsavelPagamento = responsavelPagamento;
	}

//	public List<ParcelamentoEntity> getParcelamentoEntityList() {
//		return parcelamentoEntityList;
//	}
//
//	public void setParcelamentoEntityList(List<ParcelamentoEntity> parcelamentoEntityList) {
//		this.parcelamentoEntityList = parcelamentoEntityList;
//	}

	public FormaPagamentoEntity getTipoFormaPagamentoEntity() {
		return tipoFormaPagamentoEntity;
	}

	public void setTipoFormaPagamentoEntity(FormaPagamentoEntity tipoFormaPagamentoEntity) {
		this.tipoFormaPagamentoEntity = tipoFormaPagamentoEntity;
	}

	public ContaBancariaEntity getContaBancariaDeposito() {
		return contaBancariaDeposito;
	}

	public void setContaBancariaDeposito(ContaBancariaEntity contaBancariaDeposito) {
		this.contaBancariaDeposito = contaBancariaDeposito;
	}

	public TipoSituacaoPagamentoEnumeration getTipoSituacaoPagamentoEnumeration() {
		return tipoSituacaoPagamentoEnumeration;
	}

	public void setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration) {
		this.tipoSituacaoPagamentoEnumeration = tipoSituacaoPagamentoEnumeration;
	}

	public TipoPeriodoFinanceiroEnumeration getTipoPeriodoFinanceiroEnumeration() {
		return tipoPeriodoFinanceiroEnumeration;
	}

	public void setTipoPeriodoFinanceiroEnumeration(TipoPeriodoFinanceiroEnumeration tipoPeriodoFinanceiroEnumeration) {
		this.tipoPeriodoFinanceiroEnumeration = tipoPeriodoFinanceiroEnumeration;
	}

	public CategoriaReceitaEntity getCategoriaReceitaEntity() {
		return categoriaReceitaEntity;
	}

	public void setCategoriaReceitaEntity(CategoriaReceitaEntity categoriaReceitaEntity) {
		this.categoriaReceitaEntity = categoriaReceitaEntity;
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
		ReceitaEntity other = (ReceitaEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
