package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.ProdutoServicoEntity;
import br.com.plataformalancamento.service.ProdutoServicoService;


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
    
    @PostMapping
	public ResponseEntity<ProdutoServicoEntity> cadastrar(@RequestBody ProdutoServicoEntity produtoServicoEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.produtoServicoService.cadastrar(produtoServicoEntity));
	}

}
