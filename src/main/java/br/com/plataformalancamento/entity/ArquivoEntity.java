package br.com.plataformalancamento.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "TB_ARQUIVO")
public class ArquivoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_ARQUIVO", sequenceName = "SEQ_ARQUIVO", schema = "public", initialValue = 1, allocationSize = 1)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@Column(name = "DATA_CADASTRO", nullable = false)
	private Date dataCadastro;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "TIPO", nullable = false)
	private String tipo;
	
	@Column(name = "TAMANHO", nullable = true)
	private Long tamanho;
	
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "CONTEUDO", nullable = false)
	private byte[] conteudo;
	
	public ArquivoEntity() { }
	
	public ArquivoEntity(Long codigo, Date dataCadastro, String nome, Long tamanho) {
		this.codigo = codigo;
		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.tamanho = tamanho;
	}

	public ArquivoEntity(Date dataCadastro, String nome, String tipo, byte[] conteudo) {
		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.tipo = tipo;
		this.conteudo = conteudo;
	}

	public ArquivoEntity(Date dataCadastro, String nome, String tipo, Long tamanho, byte[] conteudo) {
		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.tipo = tipo;
		this.tamanho = tamanho;
		this.conteudo = conteudo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getTamanho() {
		return tamanho;
	}

	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

//	public DocumentoEntity getDocumentoEntity() {
//		return documentoEntity;
//	}
//
//	public void setDocumentoEntity(DocumentoEntity documentoEntity) {
//		this.documentoEntity = documentoEntity;
//	}

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
		ArquivoEntity other = (ArquivoEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
