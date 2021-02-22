package br.com.plataformalancamento;

import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.plataformalancamento.controller.PaisController;
import br.com.plataformalancamento.entity.CidadeEntity;
import br.com.plataformalancamento.entity.ContratoEntity;
import br.com.plataformalancamento.entity.EmailEntity;
import br.com.plataformalancamento.entity.EnderecoEntity;
import br.com.plataformalancamento.entity.EstadoEntity;
import br.com.plataformalancamento.entity.PaisEntity;
import br.com.plataformalancamento.entity.PessoaEntity;
import br.com.plataformalancamento.entity.TipoContratoEntity;
import br.com.plataformalancamento.entity.TipoEnderecoEntity;
import br.com.plataformalancamento.entity.TipoPessoaEntity;
import br.com.plataformalancamento.repository.CidadeRepository;
import br.com.plataformalancamento.repository.ContratoRepository;
import br.com.plataformalancamento.repository.EmailRepository;
import br.com.plataformalancamento.repository.EnderecoRepository;
import br.com.plataformalancamento.repository.EstadoRepository;
import br.com.plataformalancamento.repository.PessoaRepository;
import br.com.plataformalancamento.repository.TipoContratoRepository;
import br.com.plataformalancamento.repository.TipoEnderecoRepository;
import br.com.plataformalancamento.repository.TipoPessoaRepository;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private PaisController paisController;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private TipoEnderecoRepository tipoEnderecoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private TipoPessoaRepository tipoPessoaRepository;
	
	@Autowired
	private TipoContratoRepository tipoContratoRepository;
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	@Test
	public void cadastrarPais() {
		PaisEntity paisEntity = new PaisEntity("PARAGUAY");
			paisController.cadastrar(paisEntity);
	}
	
	@Test
	public void cadastrarEstado() {
		PaisEntity paisEntity = new PaisEntity("ARGENTINA");
		EstadoEntity estadoEntity = new EstadoEntity("Buenos Aires", paisEntity);
			paisController.cadastrar(paisEntity);
			estadoRepository.save(estadoEntity);
	}
	
	@Test
	public void cadastrarCidade() {
		PaisEntity paisEntity = new PaisEntity("ESTADOS UNIDOS DA AMERICA");
		EstadoEntity estadoEntity = new EstadoEntity("NEW YORK", paisEntity);
		CidadeEntity cidadeEntity1 = new CidadeEntity("MANHATTAN", estadoEntity);
		CidadeEntity cidadeEntity2 = new CidadeEntity("BROOKLYN", estadoEntity);
			paisController.cadastrar(paisEntity);
			estadoRepository.save(estadoEntity);
			this.cidadeRepository.save(cidadeEntity1);
			this.cidadeRepository.save(cidadeEntity2);
	}
	
	@Test
	public void cadastrarTipoEndereco() {
		TipoEnderecoEntity tipoEnderecoEntity = new TipoEnderecoEntity("COMERCIAL");
			this.tipoEnderecoRepository.saveAll(Arrays.asList(tipoEnderecoEntity));
	}
	
	@Test
	public void cadastrarEndereco() {
		PaisEntity paisEntity = new PaisEntity("BRASIL");
		EstadoEntity estadoEntity = new EstadoEntity("DISTRITO FEDERAL", paisEntity);
		CidadeEntity cidadeEntity1 = new CidadeEntity("PARANOÁ", estadoEntity);
		CidadeEntity cidadeEntity2 = new CidadeEntity("SANTA MARIA", estadoEntity);
		TipoEnderecoEntity tipoEnderecoEntity = new TipoEnderecoEntity("RESIDENCIAL");
		TipoPessoaEntity tipoPessoaEntity = new TipoPessoaEntity("PESSOA FÍSICA", "PF");
		PessoaEntity pessoaEntity = new PessoaEntity();
			pessoaEntity.setNome("JOSE QUINTINN");
			pessoaEntity.setIsPessoaFinanceira(true);
			pessoaEntity.setIsAtivo(true);
			pessoaEntity.setTipoPessoaEntity(tipoPessoaEntity);
			pessoaEntity.setIsInstituicaoFinanceira(false);
			this.paisController.cadastrar(paisEntity);
			this.estadoRepository.save(estadoEntity);
			this.cidadeRepository.saveAll(Arrays.asList(cidadeEntity1, cidadeEntity2));
			this.tipoEnderecoRepository.save(tipoEnderecoEntity);
			this.tipoPessoaRepository.save(tipoPessoaEntity);
			this.pessoaRepository.save(pessoaEntity);
			EnderecoEntity enderecoEntity1 = new EnderecoEntity();
				enderecoEntity1.setBairro("SANTA MARIA SUL");
				enderecoEntity1.setCep("72.507-401");
				enderecoEntity1.setCidadeEntity(cidadeEntity1);
				enderecoEntity1.setComplemento("QUADRA 207 CONJUNTO \"A\" LOTE 13");
				enderecoEntity1.setIsAtivo(true);
				enderecoEntity1.setLogradouro("QUADRA");
				enderecoEntity1.setNumero("13");
				enderecoEntity1.setPontoReferencia("PERTO DO CENTRO COMUNITÁRIO");
				enderecoEntity1.setTipoEnderecoEntity(tipoEnderecoEntity);
				enderecoEntity1.setPessoaEntity(pessoaEntity);
			EnderecoEntity enderecoEntity2 = new EnderecoEntity();
				enderecoEntity2.setBairro("PARANOÁ PARQUE");
				enderecoEntity2.setCep("71.587.152");
				enderecoEntity2.setCidadeEntity(cidadeEntity2);
				enderecoEntity2.setComplemento("QUADRA 04 CONJUNTO 3 LOTE 01 BLOCO \"A\" APARTAMENTO 303");
				enderecoEntity2.setIsAtivo(true);
				enderecoEntity2.setLogradouro("QUADRA");
				enderecoEntity2.setNumero("01");
				enderecoEntity2.setPontoReferencia("");
				enderecoEntity2.setTipoEnderecoEntity(tipoEnderecoEntity);
				enderecoEntity2.setPessoaEntity(pessoaEntity);
				this.enderecoRepository.saveAll(Arrays.asList(enderecoEntity1, enderecoEntity2));
	}
	
	@Test
	public void cadastrarEmail() {
		TipoPessoaEntity tipoPessoaEntity = new TipoPessoaEntity("PESSOA AUTORIDADE", "PA");
		PessoaEntity pessoaEntity = new PessoaEntity("JOSE", true, true, false, tipoPessoaEntity);
		EmailEntity emailEntity1 = new EmailEntity("josequintino@hotmail.com.br", true, pessoaEntity);
		EmailEntity emailEntity2 = new EmailEntity("chromium@plataformalancamentofinanceiro.com.br", true, pessoaEntity);
		EmailEntity emailEntity3 = new EmailEntity("arsenicum@outlook.com.br", true, pessoaEntity);
		EmailEntity emailEntity4 = new EmailEntity("dysprosium@outlook.com.br", true, pessoaEntity);
		EmailEntity emailEntity5 = new EmailEntity("jamille.jba@pf.gov.br", true, pessoaEntity);
		EmailEntity emailEntity6 = new EmailEntity("josequintinn@gmail.com", true, pessoaEntity);
		EmailEntity emailEntity7 = new EmailEntity("josequintinno@outlook.com.br", true, pessoaEntity);
		EmailEntity emailEntity8 = new EmailEntity("jozheph.junior@gmail.com", true, pessoaEntity);
		EmailEntity emailEntity9 = new EmailEntity("jozheph.khintinus@gmail.com", true, pessoaEntity);
		EmailEntity emailEntity10 = new EmailEntity("jqsilva@indracompany.com", true, pessoaEntity);
		EmailEntity emailEntity11 = new EmailEntity("nihonium@outlook.com.br", true, pessoaEntity);
		EmailEntity emailEntity12 = new EmailEntity("palladhium@outlook.com.br", true, pessoaEntity);
		EmailEntity emailEntity13 = new EmailEntity("quinn@zipmail.com.br", true, pessoaEntity);
		EmailEntity emailEntity14 = new EmailEntity("quintin@zipmail.com.br", true, pessoaEntity);
		EmailEntity emailEntity15 = new EmailEntity("repository.development@gmail.com", true, pessoaEntity);
		EmailEntity emailEntity16 = new EmailEntity("repository.financeiro@gmail.com", true, pessoaEntity);
		EmailEntity emailEntity17 = new EmailEntity("repository.ununtrium@outlook.com.br", true, pessoaEntity);
		EmailEntity emailEntity18 = new EmailEntity("thallium@outlook.com.br", true, pessoaEntity);
		this.tipoPessoaRepository.save(tipoPessoaEntity);
		this.pessoaRepository.save(pessoaEntity);
		this.emailRepository.saveAll(Arrays.asList(emailEntity1, emailEntity2, emailEntity3, emailEntity4, emailEntity5, emailEntity6, emailEntity7, emailEntity8, emailEntity9, emailEntity10, emailEntity11, emailEntity12, emailEntity13, emailEntity14, emailEntity15, emailEntity16, emailEntity17, emailEntity18));
	}
	
	@Test
	public void cadastrarEnderecoPessoa() {	}
	
	@Test
	public void cadastrarContratoPessoa() {
		TipoPessoaEntity tipoPessoaEntityI = new TipoPessoaEntity("Pessoa Jurídica", "PJ");
		TipoPessoaEntity tipoPessoaEntityII = new TipoPessoaEntity("PESSOA_FISICA", "P_F");
		
			this.tipoPessoaRepository.saveAll(Arrays.asList(tipoPessoaEntityI, tipoPessoaEntityII));
		
		PessoaEntity pessoaContratante = new PessoaEntity();
		PessoaEntity pessoaContratado = new PessoaEntity();
		
			pessoaContratante.setIsAtivo(true);
			pessoaContratante.setIsPessoaFinanceira(true);
			pessoaContratante.setNome("Empresa Contratante I");
			pessoaContratante.setTipoPessoaEntity(tipoPessoaEntityI);
			pessoaContratante.setIsInstituicaoFinanceira(true);
	
			pessoaContratado.setIsAtivo(true);
			pessoaContratado.setIsPessoaFinanceira(true);
			pessoaContratado.setNome("Pessoa Contratada I");
			pessoaContratado.setTipoPessoaEntity(tipoPessoaEntityII);
			pessoaContratado.setIsInstituicaoFinanceira(false);
		
			this.pessoaRepository.saveAll(Arrays.asList(pessoaContratante, pessoaContratado));
		
		TipoContratoEntity tipoContratoEntity = new TipoContratoEntity("Contrato de Benefício (Seguro Desemprego)");
		
			this.tipoContratoRepository.save(tipoContratoEntity);
		
		ContratoEntity contratoEntity = new ContratoEntity();
			contratoEntity.setDataInicioVigencia(new Date());
			contratoEntity.setDataFimVigencia(new Date());
			contratoEntity.setIsATivo(true);
			contratoEntity.setPessoaContratado(pessoaContratado);
			contratoEntity.setPessoaContratante(pessoaContratante);
			contratoEntity.setTipoContratoEntity(tipoContratoEntity);
			
			this.contratoRepository.save(contratoEntity);
	}

}
