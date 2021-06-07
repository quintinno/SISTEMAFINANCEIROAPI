package br.com.plataformalancamento.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_CONTA_BANCARIA")
public class ContaBancariaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_CONTA_BANCARIA", sequenceName = "SEQ_CONTA_BANCARIA", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "NUMERO_AGENCIA", unique = true, nullable = false)
	private String numeroAgencia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ABERTURA")
	private Date dataAbertura;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ENCERRAMENTO")
	private Date dataFechamento;
	
	@Column(name = "VALOR_SALDO_ATUAL", nullable = false)
	private Double valorSaldoAtual;
	
	@OneToOne
	@JoinColumn(name = "ID_CIDADE_AGENCIA_BANCARIA", referencedColumnName = "codigo")
	private CidadeEntity cidadeEntity;
	
	@JsonProperty("contrato")
	@OneToOne
	@JoinColumn(name = "ID_CONTRATO", referencedColumnName = "CODIGO", nullable = false)
	private ContratoEntity contratoEntity;
	
	@OneToOne
	@JoinColumn(name = "ID_PESSOA_INSTITUICAO_FINANCEIRA", referencedColumnName = "CODIGO", nullable = false)
	private PessoaEntity pessoaInstituicaoFinanceira;
	
	@Column(name = "IS_BENEFICIO", nullable = false)
	private Boolean isBeneficio;
	
	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isAtivo;
	
	public ContaBancariaEntity() { }
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Double getValorSaldoAtual() {
		return valorSaldoAtual;
	}

	public void setValorSaldoAtual(Double valorSaldoAtual) {
		this.valorSaldoAtual = valorSaldoAtual;
	}

	public ContratoEntity getContratoEntity() {
		return contratoEntity;
	}

	public void setContratoEntity(ContratoEntity contratoEntity) {
		this.contratoEntity = contratoEntity;
	}

	public PessoaEntity getPessoaInstituicaoFinanceira() {
		return pessoaInstituicaoFinanceira;
	}

	public void setPessoaInstituicaoFinanceira(PessoaEntity pessoaInstituicaoFinanceira) {
		this.pessoaInstituicaoFinanceira = pessoaInstituicaoFinanceira;
	}

	public Boolean getIsBeneficio() {
		return isBeneficio;
	}

	public void setIsBeneficio(Boolean isBeneficio) {
		this.isBeneficio = isBeneficio;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public CidadeEntity getCidadeEntity() {
		return cidadeEntity;
	}

	public void setCidadeEntity(CidadeEntity cidadeEntity) {
		this.cidadeEntity = cidadeEntity;
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
		ContaBancariaEntity other = (ContaBancariaEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
