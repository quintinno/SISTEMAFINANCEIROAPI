package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.ProdutoServicoEntity;
import br.com.plataformalancamento.repository.ProdutoServicoImplementacaoRepository;
import br.com.plataformalancamento.repository.ProdutoServicoRepository;

@Service
public class ProdutoServicoService implements Serializable {

    private static final long serialVersionUID = -4543690869198261058L;
    
    @Autowired
    private ProdutoServicoRepository produtoServicoRepository;

    @Autowired
    private ProdutoServicoImplementacaoRepository produtoServicoImplementacaoRepository;

    public ProdutoServicoService() { }

    public List<ProdutoServicoEntity> recuperar() {
        return this.produtoServicoRepository.findAll();
    }
    
    public ProdutoServicoEntity findOne(String descricao) {
    	return this.produtoServicoRepository.findByDescricaoContains(descricao);
    }
    
    public Boolean isProdutoServicoDescricaoCadastrado(String descricao) {
    	return this.produtoServicoImplementacaoRepository.isProdutoServicoDescricaoCadastrado(descricao);
    }
    
    public ProdutoServicoEntity cadastrar(ProdutoServicoEntity produtoServicoEntity) {
    	return this.produtoServicoRepository.save(produtoServicoEntity);
    }

}
