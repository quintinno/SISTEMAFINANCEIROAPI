package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.DocumentoEntity;
import br.com.plataformalancamento.entity.PessoaEntity;
import br.com.plataformalancamento.repository.DocumentoRepository;

@Service
public class DocumentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Transactional
	public DocumentoEntity cadastrar(DocumentoEntity documentoEntity) {
		documentoEntity.setPessoaEntity(this.recuperarPessoaVinculoDocumento(documentoEntity.getPessoaEntity().getNome()));
		return this.documentoRepository.save(documentoEntity);
	}
	
	@Transactional
	public List<DocumentoEntity> recuperar() {
		return this.documentoRepository.findAll();
	}
	
	private PessoaEntity recuperarPessoaVinculoDocumento(String nomePessoa) {
		return this.pessoaService.recuperar(nomePessoa);
	}
	
}
