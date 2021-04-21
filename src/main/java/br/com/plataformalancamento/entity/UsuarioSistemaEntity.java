package br.com.plataformalancamento.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.plataformalancamento.enumeration.TipoPerfilUsuarioSistemaEnumeration;

@Entity
@Table(name = "TB_USUARIO_SISTEMA")
public class UsuarioSistemaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_USUARIO_SISTEMA", sequenceName = "SEQ_USUARIO_SISTEMA", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@JsonIgnore
	@Column(name = "SENHA", nullable = false)
	private String senha;
	
	@Column(name = "IS_ATIVO", length = 45, nullable = false)
	private Boolean isAtivo;
	
	@OneToOne
	@JoinColumn(name = "ID_PESSOA", referencedColumnName = "codigo", nullable = false)
	private PessoaEntity pessoaEntity;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "TB_PERFIL_USUARIO_SISTEMA")
	private Set<Integer> perfilUsuarioSistema = new HashSet<>();

	public UsuarioSistemaEntity() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public PessoaEntity getPessoaEntity() {
		return pessoaEntity;
	}

	public void setPessoaEntity(PessoaEntity pessoaEntity) {
		this.pessoaEntity = pessoaEntity;
	}

	public Set<TipoPerfilUsuarioSistemaEnumeration> getPerfilUsuarioSistema() {
		return this.perfilUsuarioSistema.stream().map( response -> TipoPerfilUsuarioSistemaEnumeration.converterParaEnumeration(response)).collect(Collectors.toSet());
	}
	
	public void adicionarTipoPerfilUsuarioSistema(TipoPerfilUsuarioSistemaEnumeration tipoPerfilUsuarioSistemaEnumeration) {
		this.perfilUsuarioSistema.add(tipoPerfilUsuarioSistemaEnumeration.getCodigo());
	}

	public void setPerfilUsuarioSistema(Set<Integer> perfilUsuarioSistema) {
		this.perfilUsuarioSistema = perfilUsuarioSistema;
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
		UsuarioSistemaEntity other = (UsuarioSistemaEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
