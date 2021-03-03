package br.com.plataformalancamento.controller;

import br.com.plataformalancamento.entity.DespesaEntity;
import br.com.plataformalancamento.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("/despesa")
public class DespesaController implements Serializable {

    private static final long serialVersionUID = -1570069939008567931L;

    @Autowired
    private DespesaService despesaService;

    public DespesaController() { }

    @GetMapping
    public ResponseEntity<List<DespesaEntity>> recuperar() {
        return ResponseEntity.ok().body(this.despesaService.recuperar());
    }

}
