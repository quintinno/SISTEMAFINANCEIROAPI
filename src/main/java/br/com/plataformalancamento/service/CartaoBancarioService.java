package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.dto.CartaoBancarioDTO;
import br.com.plataformalancamento.entity.CartaoBancarioEntity;
import br.com.plataformalancamento.repository.CartaoBancarioImplementacaoRepository;
import br.com.plataformalancamento.repository.CartaoBancarioRepository;

@Service
public class CartaoBancarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CartaoBancarioRepository cartaoBancarioRepository;
	
	@Autowired
	private CartaoBancarioImplementacaoRepository cartaoBancarioImplementacaoRepository;
	
	@Transactional
	public CartaoBancarioEntity cadastrar(CartaoBancarioEntity cartaoBancarioEntity) {
		return this.cartaoBancarioRepository.save(cartaoBancarioEntity);
	}
	
	@Transactional
	public List<CartaoBancarioEntity> recuperar() {
		return this.cartaoBancarioRepository.findAll();
	}
	
	@Transactional
	public List<CartaoBancarioDTO> recuperarCartaoCreditoBancarioVinculadoContaBancaria() {
		return this.cartaoBancarioImplementacaoRepository.recuperarCartaoCreditoBancarioVinculadoContaBancaria();
	}
	
	@Transactional
	public List<CartaoBancarioDTO> recuperarCartaoDebitoBancarioVinculadoContaBancaria() {
		return this.cartaoBancarioImplementacaoRepository.recuperarCartaoDebitoBancarioVinculadoContaBancaria();
	}
	
}
