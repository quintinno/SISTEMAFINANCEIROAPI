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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.plataformalancamento.enumeration.TipoPeriodoFinanceiroEnumeration;

@Entity
@Table(name = "TB_CONTRATO")
public class ContratoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_CONTRATO", sequenceName = "SEQ_CONTRATO", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
//	@NotEmpty(message = "O campo do Identificador não pode ser Vazio")
//	@NotNull(message = "O campo do Identificador não pode ser Nullo")
	@Length(min = 5, max = 45,message = "O campo do Identificador precisa ter entre {min} e {max} caracteres")
	@Column(name = "IDENTIFICADOR", unique = true)
	private String identificador;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_INICIO_VIGENCIA")
	private Date dataInicioVigencia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_FIM_VIGENCIA")
	private Date dataFimVigencia;
	
	@Column(name = "DIA_VENCIMENTO_FATURA")
	private Integer diaVencimentoFatura;
	
	@Column(name = "DATA_PAGAMENTO")
	private Integer dataPagamento;
	
	@Column(name = "VALOR_MENSAL_PAGAMENTO", scale = 10, precision = 2)
	private Double valorMensalPagamento;
	
	@JsonProperty("tipoContrato")
	@OneToOne
	@JoinColumn(name = "ID_TIPO_CONTRATO", referencedColumnName = "codigo", nullable = false)
	private TipoContratoEntity tipoContratoEntity;
	
	@OneToOne
	@JoinColumn(name = "ID_PESSOA_CONTRATANTE", referencedColumnName = "codigo", nullable = false)
	private PessoaEntity pessoaContratante;
	
	@OneToOne
	@JoinColumn(name = "ID_PESSOA_CONTRATADO", referencedColumnName = "codigo", nullable = false)
	private PessoaEntity pessoaContratado;

	@JsonProperty("tipoPeriodoFinanceiro")
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_PERIODO_FINANCEIRO")
	private TipoPeriodoFinanceiroEnumeration tipoPeriodoFinanceiroEnumeration;

	@Column(name = "NUMERO_MESES_VIGENCIA_CONTRATO")
	private Integer numeroMesesVigenciaContrato;
	
	@JsonProperty("chavePixModelList")
	@OneToMany(mappedBy = "contratoEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ChavePixModel> chavePixModelList  = new ArrayList<>();
	
	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isATivo;
	
	public ContratoEntity() { }
	
	public void adicionarChavePix(ChavePixModel chavePixModel) {
		chavePixModel.setContratoEntity(this);
		this.chavePixModelList.add(chavePixModel);
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(Date dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public Date getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(Date dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

	public Boolean getIsATivo() {
		return isATivo;
	}

	public void setIsATivo(Boolean isATivo) {
		this.isATivo = isATivo;
	}

	public TipoContratoEntity getTipoContratoEntity() {
		return tipoContratoEntity;
	}

	public void setTipoContratoEntity(TipoContratoEntity tipoContratoEntity) {
		this.tipoContratoEntity = tipoContratoEntity;
	}

	public PessoaEntity getPessoaContratante() {
		return pessoaContratante;
	}

	public void setPessoaContratante(PessoaEntity pessoaContratante) {
		this.pessoaContratante = pessoaContratante;
	}

	public PessoaEntity getPessoaContratado() {
		return pessoaContratado;
	}

	public void setPessoaContratado(PessoaEntity pessoaContratado) {
		this.pessoaContratado = pessoaContratado;
	}

	public Boolean getATivo() {
		return isATivo;
	}

	public void setATivo(Boolean ATivo) {
		isATivo = ATivo;
	}

	public TipoPeriodoFinanceiroEnumeration getTipoPeriodoFinanceiroEnumeration() {
		return tipoPeriodoFinanceiroEnumeration;
	}

	public void setTipoPeriodoFinanceiroEnumeration(TipoPeriodoFinanceiroEnumeration tipoPeriodoFinanceiroEnumeration) {
		this.tipoPeriodoFinanceiroEnumeration = tipoPeriodoFinanceiroEnumeration;
	}

	public Integer getNumeroMesesVigenciaContrato() {
		return numeroMesesVigenciaContrato;
	}

	public void setNumeroMesesVigenciaContrato(Integer numeroMesesVigenciaContrato) {
		this.numeroMesesVigenciaContrato = numeroMesesVigenciaContrato;
	}

	public Integer getDiaVencimentoFatura() {
		return diaVencimentoFatura;
	}

	public void setDiaVencimentoFatura(Integer diaVencimentoFatura) {
		this.diaVencimentoFatura = diaVencimentoFatura;
	}

	public Double getValorMensalPagamento() {
		return valorMensalPagamento;
	}

	public void setValorMensalPagamento(Double valorMensalPagamento) {
		this.valorMensalPagamento = valorMensalPagamento;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Integer getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Integer dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	public List<ChavePixModel> getChavePixModelList() {
		return chavePixModelList;
	}

	public void setChavePixModelList(List<ChavePixModel> chavePixModelList) {
		this.chavePixModelList = chavePixModelList;
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
		ContratoEntity other = (ContratoEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContratoEntity [codigo=" + codigo + ", tipoContratoEntity=" + tipoContratoEntity.getDescricao() + ", pessoaContratante=" + pessoaContratante.getNome() + ", pessoaContratado=" + pessoaContratado.getNome() + "]";
	}

}
