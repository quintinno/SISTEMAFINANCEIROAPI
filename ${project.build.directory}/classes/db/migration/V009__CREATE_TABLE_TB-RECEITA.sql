DROP TABLE IF EXISTS TB_RECEITA CASCADE;

CREATE TABLE IF NOT EXISTS TB_RECEITA (
	CODIGO SERIAL NOT NULL,
	ID_CATEGORIA_RECEITA INTEGER NOT NULL,
	ID_CONTA_BANCARIA_DEPOSITO INTEGER NOT NULL,
	ID_RESPONSAVEL_PAGAMENTO INTEGER NOT NULL,
	ID_FORMA_PAGAMENTO INTEGER NOT NULL,
	DATA_PREVISAO_PAGAMENTO DATE NULL, 
	DATA_RECEBIMENTO_PAGAMENTO DATE NULL, 
	IDENTIFICADOR VARCHAR(45) NOT NULL UNIQUE, 
	QUANTIDADE_PARCELA INTEGER NOT NULL, 
	TIPO_PERIODO_FINANCEIRO VARCHAR(45) NOT NULL, 
	TIPO_RECEITA VARCHAR(45) NOT NULL,
	TIPO_SITUACAO_PAGAMENTO VARCHAR(45) NOT NULL,
	VALOR_PAGAMENTO FLOAT8 NOT NULL,
	CONSTRAINT PK_RECEITA PRIMARY KEY (CODIGO),
	CONSTRAINT FK_CATEGORIA_RECEITA FOREIGN KEY (ID_CATEGORIA_RECEITA) REFERENCES TB_CATEGORIA_RECEITA,
	CONSTRAINT FK_CONTA_BANCARIA_DEPOSITO FOREIGN KEY (ID_CONTA_BANCARIA_DEPOSITO) REFERENCES TB_CONTA_BANCARIA,
	CONSTRAINT FK_RESPONSAVEL_PAGAMENTO FOREIGN KEY (ID_RESPONSAVEL_PAGAMENTO) REFERENCES TB_PESSOA,
	CONSTRAINT FK_FORMA_PAGAMENTO FOREIGN KEY (ID_FORMA_PAGAMENTO) REFERENCES TB_FORMA_PAGAMENTO
);

CREATE SEQUENCE SEQ_RECEITA START 1 INCREMENT 1 MINVALUE 1 OWNED BY TB_RECEITA.CODIGO;

INSERT INTO PUBLIC.TB_RECEITA (CODIGO, DATA_PREVISAO_PAGAMENTO, DATA_RECEBIMENTO_PAGAMENTO, IDENTIFICADOR, QUANTIDADE_PARCELA, TIPO_PERIODO_FINANCEIRO, TIPO_RECEITA, TIPO_SITUACAO_PAGAMENTO, VALOR_PAGAMENTO, ID_CATEGORIA_RECEITA, ID_CONTA_BANCARIA_DEPOSITO, ID_RESPONSAVEL_PAGAMENTO, ID_FORMA_PAGAMENTO) VALUES 
(NEXTVAL ('SEQ_RECEITA'), '2021-03-14', NULL, 'REC20210313001FIX', 5, 'MENSAL', 'RECEITA_FIXA', 'PENDENTE', 2000, (SELECT CODIGO FROM tb_categoria_receita WHERE upper(descricao) LIKE UPPER('Benefício (Seguro Desemprego)')), 1, 3, 2),
(NEXTVAL ('SEQ_RECEITA'), NULL, '2021-02-09', 'REC20210209001VAR', 0, 'UNICO', 'RECEITA_VARIAVEL', 'PAGO', 1000, (SELECT CODIGO FROM tb_categoria_receita WHERE upper(descricao) LIKE UPPER('Devolução de Empréstimo (Concessão)')), 1, 3, 3);