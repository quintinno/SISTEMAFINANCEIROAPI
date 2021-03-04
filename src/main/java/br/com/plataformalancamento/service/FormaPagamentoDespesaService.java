package br.com.plataformalancamento.service;

import br.com.plataformalancamento.entity.FormaPagamentoDespesaEntity;
import br.com.plataformalancamento.repository.FormaPagamentoDespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class FormaPagamentoDespesaService implements Serializable {

    private static final long serialVersionUID = -4543690869198261058L;

    @Autowired
    private FormaPagamentoDespesaRepository formaPagamentoDespesaRepository;

    public FormaPagamentoDespesaService() { }

    public List<FormaPagamentoDespesaEntity> recuperar() {
        return this.formaPagamentoDespesaRepository.findAll();
    }

}
