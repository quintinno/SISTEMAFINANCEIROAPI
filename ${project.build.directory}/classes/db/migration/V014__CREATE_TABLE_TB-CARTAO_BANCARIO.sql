DROP TABLE IF EXISTS TB_CARTAO_BANCARIO CASCADE;

CREATE TABLE IF NOT EXISTS TB_CARTAO_BANCARIO (
    CODIGO SERIAL NOT NULL,
    ID_CONTA_BANCARIA INTEGER NOT NULL,
    ID_TIPO_CARTAO_BANCARIO INTEGER NOT NULL,
    ID_BANDEIRA INTEGER NOT NULL,
    DESCRICAO VARCHAR(90) NOT NULL,
    DATA_VALIDADE VARCHAR(7) NOT NULL,
    NOME_IMPRESSO VARCHAR(90) NOT NULL,
    CONSTRAINT PK_CARTAO_BANCARIO PRIMARY KEY (CODIGO),
    CONSTRAINT FK_CONTA_BANCARIA FOREIGN KEY (ID_CONTA_BANCARIA) REFERENCES TB_CONTA_BANCARIA (CODIGO),
    CONSTRAINT FK_TB_TIPO_CARTAO_BANCARIO FOREIGN KEY (ID_TIPO_CARTAO_BANCARIO) REFERENCES TB_TIPO_CARTAO_BANCARIO (CODIGO),
    CONSTRAINT FK_BANDEIRA FOREIGN KEY (ID_BANDEIRA) REFERENCES TB_BANDEIRA (CODIGO)
);

CREATE SEQUENCE SEQ_CARTAO_BANCARIO START 1 INCREMENT 1 MINVALUE 1 OWNED BY TB_CARTAO_BANCARIO.CODIGO;

INSERT INTO TB_CARTAO_BANCARIO (CODIGO, ID_CONTA_BANCARIA, ID_TIPO_CARTAO_BANCARIO, ID_BANDEIRA, DESCRICAO, DATA_VALIDADE, NOME_IMPRESSO) VALUES 
(NEXTVAL('SEQ_CARTAO_BANCARIO'), 
(SELECT CODIGO FROM TB_CONTA_BANCARIA WHERE NUMERO_CONTA = 'XXXXXXXX-1'), 
(SELECT CODIGO FROM TB_TIPO_CARTAO_BANCARIO WHERE UPPER(DESCRICAO) LIKE UPPER('%CRÉDITO%')), 
(SELECT CODIGO FROM TB_BANDEIRA WHERE UPPER(DESCRICAO) LIKE UPPER('%MASTER%')), 
'PLATINUM', 
'10/28', 
'JOSE Q S JUNIOR');