package br.com.plataformalancamento.entity;

import java.io.Serializable;
import java.util.Date;

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
	
	@Column(name = "NUMERO_CONTA", unique = true, nullable = false)
	private String numeroConta;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ABERTURA")
	private Date dataAbertura;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ENCERRAMENTO")
	private Date dataFechamento;
	
	@Column(name = "VALOR_SALDO_INICIAL", nullable = false)
	private Double valorSaldoInicial;

	@JsonProperty("tipoContaBancaria")
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_CONTA_BANCARIA", referencedColumnName = "CODIGO", nullable = false)
	private TipoContaBancariaEntity tipoContaBancariaEntity;
	
	@JsonProperty("contrato")
	@OneToOne
	@JoinColumn(name = "ID_CONTRATO", referencedColumnName = "CODIGO", nullable = false)
	private ContratoEntity contratoEntity;
	
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

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
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

	public Double getValorSaldoInicial() {
		return valorSaldoInicial;
	}

	public void setValorSaldoInicial(Double valorSaldoInicial) {
		this.valorSaldoInicial = valorSaldoInicial;
	}

	public TipoContaBancariaEntity getTipoContaBancariaEntity() {
		return tipoContaBancariaEntity;
	}

	public void setTipoContaBancariaEntity(TipoContaBancariaEntity tipoContaBancariaEntity) {
		this.tipoContaBancariaEntity = tipoContaBancariaEntity;
	}

	public ContratoEntity getContratoEntity() {
		return contratoEntity;
	}

	public void setContratoEntity(ContratoEntity contratoEntity) {
		this.contratoEntity = contratoEntity;
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
