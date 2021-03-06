DROP TABLE IF EXISTS TB_FORMA_PAGAMENTO CASCADE;

CREATE TABLE IF NOT EXISTS TB_FORMA_PAGAMENTO (
	CODIGO SERIAL NOT NULL,
	DESCRICAO VARCHAR(90) NOT NULL UNIQUE,
	SIGLA VARCHAR(10) NOT NULL UNIQUE,
	CONSTRAINT PK_FORMA_PAGAMENTO PRIMARY KEY (CODIGO)
);

CREATE SEQUENCE SEQ_FORMA_PAGAMENTO START 1 INCREMENT 1 MINVALUE 1 OWNED BY TB_FORMA_PAGAMENTO.CODIGO;

INSERT INTO TB_FORMA_PAGAMENTO (CODIGO, DESCRICAO, SIGLA) VALUES 
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Dinheiro', 'DN'),
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Tranferência Bancária', 'TB'),
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Tranferência Bancária (PIX)', 'TBPIX'),
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Depósito Bancário', 'DB'),
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Boleto Bancário', 'BB'),
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Cartão de Crédito', 'CC'),
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Cheque', 'CH'),
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Cartão de Débito', 'CD'),
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Crédito Loja', 'CL'),
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Vale Alimentação', 'VA'),
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Vale Refeição', 'VR'),
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Vale Presente', 'VP'),
(NEXTVAL ('SEQ_FORMA_PAGAMENTO'), 'Vale Combustível', 'VC');