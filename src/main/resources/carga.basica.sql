------------------------------------------------------------------------------------------------------------------------
# DUMP DATABASE POSTGRES

    -- Exportar - Dump Database

        pg_dump -Fc -h localhost -U postgres db_sistemafinanceiro -f DUMP_DATABASE_DESENVOLVIMENTO.sql

    -- Importar - Dump Database

		-- Linux
        	pg_restore -d db_sistemafinanceiro -h localhost -U postgres DUMP_DATABASE_DESENVOLVIMENTO.sql
        	
        -- Windows
        	pg_restore.exe --host localhost --port 5432 --username postgres --dbname db_sistemafinanceiro C:\Application\SISTEMAFINANCEIROAPI\src\main\resources\dump\DUMP_DATABASE_DESENVOLVIMENTO.sql
        
------------------------------------------------------------------------------------------------------------------------
INSERT INTO TB_TIPO_PESSOA (CODIGO, SIGLA, DESCRICAO) VALUES(NEXTVAL ('public.hibernate_sequence'), 'PF', 'Pessoa Física');
INSERT INTO TB_TIPO_PESSOA (CODIGO, SIGLA, DESCRICAO) VALUES(NEXTVAL ('public.hibernate_sequence'), 'PJ', 'Pessoa Jurídica');

INSERT INTO TB_CATEGORIA_DESPESA (CODIGO, DESCRICAO,  SIGLA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Despesa Fixa', 'DFI');
INSERT INTO TB_CATEGORIA_DESPESA (CODIGO, DESCRICAO,  SIGLA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Despesa Variável', 'DVA');

INSERT INTO TB_TIPO_CONTRATO (CODIGO, DESCRICAO) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Contrato de Serviços de Internet Fixa');
INSERT INTO TB_TIPO_CONTRATO (CODIGO, DESCRICAO) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Contrato de Serviços de Internet Móvel');
INSERT INTO TB_TIPO_CONTRATO (CODIGO, DESCRICAO) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Contrato de Associação à Entidade (Religiosa)');

INSERT INTO TB_PESSOA (CODIGO, NOME, ID_TIPO_PESSOA, IS_ATIVO, IS_INSTITUICAO_FINANCEIRA, IS_PESSOA_FINANCEIRA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'José Quintinn (Administrador Financeiro)',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PF'), TRUE, FALSE, TRUE);
INSERT INTO TB_PESSOA (CODIGO, NOME, ID_TIPO_PESSOA, IS_ATIVO, IS_INSTITUICAO_FINANCEIRA, IS_PESSOA_FINANCEIRA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Tim Telecomunicações (Brasil)',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PJ'), TRUE, TRUE, TRUE);
INSERT INTO TB_PESSOA (CODIGO, NOME, ID_TIPO_PESSOA, IS_ATIVO, IS_INSTITUICAO_FINANCEIRA, IS_PESSOA_FINANCEIRA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Brava Internet (Distrito Federal)',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PJ'), TRUE, TRUE, TRUE);
INSERT INTO TB_PESSOA (CODIGO, NOME, ID_TIPO_PESSOA, IS_ATIVO, IS_INSTITUICAO_FINANCEIRA, IS_PESSOA_FINANCEIRA) VALUES (NEXTVAL ('public.hibernate_sequence'), 'Sinagoga Keter Torah (Distrito Federal)',  (SELECT codigo FROM tb_tipo_pessoa WHERE sigla = 'PJ'), TRUE, TRUE, TRUE);

INSERT INTO TB_TIPO_USUARIO (CODIGO, DESCRICAO) VALUES (NEXTVAL ('PUBLIC.HIBERNATE_SEQUENCE'), 'ADMINSTRADOR_FINANCEIRO');

INSERT INTO TB_USUARIO_SISTEMA (CODIGO, ID_PESSOA, ID_TIPO_USUARIO_SISTEMA, IDENTIFICADOR, SENHA, IS_ATIVO) VALUES (NEXTVAL ('public.hibernate_sequence'), (SELECT CODIGO FROM TB_PESSOA WHERE LOWER(NOME) LIKE LOWER('%QUINTINN%')), (SELECT CODIGO FROM tb_tipo_usuario WHERE LOWER(DESCRICAO) LIKE LOWER('%ADMINSTRADOR_FINANCEIRO%')), 'desenvolvimento', 'desenvolvimento', TRUE);

------------------------------------------------------------------------------------------------------------------------

-- INSERT INTO TB_TIPO_CONTRATO (CODIGO, DESCRICAO) VALUES
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Conta Bancária'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Trabalho (CLT)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Trabalho (CNPJ)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Serviços de Internet Fixa'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Serviços de Internet Móvel'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Associação à Entidade (Religiosa)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Benefício Governamental (Seguro Desemprego)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Benefício Governamental (Auxílio Doença)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Benefício Governamental (INSS Saúde)');

------------------------------------------------------------------------------------------------------------------------

-- REGISTRAR PAGAMENTOS DE PARCELAS
UPDATE TB_PARCELAMENTO
SET
	DATA_PAGAMENTO_PARCELA = NOW(),
	VALOR_EFETIVO_PARCELA = 200,
	SITUACAO_PAGAMENTO = 'PAGO'
WHERE CODIGO IN(43,44,45,46,47);

------------------------------------------------------------------------------------------------------------------------

