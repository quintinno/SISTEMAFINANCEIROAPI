DROP TABLE IF EXISTS TB_TIPO_CONTA_BANCARIA CASCADE;

CREATE TABLE IF NOT EXISTS TB_TIPO_CONTA_BANCARIA (
	CODIGO SERIAL NOT NULL,
	DESCRICAO VARCHAR(45) NOT NULL UNIQUE,
	CONSTRAINT PK_TIPO_CONTA_BANCARIA PRIMARY KEY (CODIGO)
);

CREATE SEQUENCE SEQ_TIPO_CONTA_BANCARIA START 1 INCREMENT 1 MINVALUE 1 OWNED BY TB_TIPO_CONTA_BANCARIA.CODIGO;

INSERT INTO TB_TIPO_CONTA_BANCARIA (CODIGO, DESCRICAO) VALUES
(NEXTVAL ('SEQ_TIPO_CONTA_BANCARIA'), 'Conta Corrente'),
(NEXTVAL ('SEQ_TIPO_CONTA_BANCARIA'), 'Conta Corrente (Conta Digital)'),
(NEXTVAL ('SEQ_TIPO_CONTA_BANCARIA'), 'Conta Corrente (Conta Salario)'),
(NEXTVAL ('SEQ_TIPO_CONTA_BANCARIA'), 'Poupanca'),
(NEXTVAL ('SEQ_TIPO_CONTA_BANCARIA'), 'Conta Investimento');