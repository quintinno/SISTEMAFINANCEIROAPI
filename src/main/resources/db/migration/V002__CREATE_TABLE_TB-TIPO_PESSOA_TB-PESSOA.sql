CREATE TABLE IF NOT EXISTS TB_TIPO_PESSOA (
	CODIGO SERIAL NOT NULL,
    SIGLA VARCHAR(45) NOT NULL,
	DESCRICAO VARCHAR(45) NOT NULL,
	CONSTRAINT PK_TIPO_PESSOA PRIMARY KEY(CODIGO)
);

CREATE TABLE IF NOT EXISTS TB_PESSOA (
        CODIGO SERIAL NOT NULL,
        ID_TIPO_PESSOA INTEGER NOT NULL,
        NOME VARCHAR(80) NOT NULL,
        IS_PESSOA_FINANCEIRA BOOLEAN NOT NULL,
        IS_INSTITUICAO_FINANCEIRA BOOLEAN NOT NULL,
        IS_ATIVO BOOLEAN NOT NULL,
        CONSTRAINT PK_PESSOA PRIMARY KEY(CODIGO),
        CONSTRAINT FK_TIPO_PESSOA FOREIGN KEY(ID_TIPO_PESSOA) REFERENCES TB_TIPO_PESSOA(CODIGO)
);
