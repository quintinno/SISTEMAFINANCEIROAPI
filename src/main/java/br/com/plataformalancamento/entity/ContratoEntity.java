package br.com.plataformalancamento.entity;

import br.com.plataformalancamento.enumeration.TipoPeriodoFinanceiroEnumeration;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_CONTRATO")
public class ContratoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_CONTRATO", sequenceName = "SEQ_CONTRATO", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_INICIO_VIGENCIA")
	private Date dataInicioVigencia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_FIM_VIGENCIA")
	private Date dataFimVigencia;
	
	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isATivo;
	
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

	@Column(name = "VIGENCIA_CONTRATO")
	private Integer vigenciaContrato;
	
	public ContratoEntity() { }

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

	public Integer getVigenciaContrato() {
		return vigenciaContrato;
	}

	public void setVigenciaContrato(Integer vigenciaContrato) {
		this.vigenciaContrato = vigenciaContrato;
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

}
