package br.com.plataformalancamento.service;

import br.com.plataformalancamento.entity.ParcelamentoEntity;
import br.com.plataformalancamento.entity.ReceitaEntity;
import br.com.plataformalancamento.exception.ObjectNotFoundException;
import br.com.plataformalancamento.exception.ConfiguradorErrorException;
import br.com.plataformalancamento.repository.ParcelamentoImplementacaoRepository;
import br.com.plataformalancamento.repository.ParcelamentoRepository;
import br.com.plataformalancamento.utility.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class ParcelamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ParcelamentoRepository parcelamentoRepository;

	@Autowired
	private ParcelamentoImplementacaoRepository parcelamentoImplementacaoRepository;

	@Autowired
	private ReceitaService receitaService;
	
	@Transactional
	public List<ParcelamentoEntity> recuperar() {
		return this.parcelamentoRepository.findAll();
	}

	@Transactional
	public List<ParcelamentoEntity> recuperarPorCodigoReceita(Long codigo) {
		return this.parcelamentoImplementacaoRepository.recuperarParcelamentoPorCodigoReceita(codigo);
	}
	
	@Transactional
	public ParcelamentoEntity recuperar(Long codigo) {
		Optional<ParcelamentoEntity> parcelamentoOptional = this.parcelamentoRepository.findById(codigo);
		return parcelamentoOptional.orElseThrow( () -> new ObjectNotFoundException( ConfiguradorErrorException.recuperarMensagemErroObjetoNaoEncontradoRequisicao(codigo)));
	}

	@Transactional
	public ParcelamentoEntity registrarPagamentoParcela(ParcelamentoEntity parcelamentoEntity) {
		ReceitaEntity receitaEntity = this.recuperarReceitaParcelamento(parcelamentoEntity);
		parcelamentoEntity.setReceitaEntity(receitaEntity);
		parcelamentoEntity.setDataVencimentoParcela(DateUtility.acrescentarDiasData(1, parcelamentoEntity.getDataVencimentoParcela()));
		parcelamentoEntity.setDataPagamentoParcela(DateUtility.acrescentarDiasData(1, parcelamentoEntity.getDataPagamentoParcela()));
		this.parcelamentoRepository.save(parcelamentoEntity);
		this.receitaService.atualizarValorPago(receitaEntity.getCodigo(), parcelamentoEntity.getValorEfetivoParcela());
		return this.parcelamentoRepository.save(parcelamentoEntity);
	}
	 
	private ReceitaEntity recuperarReceitaParcelamento(ParcelamentoEntity parcelamentoEntity) {
		return this.recuperar(parcelamentoEntity.getCodigo()).getReceitaEntity();
	}
	
	public void remover(Long codigo) {
		try {
			this.parcelamentoRepository.deleteById(codigo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			new Throwable(e.getMessage());
		}
	}
	
}
