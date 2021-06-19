package br.com.plataformalancamento.controller;

import br.com.plataformalancamento.dto.DespesaFixaDTO;
import br.com.plataformalancamento.entity.DespesaEntity;
import br.com.plataformalancamento.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.text.ParseException;
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
    
    @PostMapping
    public ResponseEntity<DespesaEntity> cadastrar(@RequestBody DespesaEntity despesaEntity) {
    	DespesaEntity despesaEntityCadastro = this.despesaService.cadastrar(despesaEntity);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(despesaEntityCadastro.getCodigo()).toUri();
    	return ResponseEntity.created(uri).body(despesaEntityCadastro);
    }
    
    @GetMapping("/informacao")
    public ResponseEntity<String> recuperarInformacaoDespesa() {
    	return ResponseEntity.ok(this.despesaService.recuperarInformacaoDespesa());
    }
    
    @GetMapping("/fixa-mensal")
    public ResponseEntity<List<DespesaFixaDTO>> recuperarDespesaFixaMensal() throws ParseException {
    	return ResponseEntity.ok(this.despesaService.recuperarDespesaFixaMensal());
    }

    @GetMapping("/totalizador-despesas-pagas")
    public ResponseEntity<Double> recuperarTotalDespesasPagasAnoFinanceiro() {
        return ResponseEntity.ok().body(this.despesaService.recuperarValorTotalDespesasAnoFinanceiro(true));
    }

    @GetMapping("/totalizador-despesas-pendentes")
    public ResponseEntity<Double> recuperarTotalDespesasPendentesAnoFinanceiro() {
        return ResponseEntity.ok().body(this.despesaService.recuperarValorTotalDespesasAnoFinanceiro(false));
    }

}
