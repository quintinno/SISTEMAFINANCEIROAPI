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

@Entity
@Table(name = "TB_ENDERECO")
public class EnderecoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_ENDERECO",sequenceName = "SEQ_ENDERECO", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "LOGRADOURO", length = 85, nullable = false)
	private String logradouro;
	
	@Column(name = "COMPLEMENTO", length = 85, nullable = true)
	private String complemento;
	
	@Column(name = "NUMERO", length = 10, nullable = false)
	private String numero;
	
	@Column(name = "BAIRRO", length = 45, nullable = false)
	private String bairro;
	
	@Column(name = "CEP", length = 10, nullable = true)
	private String cep;
	
	@Column(name = "PONTO_REFERENCIA", length = 80, nullable = true)
	private String pontoReferencia;
	
	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isAtivo;
	
	@OneToOne
	@JoinColumn(name = "ID_TIPO_ENDERECO", referencedColumnName = "codigo", nullable = false)
	private TipoEnderecoEntity tipoEnderecoEntity;
	
	@OneToOne
	@JoinColumn(name = "ID_CIDADE", referencedColumnName = "codigo", nullable = false)
	private CidadeEntity cidadeEntity;
	
	@ManyToOne
	@JoinColumn(name = "ID_PESSOA", referencedColumnName = "codigo", nullable = false)
	private PessoaEntity pessoaEntity;
	
	public EnderecoEntity() { }

	public EnderecoEntity(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public TipoEnderecoEntity getTipoEnderecoEntity() {
		return tipoEnderecoEntity;
	}

	public void setTipoEnderecoEntity(TipoEnderecoEntity tipoEnderecoEntity) {
		this.tipoEnderecoEntity = tipoEnderecoEntity;
	}

	public CidadeEntity getCidadeEntity() {
		return cidadeEntity;
	}

	public void setCidadeEntity(CidadeEntity cidadeEntity) {
		this.cidadeEntity = cidadeEntity;
	}

	public PessoaEntity getPessoaEntity() {
		return pessoaEntity;
	}

	public void setPessoaEntity(PessoaEntity pessoaEntity) {
		this.pessoaEntity = pessoaEntity;
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
		EnderecoEntity other = (EnderecoEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
