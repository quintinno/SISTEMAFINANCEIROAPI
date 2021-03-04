package br.com.plataformalancamento.service;

import br.com.plataformalancamento.entity.ProdutoServicoEntity;
import br.com.plataformalancamento.repository.ProdutoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ProdutoServicoService implements Serializable {

    private static final long serialVersionUID = -4543690869198261058L;

    @Autowired
    private ProdutoServicoRepository produtoServicoRepository;

    public ProdutoServicoService() { }

    public List<ProdutoServicoEntity> recuperar() {
        return this.produtoServicoRepository.findAll();
    }

}
