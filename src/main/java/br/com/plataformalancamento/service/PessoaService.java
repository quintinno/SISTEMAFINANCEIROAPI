package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.EmailEntity;
import br.com.plataformalancamento.entity.EnderecoEntity;
import br.com.plataformalancamento.entity.PessoaEntity;
import br.com.plataformalancamento.entity.TipoPessoaEntity;
import br.com.plataformalancamento.repository.EmailRepository;
import br.com.plataformalancamento.repository.EnderecoRepository;
import br.com.plataformalancamento.repository.PessoaRepository;
import br.com.plataformalancamento.repository.TipoPessoaRepository;

@Service
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private TipoPessoaRepository tipoPessoaRepository;
	
	public List<PessoaEntity> recuperar() {
		return this.pessoaRepository.findAll();
	}
	
	public PessoaEntity cadastrar(PessoaEntity PessoaEntity) {
		return this.pessoaRepository.save(PessoaEntity);
	}
	
	public PessoaEntity recuperar(Long codigo) {
		Optional<PessoaEntity> pessoaOptional = this.pessoaRepository.findById(codigo);
		return pessoaOptional.get();
	}
	
	public PessoaEntity recuperar(String nome) {
		return this.pessoaRepository.findByNomeContains(nome);
	}
	
	public PessoaEntity atualizar(Long codigo, PessoaEntity PessoaEntity) {
		PessoaEntity PessoaEntityResult = this.recuperar(codigo);
		BeanUtils.copyProperties(PessoaEntity, PessoaEntityResult, "codigo");
		return this.pessoaRepository.save(PessoaEntityResult);
	}
	
	public void remover(Long codigo) {
		verificarVinculoPessoa(codigo);
		this.pessoaRepository.deleteById(codigo);
	}
	
	@Transactional
	public List<PessoaEntity> recuperarPessoaJuridica() {
		TipoPessoaEntity tipoPessoaEntity = this.tipoPessoaRepository.findBySigla("PJ");
		return this.pessoaRepository.findByTipoPessoaEntity(tipoPessoaEntity);
	}
	
	@Transactional
	public List<PessoaEntity> recuperarPessoaFisica() {
		TipoPessoaEntity tipoPessoaEntity = this.tipoPessoaRepository.findBySigla("PF");
		return this.pessoaRepository.findByTipoPessoaEntity(tipoPessoaEntity);
	}

	private void verificarVinculoPessoa(Long codigo) {
		List<EmailEntity> emailEntitieList = this.recuperarEmailVinculoPessoa(this.recuperar(codigo));
		List<EnderecoEntity> enderecoEntitieList = this.recuperarEnderecoVinculoPessoa(this.recuperar(codigo));
		if(emailEntitieList.size() > 0) {
			this.emailRepository.deleteAll(emailEntitieList);
		}
		if(enderecoEntitieList.size() > 0) {
			this.enderecoRepository.deleteAll(enderecoEntitieList);
		}
	}
	
	private List<EmailEntity> recuperarEmailVinculoPessoa(PessoaEntity pessoaEntity) {
		return this.emailRepository.findByPessoaEntity(pessoaEntity);
	}
	
	private List<EnderecoEntity> recuperarEnderecoVinculoPessoa(PessoaEntity pessoaEntity) {
		return this.enderecoRepository.findByPessoaEntity(pessoaEntity);
	}
	
}
