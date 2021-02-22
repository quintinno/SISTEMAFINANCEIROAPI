INSERT INTO TB_TIPO_PESSOA (CODIGO, SIGLA, DESCRICAO) VALUES(100, 'PF', 'PESSOA FÍSICA');
INSERT INTO TB_TIPO_PESSOA (CODIGO, SIGLA, DESCRICAO) VALUES(1000, 'PJ', 'PESSOA JURÍDICA');

INSERT INTO TB_PESSOA (CODIGO, NOME, ID_TIPO_PESSOA, IS_ATIVO, IS_INSTITUICAO_FINANCEIRA, IS_PESSOA_FINANCEIRA) VALUES 
(NEXTVAL ('public.hibernate_sequence'), 'BANCO SANTANDER',  1000, TRUE, TRUE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'BANCO NUBANK',  1000, TRUE, TRUE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'BANCO INTER',  1000, TRUE, TRUE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'BANCO CAIXA ECONOMICA FEDERAL',  1000, TRUE, TRUE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'BRAVA FIBRA INTERNET',  1000, TRUE, TRUE, TRUE);

INSERT INTO TB_PESSOA (CODIGO, NOME, ID_TIPO_PESSOA, IS_ATIVO, IS_INSTITUICAO_FINANCEIRA, IS_PESSOA_FINANCEIRA) VALUES
(NEXTVAL ('public.hibernate_sequence'), 'JOSE QUINTINN',  100, TRUE, FALSE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'JORDANN LUCAS RODRIGUES ANDRADE',  100, TRUE, FALSE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'JONATHAN LUAN RODRIGUES ANDRADE',  100, TRUE, FALSE, TRUE),
(NEXTVAL ('public.hibernate_sequence'), 'VINICIUS ALCANTARA MENEZES',  100, TRUE, FALSE, TRUE);

INSERT INTO tb_tipo_contrato (codigo, descricao) VALUES 
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Conta Bancária'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Trabalho CLT'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Trabalho CNPJ'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Internet'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Benefício Governamental (Seguro Desemprego)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Benefício Governamental (Auxílio Doença)'),
(NEXTVAL ('public.hibernate_sequence'), 'Contrato de Benefício Governamental (INSS Saúde)');
