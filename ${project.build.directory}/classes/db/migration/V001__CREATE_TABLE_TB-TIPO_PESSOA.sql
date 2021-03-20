DROP TABLE IF EXISTS TB_TIPO_PESSOA CASCADE;

CREATE TABLE IF NOT EXISTS TB_TIPO_PESSOA (
	CODIGO SERIAL NOT NULL,
	DESCRICAO VARCHAR(45) UNIQUE,
	SIGLA VARCHAR(6) NOT NULL UNIQUE,
	CONSTRAINT PK_TIPO_PESSOA PRIMARY KEY (CODIGO)
);

CREATE SEQUENCE SEQ_TIPO_PESSOA START 1 INCREMENT 1 MINVALUE 1 OWNED BY TB_TIPO_PESSOA.CODIGO;

INSERT INTO TB_TIPO_PESSOA (CODIGO, DESCRICAO, SIGLA) VALUES
(NEXTVAL('SEQ_TIPO_PESSOA'), 'Pessoa Física', 'PF'),
(NEXTVAL('SEQ_TIPO_PESSOA'), 'Pessoa Jurídica', 'PJ');