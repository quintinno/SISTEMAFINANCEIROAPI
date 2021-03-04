package br.com.plataformalancamento.controller;

import br.com.plataformalancamento.entity.CategoriaDespesaEntity;
import br.com.plataformalancamento.service.CategoriaDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/categoria-despesa")
public class CategoriaDespesaController implements Serializable {

    private static final long serialVersionUID = 5973215022735178652L;

    @Autowired
    private CategoriaDespesaService categoriaDespesaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDespesaEntity>> recuperar() {
        return ResponseEntity.ok().body(this.categoriaDespesaService.recuperar());
    }

}
