package br.com.plataformalancamento.service;

import br.com.plataformalancamento.entity.CategoriaDespesaEntity;
import br.com.plataformalancamento.repository.CategoriaDespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CategoriaDespesaService implements Serializable {

    private static final long serialVersionUID = -1522527540532060960L;

    @Autowired
    private CategoriaDespesaRepository categoriaDespesaRepository;

    public List<CategoriaDespesaEntity> recuperar() {
       return this.categoriaDespesaRepository.findAll();
    }

    public CategoriaDespesaEntity cadastrar(CategoriaDespesaEntity categoriaDespesaEntity) {
        return this.categoriaDespesaRepository.save(categoriaDespesaEntity);
    }

}
