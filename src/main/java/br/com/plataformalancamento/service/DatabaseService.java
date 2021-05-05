package br.com.plataformalancamento.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.BandeiraCartaoBancarioEntity;
import br.com.plataformalancamento.entity.CartaoBancarioEntity;
import br.com.plataformalancamento.entity.CategoriaCartaoBancarioEntity;
import br.com.plataformalancamento.entity.CategoriaDespesaEntity;
import br.com.plataformalancamento.entity.CategoriaReceitaEntity;
import br.com.plataformalancamento.entity.ContaBancariaEntity;
import br.com.plataformalancamento.entity.ContratoEntity;
import br.com.plataformalancamento.entity.DespesaEntity;
import br.com.plataformalancamento.entity.FormaPagamentoDespesaEntity;
import br.com.plataformalancamento.entity.FormaPagamentoEntity;
import br.com.plataformalancamento.entity.FuncaoCartaoBancarioEntity;
import br.com.plataformalancamento.entity.PessoaEntity;
import br.com.plataformalancamento.entity.ProdutoServicoEntity;
import br.com.plataformalancamento.entity.ProdutoServicoOcorrenciaEntity;
import br.com.plataformalancamento.entity.TipoContaBancariaEntity;
import br.com.plataformalancamento.entity.TipoContratoEntity;
import br.com.plataformalancamento.entity.TipoPessoaEntity;
import br.com.plataformalancamento.entity.TipoUsuarioSistemaEntity;
import br.com.plataformalancamento.entity.UsuarioSistemaEntity;
import br.com.plataformalancamento.enumeration.TipoCanalPagamentoEnumeration;
import br.com.plataformalancamento.enumeration.TipoPeriodoFinanceiroEnumeration;
import br.com.plataformalancamento.repository.BandeiraCartaoBancarioRepository;
import br.com.plataformalancamento.repository.CartaoBancarioRepository;
import br.com.plataformalancamento.repository.CategoriaCartaoBancarioRepository;
import br.com.plataformalancamento.repository.CategoriaDespesaRepository;
import br.com.plataformalancamento.repository.CategoriaReceitaRepository;
import br.com.plataformalancamento.repository.ContaBancariaRepository;
import br.com.plataformalancamento.repository.ContratoRepository;
import br.com.plataformalancamento.repository.DespesaRepository;
import br.com.plataformalancamento.repository.FormaPagamentoRepository;
import br.com.plataformalancamento.repository.FuncaoCartaoBancarioRepository;
import br.com.plataformalancamento.repository.PessoaRepository;
import br.com.plataformalancamento.repository.ProdutoServicoOcorrenciaRepository;
import br.com.plataformalancamento.repository.TipoContaBancariaRepository;
import br.com.plataformalancamento.repository.TipoContratoRepository;
import br.com.plataformalancamento.repository.TipoPessoaRepository;
import br.com.plataformalancamento.repository.TipoUsuarioSistemaRepository;
import br.com.plataformalancamento.repository.UsuarioSistemaRepository;
import br.com.plataformalancamento.utility.DateUtility;

@Service
public class DatabaseService {

    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Autowired
    private TipoPessoaRepository tipoPessoaRepository;
    
    @Autowired
    private CategoriaReceitaRepository categoriaReceitaRepository;
    
    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;
    
    @Autowired
    private TipoContratoRepository tipoContratoRepository;
    
    @Autowired
    private TipoContaBancariaRepository tipoContaBancariaRepository;
    
    @Autowired
    private ContratoRepository contratoRepository;
    
    @Autowired
    private ContaBancariaRepository contaBancariaRepository;
    
//    @Autowired
//    private ReceitaRepository receitaRepository;
    
    @Autowired
    private CategoriaDespesaRepository categoriaDespesaRepository;
    
    @Autowired
    private DespesaRepository despesaRepository;
    
    @Autowired
    private ProdutoServicoOcorrenciaRepository produtoServicoOcorrenciaRepository;
    
//    @Autowired
//    private ArquivoRepository arquivoRepository;
    
    @Autowired
    private CategoriaCartaoBancarioRepository categoriaCartaoBancarioRepository;
    
    @Autowired
    private BandeiraCartaoBancarioRepository bandeiraCartaoBancarioRepository;
    
    @Autowired
    private CartaoBancarioRepository cartaoBancarioRepository;
    
    @Autowired
    private FuncaoCartaoBancarioRepository funcaoCartaoBancarioRepository;
    
    @Autowired
    private UsuarioSistemaRepository usuarioSistemaRepository;
    
    @Autowired
    private TipoUsuarioSistemaRepository tipoUsuarioSistemaRepository;
    
    @Autowired
    private ParcelamentoService parcelamentoService;

    public void instanciarBaseDados() {
    	
    	TipoPessoaEntity tipoPessoaEntity1 = new TipoPessoaEntity("Pessoa Física", "PF");
    	TipoPessoaEntity tipoPessoaEntity2 = new TipoPessoaEntity("Pessoa Jurídica", "PJ");
    	this.tipoPessoaRepository.saveAll(Arrays.asList(tipoPessoaEntity1, tipoPessoaEntity2));
    	
    	PessoaEntity pessoaEntity1 = new PessoaEntity();
    		pessoaEntity1.setNome("José Quintinn");
    		pessoaEntity1.setTipoPessoaEntity(tipoPessoaEntity1);
    		pessoaEntity1.setIsInstituicaoFinanceira(false);
    		pessoaEntity1.setIsAtivo(true);
    		
    	PessoaEntity pessoaEntity2 = new PessoaEntity();
    		pessoaEntity2.setNome("Brava Fibra Internet");
    		pessoaEntity2.setTipoPessoaEntity(tipoPessoaEntity2);
    		pessoaEntity2.setIsInstituicaoFinanceira(true);
    		pessoaEntity2.setIsAtivo(true);
    		
    	PessoaEntity pessoaEntity3 = new PessoaEntity();
    		pessoaEntity3.setNome("Banco Caixa Econômica Federal");
    		pessoaEntity3.setTipoPessoaEntity(tipoPessoaEntity2);
    		pessoaEntity3.setIsInstituicaoFinanceira(true);
    		pessoaEntity3.setIsAtivo(true);
    		
    	PessoaEntity pessoaEntity4 = new PessoaEntity();
    		pessoaEntity4.setNome("Banco Santander");
    		pessoaEntity4.setTipoPessoaEntity(tipoPessoaEntity2);
    		pessoaEntity4.setIsInstituicaoFinanceira(true);
    		pessoaEntity4.setIsAtivo(true);
    		
    	PessoaEntity pessoaEntity5 = new PessoaEntity();
	    	pessoaEntity5.setNome("Bomba Burguer Pizzas e Refeições");
	    	pessoaEntity5.setTipoPessoaEntity(tipoPessoaEntity2);
	    	pessoaEntity5.setIsInstituicaoFinanceira(false);
	    	pessoaEntity5.setIsAtivo(true);
	    	
	    PessoaEntity pessoaEntity6 = new PessoaEntity();
    		pessoaEntity6.setNome("Jamille Alves");
    		pessoaEntity6.setTipoPessoaEntity(tipoPessoaEntity1);
    		pessoaEntity6.setIsInstituicaoFinanceira(false);
    		pessoaEntity6.setIsAtivo(true);

		PessoaEntity pessoaEntity7 = new PessoaEntity();
			pessoaEntity7.setNome("Indra Company Brasil");
			pessoaEntity7.setTipoPessoaEntity(tipoPessoaEntity2);
			pessoaEntity7.setIsInstituicaoFinanceira(false);
			pessoaEntity7.setIsAtivo(false);

        PessoaEntity pessoaEntity8 = new PessoaEntity();
            pessoaEntity8.setNome("Sinagoga Keter Torah");
            pessoaEntity8.setTipoPessoaEntity(tipoPessoaEntity2);
            pessoaEntity8.setIsInstituicaoFinanceira(false);
            pessoaEntity8.setIsAtivo(true);
            
        PessoaEntity pessoaEntity9 = new PessoaEntity();
    		pessoaEntity9.setNome("Banco Nubank");
    		pessoaEntity9.setTipoPessoaEntity(tipoPessoaEntity2);
    		pessoaEntity9.setIsInstituicaoFinanceira(true);
    		pessoaEntity9.setIsAtivo(true);
    		
    	PessoaEntity pessoaEntity10 = new PessoaEntity();
			pessoaEntity10.setNome("Mirante Tecnologia");
			pessoaEntity10.setTipoPessoaEntity(tipoPessoaEntity2);
			pessoaEntity10.setIsInstituicaoFinanceira(false);
			pessoaEntity10.setIsAtivo(true);
			
		PessoaEntity pessoaEntity11 = new PessoaEntity();
			pessoaEntity11.setNome("Banco do Brasil");
			pessoaEntity11.setTipoPessoaEntity(tipoPessoaEntity2);
			pessoaEntity11.setIsInstituicaoFinanceira(true);
			pessoaEntity11.setIsAtivo(true);
			
		PessoaEntity pessoaEntity12 = new PessoaEntity();
			pessoaEntity12.setNome("Alelo");
			pessoaEntity12.setTipoPessoaEntity(tipoPessoaEntity2);
			pessoaEntity12.setIsInstituicaoFinanceira(false);
			pessoaEntity12.setIsAtivo(true);
    		
    		this.pessoaRepository.saveAll(Arrays.asList(pessoaEntity1, pessoaEntity2, pessoaEntity3, pessoaEntity4, pessoaEntity5, pessoaEntity6, pessoaEntity7, pessoaEntity8, pessoaEntity9, pessoaEntity10, pessoaEntity11, pessoaEntity12));
    		
    	CategoriaReceitaEntity categoriaReceitaEntity1 = new CategoriaReceitaEntity("Devolução de Empréstimo (Concessão)");
    	CategoriaReceitaEntity categoriaReceitaEntity2 = new CategoriaReceitaEntity("Solicitação de Empréstimo (Obtenção)");
    	CategoriaReceitaEntity categoriaReceitaEntity3 = new CategoriaReceitaEntity("Pagamento de Salário Mensalista");
    	CategoriaReceitaEntity categoriaReceitaEntity4 = new CategoriaReceitaEntity("Benefício (Seguro Desemprego)");
		CategoriaReceitaEntity categoriaReceitaEntity5 = new CategoriaReceitaEntity("Prestação de Serviços de Internet");

    		this.categoriaReceitaRepository.saveAll(Arrays.asList(categoriaReceitaEntity1, categoriaReceitaEntity2, categoriaReceitaEntity3, categoriaReceitaEntity4, categoriaReceitaEntity5));
    		
    	FormaPagamentoEntity formaPagamentoEntity1 = new FormaPagamentoEntity("Dinheiro", "DN", true);
    	FormaPagamentoEntity formaPagamentoEntity2 = new FormaPagamentoEntity("Tranferência Bancária", "TB", false);
    	FormaPagamentoEntity formaPagamentoEntity3 = new FormaPagamentoEntity("Tranferência Bancária (PIX)", "TBPIX", false);
    	FormaPagamentoEntity formaPagamentoEntity4 = new FormaPagamentoEntity("Depósito Bancário", "DB", false);
    	FormaPagamentoEntity formaPagamentoEntity5 = new FormaPagamentoEntity("Boleto Bancário", "BB", false);
    	FormaPagamentoEntity formaPagamentoEntity6 = new FormaPagamentoEntity("Cartão de Crédito", "CC", true);
    	FormaPagamentoEntity formaPagamentoEntity7 = new FormaPagamentoEntity("Cheque", "CH", false);
    	FormaPagamentoEntity formaPagamentoEntity8 = new FormaPagamentoEntity("Cartão de Débito", "CD", true);
    	FormaPagamentoEntity formaPagamentoEntity9 = new FormaPagamentoEntity("Crédito Loja", "CL", false);
    	FormaPagamentoEntity formaPagamentoEntity10 = new FormaPagamentoEntity("Vale Alimentação", "VA", true);
    	FormaPagamentoEntity formaPagamentoEntity11 = new FormaPagamentoEntity("Vale Refeição", "VR", false);
    	FormaPagamentoEntity formaPagamentoEntity12 = new FormaPagamentoEntity("Vale Presente", "VP", false);
    	FormaPagamentoEntity formaPagamentoEntity13 = new FormaPagamentoEntity("Vale Combustível", "VC", false);
    		
    		this.formaPagamentoRepository.saveAll(Arrays.asList(formaPagamentoEntity1, formaPagamentoEntity2, formaPagamentoEntity3, formaPagamentoEntity4, formaPagamentoEntity5, formaPagamentoEntity6, formaPagamentoEntity7, formaPagamentoEntity8, formaPagamentoEntity9, formaPagamentoEntity10, formaPagamentoEntity11, formaPagamentoEntity12, formaPagamentoEntity13));
    	
    	TipoContaBancariaEntity tipoContaBancariaEntity1 = new TipoContaBancariaEntity("Conta Corrente");
    	TipoContaBancariaEntity tipoContaBancariaEntity2 = new TipoContaBancariaEntity("Conta Corrente (Conta Digital)");
    	TipoContaBancariaEntity tipoContaBancariaEntity3 = new TipoContaBancariaEntity("Conta Corrente (Conta Salario)");
    	TipoContaBancariaEntity tipoContaBancariaEntity4 = new TipoContaBancariaEntity("Poupança");
    	TipoContaBancariaEntity tipoContaBancariaEntity5 = new TipoContaBancariaEntity("Conta Investimento");
		TipoContaBancariaEntity tipoContaBancariaEntity6 = new TipoContaBancariaEntity("Conta Carteira (Conta Especial)");
		TipoContaBancariaEntity tipoContaBancariaEntity7 = new TipoContaBancariaEntity("Conta Benefício Alimentação (Conta Especial)");
    	
    		this.tipoContaBancariaRepository.saveAll(Arrays.asList(tipoContaBancariaEntity1, tipoContaBancariaEntity2, tipoContaBancariaEntity3, tipoContaBancariaEntity4, tipoContaBancariaEntity5, tipoContaBancariaEntity6, tipoContaBancariaEntity7));
    	
    	TipoContratoEntity tipoContratoEntity1 = new TipoContratoEntity("Contrato de Conta Bancária");
    	TipoContratoEntity tipoContratoEntity2 = new TipoContratoEntity("Contrato de Trabalho CLT");
    	TipoContratoEntity tipoContratoEntity3 = new TipoContratoEntity("Contrato de Trabalho CNPJ");
    	TipoContratoEntity tipoContratoEntity4 = new TipoContratoEntity("Contrato de Internet");
    	TipoContratoEntity tipoContratoEntity5 = new TipoContratoEntity("Contrato de Benefício (Seguro Desemprego)");
    	TipoContratoEntity tipoContratoEntity6 = new TipoContratoEntity("Contrato de Benefício (Auxílio Doença)");
    	TipoContratoEntity tipoContratoEntity7 = new TipoContratoEntity("Contrato de Benefício (INSS Saúde)");
		TipoContratoEntity tipoContratoEntity8 = new TipoContratoEntity("Conta Carteira (Conta Especial)");
		TipoContratoEntity tipoContratoEntity9 = new TipoContratoEntity("Organização Religiosa");
		TipoContratoEntity tipoContratoEntity10 = new TipoContratoEntity("Contrato de Conta Especial");
    	
    		this.tipoContratoRepository.saveAll(Arrays.asList(tipoContratoEntity1, tipoContratoEntity2, tipoContratoEntity3, tipoContratoEntity4, tipoContratoEntity5, tipoContratoEntity6, tipoContratoEntity7, tipoContratoEntity8, tipoContratoEntity9, tipoContratoEntity10));
    	
    	ContratoEntity contratoEntity1 = new ContratoEntity();
    		contratoEntity1.setDataInicioVigencia(null);
    		contratoEntity1.setDataFimVigencia(null);
    		contratoEntity1.setPessoaContratado(pessoaEntity3);
    		contratoEntity1.setPessoaContratante(pessoaEntity1);
    		contratoEntity1.setTipoContratoEntity(tipoContratoEntity1);
    		contratoEntity1.setIsATivo(true);
    		
    	ContratoEntity contratoEntity2 = new ContratoEntity();
	    	contratoEntity2.setDataInicioVigencia(null);
	    	contratoEntity2.setDataFimVigencia(null);
	    	contratoEntity2.setPessoaContratado(pessoaEntity9);
	    	contratoEntity2.setPessoaContratante(pessoaEntity1);
	    	contratoEntity2.setTipoContratoEntity(tipoContratoEntity1);
	    	contratoEntity2.setIsATivo(true);
	    	
	    ContratoEntity contratoEntity3 = new ContratoEntity();
	    	contratoEntity3.setDataInicioVigencia(null);
	    	contratoEntity3.setDataFimVigencia(null);
	    	contratoEntity3.setPessoaContratado(pessoaEntity1);
	    	contratoEntity3.setPessoaContratante(pessoaEntity1);
	    	contratoEntity3.setTipoContratoEntity(tipoContratoEntity10);
	    	contratoEntity3.setIsATivo(true);
	    	
	    ContratoEntity contratoEntity4 = new ContratoEntity();
	    	contratoEntity4.setDataInicioVigencia(DateUtility.gerarDataFormatoDate(2021, 4, 19));
	    	contratoEntity4.setDataFimVigencia(null);
	    	contratoEntity4.setPessoaContratado(pessoaEntity10);
	    	contratoEntity4.setPessoaContratante(pessoaEntity1);
	    	contratoEntity4.setTipoContratoEntity(tipoContratoEntity2);
	    	contratoEntity4.setIsATivo(true);
	    	
	    ContratoEntity contratoEntity5 = new ContratoEntity();
	    	contratoEntity5.setDataInicioVigencia(DateUtility.gerarDataFormatoDate(2021, 2, 16));
	    	contratoEntity5.setDataFimVigencia(null);
	    	contratoEntity5.setPessoaContratado(pessoaEntity2);
	    	contratoEntity5.setPessoaContratante(pessoaEntity1);
	    	contratoEntity5.setTipoContratoEntity(tipoContratoEntity4);
	    	contratoEntity5.setDiaVencimentoFatura(16);
	    	contratoEntity5.setValorMensalPagamento(118D);
	    	contratoEntity5.setTipoPeriodoFinanceiroEnumeration(TipoPeriodoFinanceiroEnumeration.ANUAL);
	    	contratoEntity5.setNumeroMesesVigenciaContrato(12);
	    	contratoEntity5.setIsATivo(true);
    		
    		this.contratoRepository.saveAll(Arrays.asList(contratoEntity1, contratoEntity2, contratoEntity3, contratoEntity4, contratoEntity5));
    		
//    		this.parcelamentoService.gerarParcelamentoContrato(contratoEntity5);
    		
    	// Fluxo de Conta Bancaria
    	ContaBancariaEntity contaBancariaEntity1 = new ContaBancariaEntity();
    		contaBancariaEntity1.setContratoEntity(contratoEntity1);
    		contaBancariaEntity1.setDataAbertura(null);
    		contaBancariaEntity1.setDataFechamento(null);
    		contaBancariaEntity1.setNumeroAgencia("3441");
    		contaBancariaEntity1.setNumeroConta("01083366-1");
    		contaBancariaEntity1.setTipoContaBancariaEntity(tipoContaBancariaEntity1);
    		contaBancariaEntity1.setValorSaldoAtual(0D);
    		contaBancariaEntity1.setPessoaInstituicaoFinanceira(contratoEntity1.getPessoaContratado());
    		contaBancariaEntity1.setIsBeneficio(false);
    		contaBancariaEntity1.setIsAtivo(true);
    		
    	ContaBancariaEntity contaBancariaEntity2 = new ContaBancariaEntity();
	    	contaBancariaEntity2.setContratoEntity(contratoEntity2);
	    	contaBancariaEntity2.setDataAbertura(null);
	    	contaBancariaEntity2.setDataFechamento(null);
	    	contaBancariaEntity2.setNumeroAgencia("1000");
	    	contaBancariaEntity2.setNumeroConta("00000000-1");
	    	contaBancariaEntity2.setTipoContaBancariaEntity(tipoContaBancariaEntity1);
	    	contaBancariaEntity2.setValorSaldoAtual(0D);
	    	contaBancariaEntity2.setPessoaInstituicaoFinanceira(contratoEntity2.getPessoaContratado());
	    	contaBancariaEntity2.setIsBeneficio(false);
    		contaBancariaEntity2.setIsAtivo(true);
	    	
	    ContaBancariaEntity contaBancariaEntity3 = new ContaBancariaEntity();
	    	contaBancariaEntity3.setContratoEntity(contratoEntity3);
	    	contaBancariaEntity3.setDataAbertura(null);
	    	contaBancariaEntity3.setDataFechamento(null);
	    	contaBancariaEntity3.setNumeroAgencia("XXXX");
	    	contaBancariaEntity3.setNumeroConta("XXXXXXXX-X");
	    	contaBancariaEntity3.setTipoContaBancariaEntity(tipoContaBancariaEntity6);
	    	contaBancariaEntity3.setValorSaldoAtual(0D);
	    	contaBancariaEntity3.setPessoaInstituicaoFinanceira(contratoEntity3.getPessoaContratado());
	    	contaBancariaEntity3.setIsBeneficio(false);
    		contaBancariaEntity3.setIsAtivo(true);
	    	
	    ContaBancariaEntity contaBancariaEntity4 = new ContaBancariaEntity();
	    	contaBancariaEntity4.setContratoEntity(contratoEntity4);
	    	contaBancariaEntity4.setDataAbertura(DateUtility.gerarDataFormatoDate(2021, 4, 28));
	    	contaBancariaEntity4.setDataFechamento(null);
	    	contaBancariaEntity4.setNumeroAgencia("0826-5");
	    	contaBancariaEntity4.setNumeroConta("71.746-0");
	    	contaBancariaEntity4.setTipoContaBancariaEntity(tipoContaBancariaEntity3);
	    	contaBancariaEntity4.setValorSaldoAtual(0D);
	    	contaBancariaEntity4.setPessoaInstituicaoFinanceira(pessoaEntity11);
	    	contaBancariaEntity4.setIsBeneficio(false);
    		contaBancariaEntity4.setIsAtivo(true);
    		
    	ContaBancariaEntity contaBancariaEntity5 = new ContaBancariaEntity();
	    	contaBancariaEntity5.setContratoEntity(contratoEntity4);
	    	contaBancariaEntity5.setDataAbertura(contratoEntity4.getDataInicioVigencia());
	    	contaBancariaEntity5.setDataFechamento(null);
	    	contaBancariaEntity5.setNumeroAgencia("0000");
	    	contaBancariaEntity5.setNumeroConta("000000");
	    	contaBancariaEntity5.setTipoContaBancariaEntity(tipoContaBancariaEntity7);
	    	contaBancariaEntity5.setValorSaldoAtual(1156.10);
	    	contaBancariaEntity5.setPessoaInstituicaoFinanceira(pessoaEntity12);
	    	contaBancariaEntity5.setIsBeneficio(true);
    		contaBancariaEntity5.setIsAtivo(true);
    		
    		this.contaBancariaRepository.saveAll(Arrays.asList(contaBancariaEntity1, contaBancariaEntity2, contaBancariaEntity3, contaBancariaEntity4, contaBancariaEntity5));

		// Fluxo de Receita Fixa (com Parcelamento)
    	/*
		ReceitaEntity receitaEntity1 = new ReceitaEntity();
			receitaEntity1.setCategoriaReceitaEntity(categoriaReceitaEntity4);
			receitaEntity1.setContaBancariaDeposito(contaBancariaEntity1);
			receitaEntity1.setDataPrevisaoRecebimento(DateUtility.gerarDataFormatoDate(2021, Calendar.FEBRUARY, 13));
			receitaEntity1.setDataRecebimentoPagamento(null);
			receitaEntity1.setIdentificador("REC202102130001FIX");
			receitaEntity1.setQuantidadeParcela(2);
			receitaEntity1.setResponsavelPagamento(pessoaEntity3);
			receitaEntity1.setValorPagamento(0D);
			receitaEntity1.setTipoFormaPagamentoEntity(formaPagamentoEntity2);
			receitaEntity1.setTipoPeriodoFinanceiroEnumeration(TipoPeriodoFinanceiroEnumeration.MENSAL);
			receitaEntity1.setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration.PENDENTE);
			receitaEntity1.setTipoReceitaEnumeration(TipoReceitaEnumeration.RECEITA_FIXA);

    	ParcelamentoEntity parcelamentoEntity1 = new ParcelamentoEntity();
    		parcelamentoEntity1.setNumeroParcela(1);
    		parcelamentoEntity1.setValorTotalParcelamento(4000D);
    		parcelamentoEntity1.setDataVencimentoParcela(DateUtility.gerarDataFormatoDate(2021, Calendar.FEBRUARY, 13));
    		parcelamentoEntity1.setDataPagamentoParcela(null);
    		parcelamentoEntity1.setValorEfetivoParcela(null);
			parcelamentoEntity1.setValorPrevistoParcela(2000D);
    		parcelamentoEntity1.setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration.PENDENTE);
    		parcelamentoEntity1.setReceitaEntity(receitaEntity1);

		ParcelamentoEntity parcelamentoEntity2 = new ParcelamentoEntity();
			parcelamentoEntity2.setNumeroParcela(2);
			parcelamentoEntity2.setValorTotalParcelamento(4000D);
			parcelamentoEntity2.setDataVencimentoParcela(DateUtility.gerarDataFormatoDate(2021, Calendar.MARCH, 13));
			parcelamentoEntity2.setDataPagamentoParcela(null);
			parcelamentoEntity2.setValorEfetivoParcela(null);
			parcelamentoEntity2.setValorPrevistoParcela(2000D);
			parcelamentoEntity2.setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration.PENDENTE);
			parcelamentoEntity2.setReceitaEntity(receitaEntity1);

			receitaEntity1.adicionarParcelamentoReceita(parcelamentoEntity1);
			receitaEntity1.adicionarParcelamentoReceita(parcelamentoEntity2);

			receitaRepository.save(receitaEntity1);
		*/
    		
		// Fluxo de Despesa Variavel (com Produtos e Serviços e Forma de Pagamento Multiplo)
		CategoriaDespesaEntity categoriaDespesaEntity1 = new CategoriaDespesaEntity();
			categoriaDespesaEntity1.setDescricao("Despesa Fixa");
			categoriaDespesaEntity1.setSigla("DFI");
			
		CategoriaDespesaEntity categoriaDespesaEntity2 = new CategoriaDespesaEntity();
			categoriaDespesaEntity2.setDescricao("Despesa Variável");
			categoriaDespesaEntity2.setSigla("DVA");
			
			this.categoriaDespesaRepository.saveAll(Arrays.asList(categoriaDespesaEntity1, categoriaDespesaEntity2));
			
		ProdutoServicoOcorrenciaEntity produtoServicoOcorrenciaEntity1 = new ProdutoServicoOcorrenciaEntity();
		ProdutoServicoOcorrenciaEntity produtoServicoOcorrenciaEntity2 = new ProdutoServicoOcorrenciaEntity();
		ProdutoServicoOcorrenciaEntity produtoServicoOcorrenciaEntity3 = new ProdutoServicoOcorrenciaEntity();
			
		ProdutoServicoEntity produtoServicoEntity1 = new ProdutoServicoEntity();
			produtoServicoEntity1.setDescricao("Pizza de Alho");
			produtoServicoOcorrenciaEntity1.setQuantidade(1);
			produtoServicoOcorrenciaEntity1.setValorUnitario(25D);
			produtoServicoOcorrenciaEntity1.setProdutoServicoEntity(produtoServicoEntity1);
			
		ProdutoServicoEntity produtoServicoEntity2 = new ProdutoServicoEntity();
			produtoServicoEntity2.setDescricao("Pizza de Mussarela");
			produtoServicoOcorrenciaEntity2.setQuantidade(1);
			produtoServicoOcorrenciaEntity2.setValorUnitario(25D);
			produtoServicoOcorrenciaEntity2.setProdutoServicoEntity(produtoServicoEntity2);
			
		ProdutoServicoEntity produtoServicoEntity3 = new ProdutoServicoEntity();
			produtoServicoEntity3.setDescricao("Guaraná Antártica 2L");
			produtoServicoOcorrenciaEntity3.setQuantidade(1);
			produtoServicoOcorrenciaEntity3.setValorUnitario(6.99);
			produtoServicoOcorrenciaEntity3.setProdutoServicoEntity(produtoServicoEntity3);
			
		FormaPagamentoDespesaEntity formaPagamentoDespesaEntity1 = new FormaPagamentoDespesaEntity();
			formaPagamentoDespesaEntity1.setNumeroParcelamento(1);
			formaPagamentoDespesaEntity1.setValorPagamento(18.49);
			formaPagamentoDespesaEntity1.setPessoaPagamento(pessoaEntity6);
			formaPagamentoDespesaEntity1.setFormaPagamentoEntity(formaPagamentoEntity6);
			
		FormaPagamentoDespesaEntity formaPagamentoDespesaEntity2 = new FormaPagamentoDespesaEntity();
			formaPagamentoDespesaEntity2.setNumeroParcelamento(1);
			formaPagamentoDespesaEntity2.setValorPagamento(18.49);
			formaPagamentoDespesaEntity2.setPessoaPagamento(pessoaEntity1);
			formaPagamentoDespesaEntity2.setFormaPagamentoEntity(formaPagamentoEntity6);
			
		DespesaEntity despesaEntity1 = new DespesaEntity();
			despesaEntity1.setCategoriaDespesaEntity(categoriaDespesaEntity2);
			despesaEntity1.setPessoaFavorecido(pessoaEntity5);
			despesaEntity1.setDataPagamento(new Date());
			despesaEntity1.setDataVencimento(new Date());
			despesaEntity1.setDataCadastro(new Date());
			despesaEntity1.setObservacao(null);
			despesaEntity1.setTipoCanalPagamentoEnumeration(TipoCanalPagamentoEnumeration.TRANSACAO_ONLINE);
			despesaEntity1.setValorTotal(50.99);
			despesaEntity1.setValorDesconto(20D);
			despesaEntity1.setValorPagamento(36.99);
			despesaEntity1.adicionarProdutoServicoDespesa(produtoServicoEntity1);
			despesaEntity1.adicionarProdutoServicoDespesa(produtoServicoEntity2);
			despesaEntity1.adicionarProdutoServicoDespesa(produtoServicoEntity3);
			despesaEntity1.adicionarFormaPagamentoDespesa(formaPagamentoDespesaEntity1);
			despesaEntity1.adicionarFormaPagamentoDespesa(formaPagamentoDespesaEntity2);
			
			this.despesaRepository.save(despesaEntity1);
			
			this.produtoServicoOcorrenciaRepository.saveAll(Arrays.asList(produtoServicoOcorrenciaEntity1, produtoServicoOcorrenciaEntity2, produtoServicoOcorrenciaEntity3));
			
		// Inserir documentos no banco de dados
//		ArquivoEntity arquivoEntity = new ArquivoEntity();
//		
//		String sistemaOperacional = System.getProperty("os.name").toUpperCase();
//		
//		File file = new File("");
//		
//		if(sistemaOperacional.toLowerCase().contains("windows")) {
//			file = new File("C:\\Desenvolvimento\\SISTEMAFINANCEIROAPI\\src\\main\\resources\\files\\BRAVA_INTERNET_FATURA_2021_03_16_001.pdf");
//		} else {
//			file = new File("/home/desenvolvimento/Desenvolvimento/SISTEMAFINANCEIROAPI/src/main/resources/files/BRAVA_INTERNET_FATURA_2021_03_16_001.pdf");
//		}
//		
//			try {
//				byte[] bytes = Files.readAllBytes(file.toPath());
//				arquivoEntity.setConteudo(bytes);
//				arquivoEntity.setNome(file.getName());
//				arquivoEntity.setDataCadastro(new Date());
//				arquivoEntity.setTamanho((long) bytes.length);
//				String nomeArquivoCompleto = arquivoEntity.getNome();
//				if( nomeArquivoCompleto.contains(".") ) {
//					arquivoEntity.setTipo(nomeArquivoCompleto.substring(nomeArquivoCompleto.lastIndexOf(".") + 1));
//				}
//				this.arquivoRepository.save(arquivoEntity);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			
		// Fluxo de Formas de pagamentos cinculados ao contrato
		CategoriaCartaoBancarioEntity categoriaCartaoBancarioEntity1 = new CategoriaCartaoBancarioEntity("Cartão de Crédito");
		CategoriaCartaoBancarioEntity categoriaCartaoBancarioEntity2 = new CategoriaCartaoBancarioEntity("Cartão de Débito");
		
			this.categoriaCartaoBancarioRepository.saveAll(Arrays.asList(categoriaCartaoBancarioEntity1, categoriaCartaoBancarioEntity2));
			
		BandeiraCartaoBancarioEntity bandeiraCartaoBancarioEntity1 = new BandeiraCartaoBancarioEntity("Master Card");
		BandeiraCartaoBancarioEntity bandeiraCartaoBancarioEntity2 = new BandeiraCartaoBancarioEntity("Visa Card");
		BandeiraCartaoBancarioEntity bandeiraCartaoBancarioEntity3 = new BandeiraCartaoBancarioEntity("Elo Card");
		
			this.bandeiraCartaoBancarioRepository.saveAll(Arrays.asList(bandeiraCartaoBancarioEntity1, bandeiraCartaoBancarioEntity2, bandeiraCartaoBancarioEntity3));
			
		CartaoBancarioEntity cartaoBancarioEntity1 = new CartaoBancarioEntity();
			cartaoBancarioEntity1.setBandeiraCartaoBancarioEntity(bandeiraCartaoBancarioEntity1);
			cartaoBancarioEntity1.setCategoriaCartaoBancarioEntity(categoriaCartaoBancarioEntity1);
			cartaoBancarioEntity1.setContaBancariaEntity(contaBancariaEntity2);
			cartaoBancarioEntity1.setDataValidade("10/28");
			cartaoBancarioEntity1.setDescricao("PLATINUM");
			cartaoBancarioEntity1.setNomeImpresso("JOSE Q S JUNIOR");
			cartaoBancarioEntity1.setNumero("5447-9094-8101-3037");
			
		CartaoBancarioEntity cartaoBancarioEntity2 = new CartaoBancarioEntity();
			cartaoBancarioEntity2.setBandeiraCartaoBancarioEntity(bandeiraCartaoBancarioEntity3);
			cartaoBancarioEntity2.setCategoriaCartaoBancarioEntity(categoriaCartaoBancarioEntity2);
			cartaoBancarioEntity2.setContaBancariaEntity(contaBancariaEntity5);
			cartaoBancarioEntity2.setDataValidade("04/26");
			cartaoBancarioEntity2.setDescricao("ALIMENTAÇÃO");
			cartaoBancarioEntity2.setNomeImpresso("JOSE Q SILVA JR");
			cartaoBancarioEntity2.setNumero("5067-6188-3218-1018");
			
			this.cartaoBancarioRepository.saveAll(Arrays.asList(cartaoBancarioEntity1, cartaoBancarioEntity2));
			
		FuncaoCartaoBancarioEntity funcaoCartaoBancarioEntity1 = new FuncaoCartaoBancarioEntity();
			funcaoCartaoBancarioEntity1.setCartaoBancarioEntity(cartaoBancarioEntity1);
			funcaoCartaoBancarioEntity1.setDescricao("Crédito");
			funcaoCartaoBancarioEntity1.setIsAtivo(true);
		
		FuncaoCartaoBancarioEntity funcaoCartaoBancarioEntity2 = new FuncaoCartaoBancarioEntity();
			funcaoCartaoBancarioEntity2.setCartaoBancarioEntity(cartaoBancarioEntity1);
			funcaoCartaoBancarioEntity2.setDescricao("Débito");
			funcaoCartaoBancarioEntity2.setIsAtivo(true);
			
		FuncaoCartaoBancarioEntity funcaoCartaoBancarioEntity3 = new FuncaoCartaoBancarioEntity();
			funcaoCartaoBancarioEntity3.setCartaoBancarioEntity(cartaoBancarioEntity2);
			funcaoCartaoBancarioEntity3.setDescricao("Débito");
			funcaoCartaoBancarioEntity3.setIsAtivo(true);
			
			this.funcaoCartaoBancarioRepository.saveAndFlush(funcaoCartaoBancarioEntity1);
			this.funcaoCartaoBancarioRepository.saveAndFlush(funcaoCartaoBancarioEntity2);
			this.funcaoCartaoBancarioRepository.saveAndFlush(funcaoCartaoBancarioEntity3);
			
		// Fluxo de Perfil de Usuarios do sistema
		TipoUsuarioSistemaEntity tipoUsuarioSistemaEntity1 = new TipoUsuarioSistemaEntity("Administrador Financeiro");
		TipoUsuarioSistemaEntity tipoUsuarioSistemaEntity2 = new TipoUsuarioSistemaEntity("Consultor Financeiro");
		TipoUsuarioSistemaEntity tipoUsuarioSistemaEntity3 = new TipoUsuarioSistemaEntity("Verificador Finanaceiro"); // Usado para pessoas que tomaram emprestimos
		UsuarioSistemaEntity usuarioSistemaEntity1 = new UsuarioSistemaEntity();
			usuarioSistemaEntity1.setIdentificador("00000000000");
			usuarioSistemaEntity1.setIsAtivo(true);
			usuarioSistemaEntity1.setPessoaEntity(pessoaEntity1);
			usuarioSistemaEntity1.setSenha("123456");
			usuarioSistemaEntity1.setTipoUsuarioSistemaEntity(tipoUsuarioSistemaEntity1);
			
		UsuarioSistemaEntity usuarioSistemaEntity2 = new UsuarioSistemaEntity();
			usuarioSistemaEntity2.setIdentificador("11111111111");
			usuarioSistemaEntity2.setIsAtivo(true);
			usuarioSistemaEntity2.setPessoaEntity(pessoaEntity6);
			usuarioSistemaEntity2.setSenha("654321");
			usuarioSistemaEntity2.setTipoUsuarioSistemaEntity(tipoUsuarioSistemaEntity1);
			
			this.tipoUsuarioSistemaRepository.saveAll(Arrays.asList(tipoUsuarioSistemaEntity1, tipoUsuarioSistemaEntity2, tipoUsuarioSistemaEntity3));
			this.usuarioSistemaRepository.saveAll(Arrays.asList(usuarioSistemaEntity1, usuarioSistemaEntity2));
		
    }

}
