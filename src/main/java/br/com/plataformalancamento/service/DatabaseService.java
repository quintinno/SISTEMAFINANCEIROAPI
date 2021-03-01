package br.com.plataformalancamento.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.CategoriaReceitaEntity;
import br.com.plataformalancamento.entity.ContaBancariaEntity;
import br.com.plataformalancamento.entity.ContratoEntity;
import br.com.plataformalancamento.entity.FormaPagamentoEntity;
import br.com.plataformalancamento.entity.PessoaEntity;
import br.com.plataformalancamento.entity.TipoContaBancariaEntity;
import br.com.plataformalancamento.entity.TipoContratoEntity;
import br.com.plataformalancamento.entity.TipoPessoaEntity;
import br.com.plataformalancamento.repository.CategoriaReceitaRepository;
import br.com.plataformalancamento.repository.ContaBancariaRepository;
import br.com.plataformalancamento.repository.ContratoRepository;
import br.com.plataformalancamento.repository.FormaPagamentoRepository;
import br.com.plataformalancamento.repository.PessoaRepository;
import br.com.plataformalancamento.repository.ReceitaRepository;
import br.com.plataformalancamento.repository.TipoContaBancariaRepository;
import br.com.plataformalancamento.repository.TipoContratoRepository;
import br.com.plataformalancamento.repository.TipoPessoaRepository;

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
    
    @Autowired
    private ReceitaRepository receitaRepository;

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
    		
    		this.pessoaRepository.saveAll(Arrays.asList(pessoaEntity1, pessoaEntity2, pessoaEntity3, pessoaEntity4));
    		
    	CategoriaReceitaEntity categoriaReceitaEntity1 = new CategoriaReceitaEntity("Devolução de Empréstimo (Concessão)");
    	CategoriaReceitaEntity categoriaReceitaEntity2 = new CategoriaReceitaEntity("Solicitação de Empréstimo (Obtenção)");
    	CategoriaReceitaEntity categoriaReceitaEntity3 = new CategoriaReceitaEntity("Pagamento de Salário Mensalista");
    	CategoriaReceitaEntity categoriaReceitaEntity4 = new CategoriaReceitaEntity("Benefício (Seguro Desemprego)");
    	
    		this.categoriaReceitaRepository.saveAll(Arrays.asList(categoriaReceitaEntity1, categoriaReceitaEntity2, categoriaReceitaEntity3, categoriaReceitaEntity4));
    		
    	FormaPagamentoEntity formaPagamentoEntity1 = new FormaPagamentoEntity("Dinheiro", "DN");
    	FormaPagamentoEntity formaPagamentoEntity2 = new FormaPagamentoEntity("Tranferência Bancária", "TB");
    	FormaPagamentoEntity formaPagamentoEntity3 = new FormaPagamentoEntity("Tranferência Bancária (PIX)", "TBPIX");
    	FormaPagamentoEntity formaPagamentoEntity4 = new FormaPagamentoEntity("Depósito Bancário", "DB");
    	FormaPagamentoEntity formaPagamentoEntity5 = new FormaPagamentoEntity("Boleto Bancário", "BB");
    	FormaPagamentoEntity formaPagamentoEntity6 = new FormaPagamentoEntity("Cartão de Crédito", "CC");
    	FormaPagamentoEntity formaPagamentoEntity7 = new FormaPagamentoEntity("Cheque", "CH");
    	FormaPagamentoEntity formaPagamentoEntity8 = new FormaPagamentoEntity("Cartão de Débito", "CD");
    	FormaPagamentoEntity formaPagamentoEntity9 = new FormaPagamentoEntity("Crédito Loja", "CL");
    	FormaPagamentoEntity formaPagamentoEntity10 = new FormaPagamentoEntity("Vale Alimentação", "VA");
    	FormaPagamentoEntity formaPagamentoEntity11 = new FormaPagamentoEntity("Vale Refeição", "VR");
    	FormaPagamentoEntity formaPagamentoEntity12 = new FormaPagamentoEntity("Vale Presente", "VP");
    	FormaPagamentoEntity formaPagamentoEntity13 = new FormaPagamentoEntity("Vale Combustível", "VC");
    		
    		this.formaPagamentoRepository.saveAll(Arrays.asList(formaPagamentoEntity1, formaPagamentoEntity2, formaPagamentoEntity3, formaPagamentoEntity4, formaPagamentoEntity5, formaPagamentoEntity6, formaPagamentoEntity7, formaPagamentoEntity8, formaPagamentoEntity9, formaPagamentoEntity10, formaPagamentoEntity11, formaPagamentoEntity12, formaPagamentoEntity13));
    	
    	TipoContaBancariaEntity tipoContaBancariaEntity1 = new TipoContaBancariaEntity("Conta Corrente");
    	TipoContaBancariaEntity tipoContaBancariaEntity2 = new TipoContaBancariaEntity("Conta Corrente (Conta Digital)");
    	TipoContaBancariaEntity tipoContaBancariaEntity3 = new TipoContaBancariaEntity("Conta Corrente (Conta Salario)");
    	TipoContaBancariaEntity tipoContaBancariaEntity4 = new TipoContaBancariaEntity("Poupança");
    	TipoContaBancariaEntity tipoContaBancariaEntity5 = new TipoContaBancariaEntity("Conta Investimento");
    	
    		this.tipoContaBancariaRepository.saveAll(Arrays.asList(tipoContaBancariaEntity1, tipoContaBancariaEntity2, tipoContaBancariaEntity3, tipoContaBancariaEntity4, tipoContaBancariaEntity5));
    	
    	TipoContratoEntity tipoContratoEntity1 = new TipoContratoEntity("Contrato de Conta Bancária");
    	TipoContratoEntity tipoContratoEntity2 = new TipoContratoEntity("Contrato de Trabalho CLT");
    	TipoContratoEntity tipoContratoEntity3 = new TipoContratoEntity("Contrato de Trabalho CNPJ");
    	TipoContratoEntity tipoContratoEntity4 = new TipoContratoEntity("Contrato de Internet");
    	TipoContratoEntity tipoContratoEntity5 = new TipoContratoEntity("Contrato de Benefício (Seguro Desemprego)");
    	TipoContratoEntity tipoContratoEntity6 = new TipoContratoEntity("Contrato de Benefício (Auxílio Doença)");
    	TipoContratoEntity tipoContratoEntity7 = new TipoContratoEntity("Contrato de Benefício (INSS Saúde)");
    	
    		this.tipoContratoRepository.saveAll(Arrays.asList(tipoContratoEntity1, tipoContratoEntity2, tipoContratoEntity3, tipoContratoEntity4, tipoContratoEntity5, tipoContratoEntity6, tipoContratoEntity7));
    	
    	ContratoEntity contratoEntity1 = new ContratoEntity();
    		contratoEntity1.setDataInicioVigencia(null);
    		contratoEntity1.setDataFimVigencia(null);
    		contratoEntity1.setPessoaContratado(pessoaEntity3);
    		contratoEntity1.setPessoaContratante(pessoaEntity1);
    		contratoEntity1.setTipoContratoEntity(tipoContratoEntity1);
    		contratoEntity1.setIsATivo(true);
    		
    		this.contratoRepository.saveAll(Arrays.asList(contratoEntity1));
    		
    	ContaBancariaEntity contaBancariaEntity1 = new ContaBancariaEntity();
    		contaBancariaEntity1.setContratoEntity(contratoEntity1);
    		contaBancariaEntity1.setDataAbertura(null);
    		contaBancariaEntity1.setDataFechamento(null);
    		contaBancariaEntity1.setNumeroAgencia("3441");
    		contaBancariaEntity1.setNumeroConta("01083366-1");
    		contaBancariaEntity1.setTipoContaBancariaEntity(tipoContaBancariaEntity1);
    		contaBancariaEntity1.setValorSaldoInicial(0D);
    		
    		this.contaBancariaRepository.saveAll(Arrays.asList(contaBancariaEntity1));
    		
    	// TODO -- Criar fluxo de Receita Fixa (com Parcelamento)
//    	ReceitaEntity receitaEntity1 = new ReceitaEntity();
//    		receitaEntity1.setCategoriaReceitaEntity(categoriaReceitaEntity4);
//    		receitaEntity1.setContaBancariaDeposito(contaBancariaEntity1);
//    		receitaEntity1.setDataPrevisaoRecebimento(DateUtility.gerarDataFormatoDate(2021, Calendar.FEBRUARY, 16));
//    		receitaEntity1.setDataRecebimentoPagamento(null);
//    		receitaEntity1.setIdentificador("REC20210214001FIX");
//    		receitaEntity1.setParcelamentoEntityList(null);
    		
    }

}
