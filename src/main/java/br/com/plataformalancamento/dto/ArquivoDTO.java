package br.com.plataformalancamento.dto;

import java.util.Date;

public class ArquivoDTO {
	
	private Long codigo;
	private Date dataCadastro;
	private String nome;
	private String tipo;
	private Long tamanho;
	
	public ArquivoDTO() { }
	
	public ArquivoDTO(Long codigo, Date dataCadastro, String nome, Long tamanho) {
		this.codigo = codigo;
		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.tamanho = tamanho;
	}
	
	public ArquivoDTO(Long codigo, Date dataCadastro, String nome, String tipo, Long tamanho) {
		this.codigo = codigo;
		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.tipo = tipo;
		this.tamanho = tamanho;
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
	
}
