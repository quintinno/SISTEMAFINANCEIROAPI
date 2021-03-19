package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.plataformalancamento.dto.ArquivoDTO;
import br.com.plataformalancamento.entity.ArquivoEntity;
import br.com.plataformalancamento.service.ArquivoService;

@RestController
@RequestMapping("/arquivo")
public class ArquivoController implements Serializable {

    private static final long serialVersionUID = -1570069939008567931L;

    @Autowired
    private ArquivoService arquivoService;

    public ArquivoController() { }
    
    @PostMapping
    public ResponseEntity<ArquivoDTO> cadastrar(@RequestParam("arquivo") MultipartFile[] multipartFileArquivo) {
    	ArquivoDTO arquivoDTO = new ArquivoDTO();
    	for( MultipartFile multipartFileArquivoSelecionado : multipartFileArquivo ) {
    			arquivoDTO = this.arquivoService.cadastrar(multipartFileArquivoSelecionado);
    	}
    	return ResponseEntity.ok().body(arquivoDTO);
    }

    @GetMapping
    public ResponseEntity<List<ArquivoDTO>> recuperar() {
        return ResponseEntity.ok().body(this.arquivoService.recuperarInformacaoArquivo());
    }
    
    @GetMapping("/{codigo}")
    public ResponseEntity<ByteArrayResource> recuperar(@PathVariable Long codigo) {
    	ArquivoEntity arquivoEntity = this.arquivoService.recuperar(codigo);
    	return ResponseEntity
    			.ok()
    			.contentType(MediaType.APPLICATION_OCTET_STREAM)
    			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + arquivoEntity.getNome())
    			.body(new ByteArrayResource(arquivoEntity.getConteudo()));
    }
    
    @GetMapping("/recuperar")
    public void recuperar( @Param("codigo") Long codigo, HttpServletResponse httpServletResponse) throws Exception {
    	ArquivoEntity arquivoEntity = this.arquivoService.recuperar(codigo);
    	if(arquivoEntity == null) {
    		throw new Exception("Não foi possível recuperar o arquivo com o código (" + codigo + ") informado!");
    	}
    	httpServletResponse.setContentType("application/octet-stream");
    	String headerNome = "Content-Disposition";
    	String headerValor = "attachment; filename=" + arquivoEntity.getNome();
    	httpServletResponse.setHeader(headerNome, headerValor);
    	ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
    		servletOutputStream.write(arquivoEntity.getConteudo());
    		servletOutputStream.close();
    }
    
}
