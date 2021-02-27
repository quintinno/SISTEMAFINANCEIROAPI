package br.com.plataformalancamento.service;

import br.com.plataformalancamento.controller.PaisController;
import br.com.plataformalancamento.entity.CidadeEntity;
import br.com.plataformalancamento.entity.EstadoEntity;
import br.com.plataformalancamento.entity.PaisEntity;
import br.com.plataformalancamento.repository.CidadeRepository;
import br.com.plataformalancamento.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DatabaseService {

    @Autowired
    private PaisController paisController;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public void instanciarBaseDados() {
        PaisEntity paisEntity = new PaisEntity("ESTADOS UNIDOS DA AMERICA");
        EstadoEntity estadoEntity = new EstadoEntity("NEW YORK", paisEntity);
        CidadeEntity cidadeEntity1 = new CidadeEntity("MANHATTAN", estadoEntity);
        CidadeEntity cidadeEntity2 = new CidadeEntity("BROOKLYN", estadoEntity);
        paisController.cadastrar(paisEntity);
        estadoRepository.save(estadoEntity);
        this.cidadeRepository.saveAll(Arrays.asList(cidadeEntity1, cidadeEntity2));
    }

}
