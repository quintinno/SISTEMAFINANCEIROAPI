package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.plataformalancamento.dto.ArquivoDTO;
import br.com.plataformalancamento.entity.ArquivoEntity;
import br.com.plataformalancamento.repository.ArquivoRepository;

@Service
public class ArquivoService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private ArquivoRepository arquivoRepository;

    public ArquivoService() { }

    @Transactional
	public ArquivoDTO cadastrar(MultipartFile multipartFileArquivo) {
    	try {
    		ArquivoEntity arquivoEntity = new ArquivoEntity(new Date(), multipartFileArquivo.getOriginalFilename(), recuperarExtencaoArquivoImportado(multipartFileArquivo.getOriginalFilename()), multipartFileArquivo.getSize(), multipartFileArquivo.getBytes());
    		ArquivoEntity arquivoEntityCadastrado = this.arquivoRepository.save(arquivoEntity);
    		return new ArquivoDTO(arquivoEntityCadastrado.getCodigo(), arquivoEntityCadastrado.getDataCadastro(), arquivoEntityCadastrado.getNome(), arquivoEntityCadastrado.getTipo(), arquivoEntityCadastrado.getTamanho());
    	} catch(Exception exception) {
    		exception.printStackTrace();
    	}
    	return null;
    }
    
    @Transactional
    public ArquivoEntity recuperar(Long codigo) {
    	return arquivoRepository.findById(codigo).get();
    }
    
	@Transactional
    public List<ArquivoDTO> recuperarInformacaoArquivo() {
    	List<ArquivoEntity> arquivoEntityList = this.arquivoRepository.recuperarInformacaoArquivo();
    	List<ArquivoDTO> arquivoDTOList = new ArrayList<ArquivoDTO>();
    	for( ArquivoEntity arquivoEntityResultado : arquivoEntityList ) {
    			ArquivoDTO arquivoDTO = new ArquivoDTO(arquivoEntityResultado.getCodigo(), arquivoEntityResultado.getDataCadastro(), arquivoEntityResultado.getNome(), arquivoEntityResultado.getTamanho());
    				arquivoDTOList.add(arquivoDTO);
    	}
        return arquivoDTOList;
    }
    
    private String recuperarExtencaoArquivoImportado(String nomeArquivoImportado) {
    	if( nomeArquivoImportado.contains(".") ) {
    		nomeArquivoImportado = nomeArquivoImportado.substring(nomeArquivoImportado.lastIndexOf(".") + 1);
		}
    	return nomeArquivoImportado;
    }
    
}
