package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.CategoriaDocumentoModel;
import br.com.plataformalancamento.entity.DocumentoEntity;
import br.com.plataformalancamento.entity.PessoaEntity;
import br.com.plataformalancamento.repository.CategoriaDocumentoRepository;
import br.com.plataformalancamento.repository.DocumentoImplementacaoRepository;

@Service
public class CategoriaDocumentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaDocumentoRepository categoriaDocumentoRepository;
	
	@Autowired
	private DocumentoImplementacaoRepository documentoImplementacaoRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	public List<CategoriaDocumentoModel> recuperar() {
		return this.categoriaDocumentoRepository.findAll();
	}
	
	public List<CategoriaDocumentoModel> recuperarCategoriaDocumentosNaoVinculadoPessoa(String nomePessoa) {
		PessoaEntity pessoaEntity = this.pessoaService.recuperar(nomePessoa);
		List<DocumentoEntity> documentoVinculadoList = this.documentoImplementacaoRepository.recuperarCategoriaDocumentosVinculadoPessoa(pessoaEntity.getCodigo());
		List<CategoriaDocumentoModel> categoriaDocumentoModelList = this.recuperar();
		List<CategoriaDocumentoModel> categoriaDocumentoModelResultadoList = this.recuperar();
		for(CategoriaDocumentoModel categoriaDocumentoModel : categoriaDocumentoModelList) {
			for(DocumentoEntity documentoEntity : documentoVinculadoList) {
				if(categoriaDocumentoModel.getCodigo().equals(documentoEntity.getCategoriaDocumentoModel().getCodigo())) {
					categoriaDocumentoModelResultadoList.remove(documentoEntity.getCategoriaDocumentoModel());
				}	
			}
		}
		return categoriaDocumentoModelResultadoList;
	}
	
}
