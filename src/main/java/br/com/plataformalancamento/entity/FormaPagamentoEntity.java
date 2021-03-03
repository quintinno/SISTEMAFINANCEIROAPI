package br.com.plataformalancamento.entity;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_FORMA_PAGAMENTO")
public class FormaPagamentoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_TIPO_FORMA_PAGAMENTO", sequenceName = "SEQ_TIPO_FORMA_PAGAMENTO", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;

	@Length(min = 5, max = 60, message = "O campo DESCRICAO deve conter entre {min} e {max} de caracteres!")
	@NotEmpty(message = "O campo DESCRICAO  não pode ser vazio!")
	@NotNull(message = "O campo DESCRICAO não pode ser nulo!")
	@Column(name = "DESCRICAO", length = 60, unique = true, nullable = false)
	private String descricao;

	@Length(min = 2, max = 6, message = "O campo SIGLA deve conter entre {min} e {max} de caracteres!")
	@NotEmpty(message = "O campo SIGLA não pode ser vazio!")
	@NotNull(message = "O campo SIGLA não pode ser nulo!")
	@Column(name = "SIGLA", length = 6, unique = true, nullable = false)
	private String sigla;
	
	public FormaPagamentoEntity() { }

	public FormaPagamentoEntity(String descricao, String sigla) {
		super();
		this.descricao = descricao;
		this.sigla = sigla;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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
		FormaPagamentoEntity other = (FormaPagamentoEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
