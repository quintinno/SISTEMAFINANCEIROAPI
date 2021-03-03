package br.com.plataformalancamento.controller;

import br.com.plataformalancamento.entity.FormaPagamentoDespesaEntity;
import br.com.plataformalancamento.entity.ProdutoServicoEntity;
import br.com.plataformalancamento.service.FormaPagamentoDespesaService;
import br.com.plataformalancamento.service.ProdutoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("/produto-servico")
public class ProdutoServicoController implements Serializable {

    private static final long serialVersionUID = -1570069939008567931L;

    @Autowired
    private ProdutoServicoService produtoServicoService;

    public ProdutoServicoController() { }

    @GetMapping
    public ResponseEntity<List<ProdutoServicoEntity>> recuperar() {
        return ResponseEntity.ok().body(this.produtoServicoService.recuperar());
    }

}
