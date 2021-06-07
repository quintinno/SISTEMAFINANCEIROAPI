package br.com.plataformalancamento.controller;

import br.com.plataformalancamento.entity.FormaPagamentoDespesaEntity;
import br.com.plataformalancamento.service.FormaPagamentoDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/forma-pagamento-despesa")
public class FormaPagamentoDespesaController implements Serializable {

    private static final long serialVersionUID = -1570069939008567931L;

    @Autowired
    private FormaPagamentoDespesaService formaPagamentoDespesaService;

    public FormaPagamentoDespesaController() { }

    @GetMapping
    public ResponseEntity<List<FormaPagamentoDespesaEntity>> recuperar() {
        return ResponseEntity.ok().body(this.formaPagamentoDespesaService.recuperar());
    }

}
