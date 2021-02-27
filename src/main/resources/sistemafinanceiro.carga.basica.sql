INSERT INTO TB_TIPO_FORMA_PAGAMENTO (CODIGO, DESCRICAO, SIGLA) VALUES
(NEXTVAL ('public.hibernate_sequence'), 'Dinheiro', 'DN'),
(NEXTVAL ('public.hibernate_sequence'), 'Tranferência Bancária', 'TB'),
(NEXTVAL ('public.hibernate_sequence'), 'Tranferência Bancária (PIX)', 'TBPIX'),
(NEXTVAL ('public.hibernate_sequence'), 'Depósito Bancário', 'DB'),
(NEXTVAL ('public.hibernate_sequence'), 'Boleto Bancário', 'BB'),
(NEXTVAL ('public.hibernate_sequence'), 'Cartão de Crédito', 'CC'),
(NEXTVAL ('public.hibernate_sequence'), 'Cheque', 'CH'),
(NEXTVAL ('public.hibernate_sequence'), 'Cartão de Débito', 'CD'),
(NEXTVAL ('public.hibernate_sequence'), 'Crédito Loja', 'CL'),
(NEXTVAL ('public.hibernate_sequence'), 'Vale Alimentação', 'VA'),
(NEXTVAL ('public.hibernate_sequence'), 'Vale Refeição', 'VR'),
(NEXTVAL ('public.hibernate_sequence'), 'Vale Presente', 'VP'),
(NEXTVAL ('public.hibernate_sequence'), 'Vale Combustível', 'VC');

INSERT INTO TB_CATEGORIA_RECEITA (CODIGO, DESCRICAO) VALUES
(NEXTVAL ('public.hibernate_sequence'), 'Devolução de Empréstimo'),
(NEXTVAL ('public.hibernate_sequence'), 'Pagamento de Salário Mensalista'),
(NEXTVAL ('public.hibernate_sequence'), 'Solicitação de Empréstimo'),
(NEXTVAL ('public.hibernate_sequence'), 'Mensalidade'),
(NEXTVAL ('public.hibernate_sequence'), 'Benefício Governamental (Seguro Desemprego)');

INSERT INTO TB_TIPO_CONTA_BANCARIA (CODIGO, DESCRICAO) VALUES
(NEXTVAL ('public.hibernate_sequence'), 'Conta Corrente'),
(NEXTVAL ('public.hibernate_sequence'), 'Conta Corrente (Conta Digital)'),
(NEXTVAL ('public.hibernate_sequence'), 'Conta Corrente (Conta Salario)'),
(NEXTVAL ('public.hibernate_sequence'), 'Poupanca'),
(NEXTVAL ('public.hibernate_sequence'), 'Conta Investimento');

INSERT INTO TB_TIPO_PESSOA (CODIGO, SIGLA, DESCRICAO) VALUES(NEXTVAL ('public.hibernate_sequence'), 'PF', 'Pessoa Física');
INSERT INTO TB_TIPO_PESSOA (CODIGO, SIGLA, DESCRICAO) VALUES(NEXTVAL ('public.hibernate_sequence'), 'PJ', 'Pessoa Jurídica');

INSERT INTO TB_PESSOA (CODIGO, NOME, ID_TIPO_PESSOA, IS_ATIVO, IS_INSTITUICAO_FINANCEIRA, IS_PESSOA_FINANCEIRA) VALUES
(NEXTVAL ('public.hibernate_sequence'), 'Banco Santander',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PJ'), TRUE, TRUE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'Banco Nubank',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PJ'), TRUE, TRUE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'Banco Inter',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PJ'), TRUE, TRUE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'Banco Caixa Economica Federal',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PJ'), TRUE, TRUE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'Brava Fibra Internet',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PJ'), TRUE, TRUE, TRUE);

INSERT INTO TB_PESSOA (CODIGO, NOME, ID_TIPO_PESSOA, IS_ATIVO, IS_INSTITUICAO_FINANCEIRA, IS_PESSOA_FINANCEIRA) VALUES
(NEXTVAL ('public.hibernate_sequence'), 'Jose Quintinn',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PF'), TRUE, FALSE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'Jordann Lucas Rodrigues Andrade',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PF'), TRUE, FALSE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'Jonathan Luan Rodrigues Andrade',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PF'), TRUE, FALSE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'Vinicius Alcantara Menezes (Empréstimo EMP20160721001)',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PF'), TRUE, FALSE, TRUE);

INSERT INTO TB_TIPO_CONTRATO (CODIGO, DESCRICAO) VALUES
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Conta Bancária'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Trabalho CLT'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Trabalho CNPJ'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Internet'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Benefício Governamental (Seguro Desemprego)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Benefício Governamental (Auxílio Doença)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Benefício Governamental (INSS Saúde)');

INSERT INTO TB_CONTRATO (CODIGO, DATA_FIM_VIGENCIA, DATA_INICIO_VIGENCIA, ID_PESSOA_CONTRATANTE, ID_PESSOA_CONTRATADO, ID_TIPO_CONTRATO, IS_ATIVO) VALUES
(NEXTVAL ('public.hibernate_sequence'),  NULL, NULL, (SELECT codigo FROM tb_pessoa WHERE lower(NOME) like lower('%BANCO SANTANDER%')), (SELECT codigo FROM tb_pessoa WHERE lower(NOME) like lower('%JOSE QUINTINN%')), (SELECT codigo FROM tb_tipo_contrato WHERE descricao like 'Contrato de Conta Bancária'), TRUE ),
(NEXTVAL ('public.hibernate_sequence'),  NULL, NULL, (SELECT codigo FROM tb_pessoa WHERE lower(NOME) like lower('%BANCO NUBANK%')), (SELECT codigo FROM tb_pessoa WHERE lower(NOME) like lower('%JOSE QUINTINN%')), (SELECT codigo FROM tb_tipo_contrato WHERE descricao like 'Contrato de Conta Bancária'), TRUE );

INSERT INTO TB_CONTA_BANCARIA (CODIGO, DATA_ABERTURA, DATA_ENCERRAMENTO, ID_CONTRATO, ID_TIPO_CONTA_BANCARIA, NUMERO_AGENCIA, NUMERO_CONTA, VALOR_SALDO_INICIAL) VALUES
(NEXTVAL ('public.hibernate_sequence'), NULL, NULL, (SELECT CONTRATO_.CODIGO FROM TB_CONTRATO CONTRATO_ JOIN TB_PESSOA PESSOA_ ON PESSOA_.CODIGO = CONTRATO_.ID_PESSOA_CONTRATANTE WHERE LOWER(PESSOA_.NOME) LIKE LOWER('%SANTANDER%')), (SELECT codigo FROM tb_tipo_conta_bancaria WHERE lower(descricao) LIKE lower('Conta Corrente')), '3441', '01083366-1', 0);

INSERT INTO PUBLIC.TB_RECEITA (CODIGO, DATA_PREVISAO_PAGAMENTO, DATA_RECEBIMENTO_PAGAMENTO, IDENTIFICADOR, QUANTIDADE_PARCELA, TIPO_PERIODO_FINANCEIRO, TIPO_RECEITA, TIPO_SITUACAO_PAGAMENTO, VALOR_PAGO, ID_CATEGORIA_RECEITA, ID_CONTA_BANCARIA_DEPOSITO, ID_RESPONSAVEL_PAGAMENTO, TIPO_FORMA_PAGAMENTO) VALUES
(NEXTVAL ('public.hibernate_sequence'), '2021-03-13', NULL, 'REC20210313001FIX', 5, 'MENSAL', 'RECEITA_FIXA', 'PENDENTE', 0, 18, 44, 29, 2),
(NEXTVAL ('public.hibernate_sequence'), NULL, '2021-02-09', 'REC20210209001VAR', NULL, 'UNICO', 'RECEITA_VARIAVEL', 'PAGO', 500, 14, 44, 34, 3);

INSERT INTO PUBLIC.TB_PARCELAMENTO (CODIGO, DATA_PAGAMENTO_PARCELA, DATA_VENCIMENTO_PARCELA, SITUACAO_PAGAMENTO , NUMERO_PARCELA, VALOR_EFETIVO_PARCELA, VALOR_PREVISTO_PARCELA, VALOR_TOTAL_PARCELAMENTO, ID_RECEITA) VALUES
(NEXTVAL ('public.hibernate_sequence'), NULL, '2021-02-14', 'PENDENTE', 1, NULL, 1000, 5000, (SELECT codigo FROM tb_receita WHERE identificador LIKE 'REC20210313001FIX')),
(NEXTVAL ('public.hibernate_sequence'), NULL, '2021-03-14', 'PENDENTE', 2, NULL, 1000, 5000, (SELECT codigo FROM tb_receita WHERE identificador LIKE 'REC20210313001FIX')),
(NEXTVAL ('public.hibernate_sequence'), NULL, '2021-04-14', 'PENDENTE', 3, NULL, 1000, 5000, (SELECT codigo FROM tb_receita WHERE identificador LIKE 'REC20210313001FIX')),
(NEXTVAL ('public.hibernate_sequence'), NULL, '2021-05-14', 'PENDENTE', 4, NULL, 1000, 5000, (SELECT codigo FROM tb_receita WHERE identificador LIKE 'REC20210313001FIX')),
(NEXTVAL ('public.hibernate_sequence'), NULL, '2021-06-14', 'PENDENTE', 5, NULL, 1000, 5000, (SELECT codigo FROM tb_receita WHERE identificador LIKE 'REC20210313001FIX'));
