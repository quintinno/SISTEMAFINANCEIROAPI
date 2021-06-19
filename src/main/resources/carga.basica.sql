INSERT INTO TB_TIPO_PESSOA (CODIGO, SIGLA, DESCRICAO) VALUES(NEXTVAL ('public.hibernate_sequence'), 'PF', 'Pessoa Física');
INSERT INTO TB_TIPO_PESSOA (CODIGO, SIGLA, DESCRICAO) VALUES(NEXTVAL ('public.hibernate_sequence'), 'PJ', 'Pessoa Jurídica');

INSERT INTO TB_CATEGORIA_DESPESA (CODIGO, DESCRICAO,  SIGLA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Despesa Fixa', 'DFI');
INSERT INTO TB_CATEGORIA_DESPESA (CODIGO, DESCRICAO,  SIGLA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Despesa Variável', 'DVA');

INSERT INTO TB_TIPO_CONTRATO (CODIGO, DESCRICAO, SIGLA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Contrato de Serviços de Internet Fixa', 'CSIF');
INSERT INTO TB_TIPO_CONTRATO (CODIGO, DESCRICAO, SIGLA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Contrato de Serviços de Internet Móvel', 'CSIM');
INSERT INTO TB_TIPO_CONTRATO (CODIGO, DESCRICAO, SIGLA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Contrato de Associação à Entidade (Religiosa)', 'CAER');

INSERT INTO TB_PESSOA (CODIGO, NOME, ID_TIPO_PESSOA, IS_ATIVO, IS_INSTITUICAO_FINANCEIRA, IS_PESSOA_FINANCEIRA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'José Quintinn (Administrador Financeiro)',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PF'), TRUE, FALSE, TRUE);
INSERT INTO TB_PESSOA (CODIGO, NOME, ID_TIPO_PESSOA, IS_ATIVO, IS_INSTITUICAO_FINANCEIRA, IS_PESSOA_FINANCEIRA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Tim Telecomunicações (Brasil)',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PJ'), TRUE, TRUE, TRUE);
INSERT INTO TB_PESSOA (CODIGO, NOME, ID_TIPO_PESSOA, IS_ATIVO, IS_INSTITUICAO_FINANCEIRA, IS_PESSOA_FINANCEIRA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Brava Internet (Distrito Federal)',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PJ'), TRUE, TRUE, TRUE);
INSERT INTO TB_PESSOA (CODIGO, NOME, ID_TIPO_PESSOA, IS_ATIVO, IS_INSTITUICAO_FINANCEIRA, IS_PESSOA_FINANCEIRA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Sinagoga Keter Torah (Distrito Federal)',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PJ'), TRUE, TRUE, TRUE);

INSERT INTO TB_TIPO_CONTRATO (CODIGO, DESCRICAO) VALUES
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Conta Bancária'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Trabalho (CLT)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Trabalho (CNPJ)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Serviços de Internet Fixa'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Serviços de Internet Móvel'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Associação à Entidade (Religiosa)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Benefício Governamental (Seguro Desemprego)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Benefício Governamental (Auxílio Doença)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Benefício Governamental (INSS Saúde)');