package br.com.plataformalancamento.service;

import br.com.plataformalancamento.entity.DespesaEntity;
import br.com.plataformalancamento.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class DespesaService implements Serializable {

    private static final long serialVersionUID = -4543690869198261058L;

    @Autowired
    private DespesaRepository despesaRepository;

    public DespesaService() { }

    public List<DespesaEntity> recuperar() {
        return this.despesaRepository.findAll();
    }

}
