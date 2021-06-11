package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.plataformalancamento.dto.TipoPessoaDTO;
import br.com.plataformalancamento.entity.TipoPessoaEntity;
import br.com.plataformalancamento.exception.ConfiguradorErrorException;
import br.com.plataformalancamento.repository.TipoPessoaRepository;

@Service
public class TipoPessoaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TipoPessoaRepository tipoPessoaRepository;
	
	public TipoPessoaEntity cadastrar(TipoPessoaEntity tipoPessoaEntity) {
		try {
			return this.tipoPessoaRepository.save(tipoPessoaEntity);
		} catch (DataIntegrityViolationException dataIntegrityViolationException) {
			throw new br.com.plataformalancamento.exception.DataIntegrityViolationException(ConfiguradorErrorException.recuperarMensagemErroObjetoNaoPodeSerCadastrado());
		}
	}
	
	public List<TipoPessoaEntity> recuperar() {
		return this.tipoPessoaRepository.findAll();
	}
	
	public TipoPessoaEntity recuperar(Long codigo) {
		Optional<TipoPessoaEntity> tipoPessoaEntityOptional = this.tipoPessoaRepository.findById(codigo);
		return tipoPessoaEntityOptional.get();
	}
	
	public TipoPessoaDTO recuperarInformacaoTipoPessoa() {
		Gson gson = new Gson();
		String json = gson.toJson(new TipoPessoaEntity());
		TipoPessoaDTO tipoPessoaDTO = gson.fromJson(json, TipoPessoaDTO.class);
		return tipoPessoaDTO;
	}
	
}
