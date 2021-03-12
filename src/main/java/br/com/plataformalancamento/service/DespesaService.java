package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.DespesaEntity;
import br.com.plataformalancamento.enumeration.TipoCanalPagamentoEnumeration;
import br.com.plataformalancamento.repository.DespesaRepository;

@Service
public class DespesaService implements Serializable {

    private static final long serialVersionUID = -4543690869198261058L;

    @Autowired
    private DespesaRepository despesaRepository;

    public DespesaService() { }

    public List<DespesaEntity> recuperar() {
        return this.despesaRepository.findAll();
    }

    @Transactional
	public DespesaEntity cadastrar(DespesaEntity despesaEntity) {
    	despesaEntity.setTipoCanalPagamentoEnumeration(TipoCanalPagamentoEnumeration.TRANSACAO_FISICA);
		return this.despesaRepository.save(despesaEntity);
	}

}
