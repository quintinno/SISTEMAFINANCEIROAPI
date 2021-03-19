DROP TABLE IF EXISTS TB_ARQUIVO CASCADE;

CREATE TABLE IF NOT EXISTS TB_ARQUIVO (
	CODIGO SERIAL NOT NULL,
	ID_DOCUMENTO INTEGER NOT NULL,
	DATA_CADASTRO DATE NOT NULL,
	NOME VARCHAR(90) NOT NULL,
	TIPO VARCHAR(90) NOT NULL,
	CONTEUDO_ARQUIVO BYTEA NOT NULL,
	CONSTRAINT PK_ARQUIVO PRIMARY KEY (CODIGO),
	CONSTRAINT FK_DOCUMENTO FOREIGN KEY (ID_DOCUMENTO) REFERENCES TB_DOCUMENTO (CODIGO)
);

CREATE SEQUENCE SEQ_ARQUIVO START 1 INCREMENT 1 MINVALUE 1 OWNED BY TB_ARQUIVO.CODIGO;