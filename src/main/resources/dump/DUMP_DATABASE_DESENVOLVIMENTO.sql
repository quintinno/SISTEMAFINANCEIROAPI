PGDMP                         y            db_sistemafinanceiro #   12.7 (Ubuntu 12.7-0ubuntu0.20.04.1) #   12.7 (Ubuntu 12.7-0ubuntu0.20.04.1) �               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    27949    db_sistemafinanceiro    DATABASE     �   CREATE DATABASE db_sistemafinanceiro WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_BR.UTF-8' LC_CTYPE = 'pt_BR.UTF-8';
 $   DROP DATABASE db_sistemafinanceiro;
                postgres    false            �            1259    30842    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    30844 
   tb_arquivo    TABLE     �   CREATE TABLE public.tb_arquivo (
    codigo bigint NOT NULL,
    conteudo bytea NOT NULL,
    data_cadastro timestamp without time zone NOT NULL,
    nome character varying(255) NOT NULL,
    tamanho bigint,
    tipo character varying(255) NOT NULL
);
    DROP TABLE public.tb_arquivo;
       public         heap    postgres    false            �            1259    30852    tb_bandeira_cartao_bancario    TABLE     ~   CREATE TABLE public.tb_bandeira_cartao_bancario (
    codigo bigint NOT NULL,
    descricao character varying(50) NOT NULL
);
 /   DROP TABLE public.tb_bandeira_cartao_bancario;
       public         heap    postgres    false            �            1259    30857    tb_beneficio    TABLE     �   CREATE TABLE public.tb_beneficio (
    codigo bigint NOT NULL,
    descricao character varying(255) NOT NULL,
    sigla character varying(255) NOT NULL
);
     DROP TABLE public.tb_beneficio;
       public         heap    postgres    false            �            1259    30865    tb_beneficio_valor    TABLE     �   CREATE TABLE public.tb_beneficio_valor (
    codigo bigint NOT NULL,
    is_credito boolean NOT NULL,
    valor double precision NOT NULL,
    id_beneficio bigint NOT NULL,
    id_composicao_salario bigint
);
 &   DROP TABLE public.tb_beneficio_valor;
       public         heap    postgres    false            �            1259    30870    tb_cartao_bancario    TABLE     �  CREATE TABLE public.tb_cartao_bancario (
    codigo bigint NOT NULL,
    data_validade character varying(255) NOT NULL,
    descricao character varying(50) NOT NULL,
    nome_impresso character varying(50) NOT NULL,
    numero character varying(50) NOT NULL,
    id_bandeira_cartao_bancario bigint NOT NULL,
    id_categoria_cartao_bancario bigint NOT NULL,
    id_conta_bancaria bigint NOT NULL
);
 &   DROP TABLE public.tb_cartao_bancario;
       public         heap    postgres    false            �            1259    30875    tb_categoria_cartao_bancario    TABLE        CREATE TABLE public.tb_categoria_cartao_bancario (
    codigo bigint NOT NULL,
    descricao character varying(50) NOT NULL
);
 0   DROP TABLE public.tb_categoria_cartao_bancario;
       public         heap    postgres    false            �            1259    30880    tb_categoria_despesa    TABLE     �   CREATE TABLE public.tb_categoria_despesa (
    codigo bigint NOT NULL,
    descricao character varying(255) NOT NULL,
    sigla character varying(255) NOT NULL
);
 (   DROP TABLE public.tb_categoria_despesa;
       public         heap    postgres    false            �            1259    30888    tb_categoria_documento    TABLE     �   CREATE TABLE public.tb_categoria_documento (
    codigo bigint NOT NULL,
    descricao character varying(255),
    sigla character varying(255)
);
 *   DROP TABLE public.tb_categoria_documento;
       public         heap    postgres    false            �            1259    30896    tb_categoria_receita    TABLE     w   CREATE TABLE public.tb_categoria_receita (
    codigo bigint NOT NULL,
    descricao character varying(50) NOT NULL
);
 (   DROP TABLE public.tb_categoria_receita;
       public         heap    postgres    false            �            1259    30901    tb_chave_pix    TABLE     �   CREATE TABLE public.tb_chave_pix (
    codigo bigint NOT NULL,
    chave_pix character varying(255),
    tipo_chave_pix character varying(255),
    id_contrato bigint
);
     DROP TABLE public.tb_chave_pix;
       public         heap    postgres    false            �            1259    30909 	   tb_cidade    TABLE     �   CREATE TABLE public.tb_cidade (
    codigo bigint NOT NULL,
    nome character varying(85) NOT NULL,
    id_estado bigint NOT NULL
);
    DROP TABLE public.tb_cidade;
       public         heap    postgres    false            �            1259    30914    tb_composicao_salario    TABLE     :  CREATE TABLE public.tb_composicao_salario (
    codigo bigint NOT NULL,
    data_referencia character varying(255) NOT NULL,
    is_ativo boolean NOT NULL,
    valor_salario_bruto double precision NOT NULL,
    valor_salario_liquido double precision NOT NULL,
    valor_total_desconto double precision NOT NULL
);
 )   DROP TABLE public.tb_composicao_salario;
       public         heap    postgres    false            �            1259    30919    tb_conta_bancaria    TABLE     �  CREATE TABLE public.tb_conta_bancaria (
    codigo bigint NOT NULL,
    data_abertura date,
    data_encerramento date,
    is_ativo boolean NOT NULL,
    is_beneficio boolean NOT NULL,
    numero_agencia character varying(255) NOT NULL,
    valor_saldo_atual double precision NOT NULL,
    id_cidade_agencia_bancaria bigint,
    id_contrato bigint NOT NULL,
    id_pessoa_instituicao_financeira bigint NOT NULL
);
 %   DROP TABLE public.tb_conta_bancaria;
       public         heap    postgres    false            �            1259    30924    tb_contrato    TABLE     
  CREATE TABLE public.tb_contrato (
    codigo bigint NOT NULL,
    data_fim_vigencia date,
    data_inicio_vigencia date,
    data_pagamento integer,
    dia_vencimento_fatura integer,
    identificador character varying(45),
    is_ativo boolean NOT NULL,
    numero_meses_vigencia_contrato integer,
    tipo_periodo_financeiro character varying(255),
    valor_mensal_pagamento double precision,
    id_pessoa_contratado bigint NOT NULL,
    id_pessoa_contratante bigint NOT NULL,
    id_tipo_contrato bigint NOT NULL
);
    DROP TABLE public.tb_contrato;
       public         heap    postgres    false            �            1259    30929 
   tb_despesa    TABLE       CREATE TABLE public.tb_despesa (
    codigo bigint NOT NULL,
    data_cadastro date NOT NULL,
    data_pagamento date,
    data_vencimento date,
    observacao character varying(255),
    tipo_canal_pagamento character varying(255),
    valor_desconto double precision,
    valor_juros_atraso double precision,
    valor_multa_atraso double precision,
    valor_pagamento double precision,
    valor_total_pagamento double precision,
    id_categoria_despesa bigint NOT NULL,
    id_pessoa_favorecido bigint NOT NULL
);
    DROP TABLE public.tb_despesa;
       public         heap    postgres    false            �            1259    30937    tb_documento    TABLE     �  CREATE TABLE public.tb_documento (
    codigo bigint NOT NULL,
    complemento character varying(80),
    data_emissao timestamp without time zone,
    data_vencimento timestamp without time zone,
    numero character varying(80) NOT NULL,
    observacao character varying(255),
    orgao_emissor character varying(80),
    id_categoria_documento bigint NOT NULL,
    id_pessoa bigint NOT NULL
);
     DROP TABLE public.tb_documento;
       public         heap    postgres    false            �            1259    30945    tb_email    TABLE     �   CREATE TABLE public.tb_email (
    codigo bigint NOT NULL,
    descricao character varying(85) NOT NULL,
    is_principal boolean NOT NULL,
    id_pessoa bigint NOT NULL
);
    DROP TABLE public.tb_email;
       public         heap    postgres    false            �            1259    30950    tb_endereco    TABLE     �  CREATE TABLE public.tb_endereco (
    codigo bigint NOT NULL,
    bairro character varying(45) NOT NULL,
    cep character varying(10),
    complemento character varying(85),
    is_ativo boolean NOT NULL,
    logradouro character varying(85) NOT NULL,
    numero character varying(10) NOT NULL,
    ponto_referencia character varying(80),
    id_cidade bigint NOT NULL,
    id_pessoa bigint NOT NULL,
    id_tipo_endereco bigint NOT NULL
);
    DROP TABLE public.tb_endereco;
       public         heap    postgres    false            �            1259    30955 	   tb_estado    TABLE     {   CREATE TABLE public.tb_estado (
    codigo bigint NOT NULL,
    nome character varying(80),
    id_pais bigint NOT NULL
);
    DROP TABLE public.tb_estado;
       public         heap    postgres    false            �            1259    30960    tb_fatura_bancaria    TABLE     �  CREATE TABLE public.tb_fatura_bancaria (
    codigo bigint NOT NULL,
    data_pagamento date,
    data_referencia character varying(255),
    data_vencimento date,
    identificador character varying(255),
    id_situacao_pagamento character varying(255),
    valor_atraso double precision,
    valor_desconto double precision,
    valor_juros double precision,
    valor_total double precision,
    valor_total_pagamento double precision,
    id_cartao_bancario bigint NOT NULL
);
 &   DROP TABLE public.tb_fatura_bancaria;
       public         heap    postgres    false            �            1259    30968    tb_forma_pagamento    TABLE     �   CREATE TABLE public.tb_forma_pagamento (
    codigo bigint NOT NULL,
    descricao character varying(60) NOT NULL,
    is_ativo boolean NOT NULL,
    sigla character varying(6) NOT NULL
);
 &   DROP TABLE public.tb_forma_pagamento;
       public         heap    postgres    false            �            1259    30973    tb_forma_pagamento_despesa    TABLE       CREATE TABLE public.tb_forma_pagamento_despesa (
    codigo bigint NOT NULL,
    numero_parcelamento integer NOT NULL,
    valor_pagamento double precision NOT NULL,
    id_despesa bigint NOT NULL,
    id_forma_pagamento bigint NOT NULL,
    id_pessoa_pagamento bigint NOT NULL
);
 .   DROP TABLE public.tb_forma_pagamento_despesa;
       public         heap    postgres    false            �            1259    30978    tb_funcao_cartao_bancario    TABLE     �   CREATE TABLE public.tb_funcao_cartao_bancario (
    codigo bigint NOT NULL,
    descricao character varying(50) NOT NULL,
    is_ativo boolean NOT NULL,
    id_cartao_bancario bigint NOT NULL
);
 -   DROP TABLE public.tb_funcao_cartao_bancario;
       public         heap    postgres    false            �            1259    30983    tb_pais    TABLE     \   CREATE TABLE public.tb_pais (
    codigo bigint NOT NULL,
    nome character varying(80)
);
    DROP TABLE public.tb_pais;
       public         heap    postgres    false            �            1259    30988    tb_parcelamento    TABLE     �  CREATE TABLE public.tb_parcelamento (
    codigo bigint NOT NULL,
    data_pagamento_parcela date,
    data_vencimento_parcela date,
    numero_parcela integer NOT NULL,
    situacao_pagamento character varying(255),
    valor_efetivo_parcela double precision,
    valor_previsto_parcela double precision NOT NULL,
    valor_total_parcelamento double precision NOT NULL,
    id_despesa bigint
);
 #   DROP TABLE public.tb_parcelamento;
       public         heap    postgres    false            �            1259    30993 	   tb_pessoa    TABLE     -  CREATE TABLE public.tb_pessoa (
    codigo bigint NOT NULL,
    is_ativo boolean NOT NULL,
    is_instituicao_financeira boolean NOT NULL,
    is_pessoa_financeira boolean NOT NULL,
    nome character varying(255),
    nome_pessoa_sistema character varying(255),
    id_tipo_pessoa bigint NOT NULL
);
    DROP TABLE public.tb_pessoa;
       public         heap    postgres    false            �            1259    31001    tb_produto_bancario    TABLE     	  CREATE TABLE public.tb_produto_bancario (
    codigo bigint NOT NULL,
    descricao character varying(255),
    is_ativo boolean,
    numero_conta character varying(255) NOT NULL,
    id_conta_bancaria bigint NOT NULL,
    id_tipo_conta_bancaria bigint NOT NULL
);
 '   DROP TABLE public.tb_produto_bancario;
       public         heap    postgres    false            �            1259    31009    tb_produto_servico    TABLE     �   CREATE TABLE public.tb_produto_servico (
    codigo bigint NOT NULL,
    descricao character varying(255),
    id_despesa bigint,
    id_fatura_bancaria bigint
);
 &   DROP TABLE public.tb_produto_servico;
       public         heap    postgres    false            �            1259    31014    tb_produto_servico_ocorrencia    TABLE     �   CREATE TABLE public.tb_produto_servico_ocorrencia (
    codigo bigint NOT NULL,
    quantidade integer NOT NULL,
    valor_unitario double precision NOT NULL,
    id_produto_servico bigint NOT NULL
);
 1   DROP TABLE public.tb_produto_servico_ocorrencia;
       public         heap    postgres    false            �            1259    31019 
   tb_receita    TABLE     J  CREATE TABLE public.tb_receita (
    codigo bigint NOT NULL,
    data_previsao_pagamento date,
    data_recebimento_pagamento date,
    identificador character varying(45) NOT NULL,
    quantidade_parcela integer,
    tipo_periodo_financeiro character varying(255),
    tipo_receita character varying(255),
    tipo_situacao_pagamento character varying(255),
    valor_pagamento double precision NOT NULL,
    id_categoria_receita bigint NOT NULL,
    id_conta_bancaria_deposito bigint NOT NULL,
    id_responsavel_pagamento bigint NOT NULL,
    tipo_forma_pagamento bigint NOT NULL
);
    DROP TABLE public.tb_receita;
       public         heap    postgres    false            �            1259    31027    tb_tipo_conta_bancaria    TABLE     y   CREATE TABLE public.tb_tipo_conta_bancaria (
    codigo bigint NOT NULL,
    descricao character varying(45) NOT NULL
);
 *   DROP TABLE public.tb_tipo_conta_bancaria;
       public         heap    postgres    false            �            1259    31032    tb_tipo_contrato    TABLE     s   CREATE TABLE public.tb_tipo_contrato (
    codigo bigint NOT NULL,
    descricao character varying(65) NOT NULL
);
 $   DROP TABLE public.tb_tipo_contrato;
       public         heap    postgres    false            �            1259    31037    tb_tipo_endereco    TABLE     s   CREATE TABLE public.tb_tipo_endereco (
    codigo bigint NOT NULL,
    descricao character varying(45) NOT NULL
);
 $   DROP TABLE public.tb_tipo_endereco;
       public         heap    postgres    false            �            1259    31042    tb_tipo_pessoa    TABLE     �   CREATE TABLE public.tb_tipo_pessoa (
    codigo bigint NOT NULL,
    descricao character varying(45) NOT NULL,
    sigla character varying(8) NOT NULL
);
 "   DROP TABLE public.tb_tipo_pessoa;
       public         heap    postgres    false            �            1259    31047    tb_tipo_telefone    TABLE     s   CREATE TABLE public.tb_tipo_telefone (
    codigo bigint NOT NULL,
    descricao character varying(45) NOT NULL
);
 $   DROP TABLE public.tb_tipo_telefone;
       public         heap    postgres    false            �            1259    31052    tb_tipo_usuario    TABLE     r   CREATE TABLE public.tb_tipo_usuario (
    codigo bigint NOT NULL,
    descricao character varying(45) NOT NULL
);
 #   DROP TABLE public.tb_tipo_usuario;
       public         heap    postgres    false            �            1259    31057    tb_usuario_sistema    TABLE       CREATE TABLE public.tb_usuario_sistema (
    codigo bigint NOT NULL,
    identificador character varying(45) NOT NULL,
    is_ativo boolean NOT NULL,
    senha character varying(45) NOT NULL,
    id_pessoa bigint NOT NULL,
    id_tipo_usuario_sistema bigint NOT NULL
);
 &   DROP TABLE public.tb_usuario_sistema;
       public         heap    postgres    false            �          0    30844 
   tb_arquivo 
   TABLE DATA           Z   COPY public.tb_arquivo (codigo, conteudo, data_cadastro, nome, tamanho, tipo) FROM stdin;
    public          postgres    false    203   w      �          0    30852    tb_bandeira_cartao_bancario 
   TABLE DATA           H   COPY public.tb_bandeira_cartao_bancario (codigo, descricao) FROM stdin;
    public          postgres    false    204   �      �          0    30857    tb_beneficio 
   TABLE DATA           @   COPY public.tb_beneficio (codigo, descricao, sigla) FROM stdin;
    public          postgres    false    205   �      �          0    30865    tb_beneficio_valor 
   TABLE DATA           l   COPY public.tb_beneficio_valor (codigo, is_credito, valor, id_beneficio, id_composicao_salario) FROM stdin;
    public          postgres    false    206   �      �          0    30870    tb_cartao_bancario 
   TABLE DATA           �   COPY public.tb_cartao_bancario (codigo, data_validade, descricao, nome_impresso, numero, id_bandeira_cartao_bancario, id_categoria_cartao_bancario, id_conta_bancaria) FROM stdin;
    public          postgres    false    207   �      �          0    30875    tb_categoria_cartao_bancario 
   TABLE DATA           I   COPY public.tb_categoria_cartao_bancario (codigo, descricao) FROM stdin;
    public          postgres    false    208         �          0    30880    tb_categoria_despesa 
   TABLE DATA           H   COPY public.tb_categoria_despesa (codigo, descricao, sigla) FROM stdin;
    public          postgres    false    209   %      �          0    30888    tb_categoria_documento 
   TABLE DATA           J   COPY public.tb_categoria_documento (codigo, descricao, sigla) FROM stdin;
    public          postgres    false    210   f      �          0    30896    tb_categoria_receita 
   TABLE DATA           A   COPY public.tb_categoria_receita (codigo, descricao) FROM stdin;
    public          postgres    false    211   �      �          0    30901    tb_chave_pix 
   TABLE DATA           V   COPY public.tb_chave_pix (codigo, chave_pix, tipo_chave_pix, id_contrato) FROM stdin;
    public          postgres    false    212   �      �          0    30909 	   tb_cidade 
   TABLE DATA           <   COPY public.tb_cidade (codigo, nome, id_estado) FROM stdin;
    public          postgres    false    213   �      �          0    30914    tb_composicao_salario 
   TABLE DATA           �   COPY public.tb_composicao_salario (codigo, data_referencia, is_ativo, valor_salario_bruto, valor_salario_liquido, valor_total_desconto) FROM stdin;
    public          postgres    false    214   �      �          0    30919    tb_conta_bancaria 
   TABLE DATA           �   COPY public.tb_conta_bancaria (codigo, data_abertura, data_encerramento, is_ativo, is_beneficio, numero_agencia, valor_saldo_atual, id_cidade_agencia_bancaria, id_contrato, id_pessoa_instituicao_financeira) FROM stdin;
    public          postgres    false    215   �      �          0    30924    tb_contrato 
   TABLE DATA           &  COPY public.tb_contrato (codigo, data_fim_vigencia, data_inicio_vigencia, data_pagamento, dia_vencimento_fatura, identificador, is_ativo, numero_meses_vigencia_contrato, tipo_periodo_financeiro, valor_mensal_pagamento, id_pessoa_contratado, id_pessoa_contratante, id_tipo_contrato) FROM stdin;
    public          postgres    false    216         �          0    30929 
   tb_despesa 
   TABLE DATA           
  COPY public.tb_despesa (codigo, data_cadastro, data_pagamento, data_vencimento, observacao, tipo_canal_pagamento, valor_desconto, valor_juros_atraso, valor_multa_atraso, valor_pagamento, valor_total_pagamento, id_categoria_despesa, id_pessoa_favorecido) FROM stdin;
    public          postgres    false    217   �      �          0    30937    tb_documento 
   TABLE DATA           �   COPY public.tb_documento (codigo, complemento, data_emissao, data_vencimento, numero, observacao, orgao_emissor, id_categoria_documento, id_pessoa) FROM stdin;
    public          postgres    false    218   �      �          0    30945    tb_email 
   TABLE DATA           N   COPY public.tb_email (codigo, descricao, is_principal, id_pessoa) FROM stdin;
    public          postgres    false    219   �      �          0    30950    tb_endereco 
   TABLE DATA           �   COPY public.tb_endereco (codigo, bairro, cep, complemento, is_ativo, logradouro, numero, ponto_referencia, id_cidade, id_pessoa, id_tipo_endereco) FROM stdin;
    public          postgres    false    220         �          0    30955 	   tb_estado 
   TABLE DATA           :   COPY public.tb_estado (codigo, nome, id_pais) FROM stdin;
    public          postgres    false    221   3      �          0    30960    tb_fatura_bancaria 
   TABLE DATA           �   COPY public.tb_fatura_bancaria (codigo, data_pagamento, data_referencia, data_vencimento, identificador, id_situacao_pagamento, valor_atraso, valor_desconto, valor_juros, valor_total, valor_total_pagamento, id_cartao_bancario) FROM stdin;
    public          postgres    false    222   P      �          0    30968    tb_forma_pagamento 
   TABLE DATA           P   COPY public.tb_forma_pagamento (codigo, descricao, is_ativo, sigla) FROM stdin;
    public          postgres    false    223   m      �          0    30973    tb_forma_pagamento_despesa 
   TABLE DATA           �   COPY public.tb_forma_pagamento_despesa (codigo, numero_parcelamento, valor_pagamento, id_despesa, id_forma_pagamento, id_pessoa_pagamento) FROM stdin;
    public          postgres    false    224   �      �          0    30978    tb_funcao_cartao_bancario 
   TABLE DATA           d   COPY public.tb_funcao_cartao_bancario (codigo, descricao, is_ativo, id_cartao_bancario) FROM stdin;
    public          postgres    false    225   �      �          0    30983    tb_pais 
   TABLE DATA           /   COPY public.tb_pais (codigo, nome) FROM stdin;
    public          postgres    false    226   �      �          0    30988    tb_parcelamento 
   TABLE DATA           �   COPY public.tb_parcelamento (codigo, data_pagamento_parcela, data_vencimento_parcela, numero_parcela, situacao_pagamento, valor_efetivo_parcela, valor_previsto_parcela, valor_total_parcelamento, id_despesa) FROM stdin;
    public          postgres    false    227   �      �          0    30993 	   tb_pessoa 
   TABLE DATA           �   COPY public.tb_pessoa (codigo, is_ativo, is_instituicao_financeira, is_pessoa_financeira, nome, nome_pessoa_sistema, id_tipo_pessoa) FROM stdin;
    public          postgres    false    228         �          0    31001    tb_produto_bancario 
   TABLE DATA           �   COPY public.tb_produto_bancario (codigo, descricao, is_ativo, numero_conta, id_conta_bancaria, id_tipo_conta_bancaria) FROM stdin;
    public          postgres    false    229   �      �          0    31009    tb_produto_servico 
   TABLE DATA           _   COPY public.tb_produto_servico (codigo, descricao, id_despesa, id_fatura_bancaria) FROM stdin;
    public          postgres    false    230   �      �          0    31014    tb_produto_servico_ocorrencia 
   TABLE DATA           o   COPY public.tb_produto_servico_ocorrencia (codigo, quantidade, valor_unitario, id_produto_servico) FROM stdin;
    public          postgres    false    231         �          0    31019 
   tb_receita 
   TABLE DATA           7  COPY public.tb_receita (codigo, data_previsao_pagamento, data_recebimento_pagamento, identificador, quantidade_parcela, tipo_periodo_financeiro, tipo_receita, tipo_situacao_pagamento, valor_pagamento, id_categoria_receita, id_conta_bancaria_deposito, id_responsavel_pagamento, tipo_forma_pagamento) FROM stdin;
    public          postgres    false    232   "      �          0    31027    tb_tipo_conta_bancaria 
   TABLE DATA           C   COPY public.tb_tipo_conta_bancaria (codigo, descricao) FROM stdin;
    public          postgres    false    233   ?      �          0    31032    tb_tipo_contrato 
   TABLE DATA           =   COPY public.tb_tipo_contrato (codigo, descricao) FROM stdin;
    public          postgres    false    234   \      �          0    31037    tb_tipo_endereco 
   TABLE DATA           =   COPY public.tb_tipo_endereco (codigo, descricao) FROM stdin;
    public          postgres    false    235   �      �          0    31042    tb_tipo_pessoa 
   TABLE DATA           B   COPY public.tb_tipo_pessoa (codigo, descricao, sigla) FROM stdin;
    public          postgres    false    236   �      �          0    31047    tb_tipo_telefone 
   TABLE DATA           =   COPY public.tb_tipo_telefone (codigo, descricao) FROM stdin;
    public          postgres    false    237   -      �          0    31052    tb_tipo_usuario 
   TABLE DATA           <   COPY public.tb_tipo_usuario (codigo, descricao) FROM stdin;
    public          postgres    false    238   J      �          0    31057    tb_usuario_sistema 
   TABLE DATA           x   COPY public.tb_usuario_sistema (codigo, identificador, is_ativo, senha, id_pessoa, id_tipo_usuario_sistema) FROM stdin;
    public          postgres    false    239   �                 0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 55, true);
          public          postgres    false    202            �           2606    30851    tb_arquivo tb_arquivo_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tb_arquivo
    ADD CONSTRAINT tb_arquivo_pkey PRIMARY KEY (codigo);
 D   ALTER TABLE ONLY public.tb_arquivo DROP CONSTRAINT tb_arquivo_pkey;
       public            postgres    false    203            �           2606    30856 <   tb_bandeira_cartao_bancario tb_bandeira_cartao_bancario_pkey 
   CONSTRAINT     ~   ALTER TABLE ONLY public.tb_bandeira_cartao_bancario
    ADD CONSTRAINT tb_bandeira_cartao_bancario_pkey PRIMARY KEY (codigo);
 f   ALTER TABLE ONLY public.tb_bandeira_cartao_bancario DROP CONSTRAINT tb_bandeira_cartao_bancario_pkey;
       public            postgres    false    204            �           2606    30864    tb_beneficio tb_beneficio_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tb_beneficio
    ADD CONSTRAINT tb_beneficio_pkey PRIMARY KEY (codigo);
 H   ALTER TABLE ONLY public.tb_beneficio DROP CONSTRAINT tb_beneficio_pkey;
       public            postgres    false    205            �           2606    30869 *   tb_beneficio_valor tb_beneficio_valor_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_beneficio_valor
    ADD CONSTRAINT tb_beneficio_valor_pkey PRIMARY KEY (codigo);
 T   ALTER TABLE ONLY public.tb_beneficio_valor DROP CONSTRAINT tb_beneficio_valor_pkey;
       public            postgres    false    206            �           2606    30874 *   tb_cartao_bancario tb_cartao_bancario_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_cartao_bancario
    ADD CONSTRAINT tb_cartao_bancario_pkey PRIMARY KEY (codigo);
 T   ALTER TABLE ONLY public.tb_cartao_bancario DROP CONSTRAINT tb_cartao_bancario_pkey;
       public            postgres    false    207            �           2606    30879 >   tb_categoria_cartao_bancario tb_categoria_cartao_bancario_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.tb_categoria_cartao_bancario
    ADD CONSTRAINT tb_categoria_cartao_bancario_pkey PRIMARY KEY (codigo);
 h   ALTER TABLE ONLY public.tb_categoria_cartao_bancario DROP CONSTRAINT tb_categoria_cartao_bancario_pkey;
       public            postgres    false    208            �           2606    30887 .   tb_categoria_despesa tb_categoria_despesa_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.tb_categoria_despesa
    ADD CONSTRAINT tb_categoria_despesa_pkey PRIMARY KEY (codigo);
 X   ALTER TABLE ONLY public.tb_categoria_despesa DROP CONSTRAINT tb_categoria_despesa_pkey;
       public            postgres    false    209            �           2606    30895 2   tb_categoria_documento tb_categoria_documento_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY public.tb_categoria_documento
    ADD CONSTRAINT tb_categoria_documento_pkey PRIMARY KEY (codigo);
 \   ALTER TABLE ONLY public.tb_categoria_documento DROP CONSTRAINT tb_categoria_documento_pkey;
       public            postgres    false    210            �           2606    30900 .   tb_categoria_receita tb_categoria_receita_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.tb_categoria_receita
    ADD CONSTRAINT tb_categoria_receita_pkey PRIMARY KEY (codigo);
 X   ALTER TABLE ONLY public.tb_categoria_receita DROP CONSTRAINT tb_categoria_receita_pkey;
       public            postgres    false    211            �           2606    30908    tb_chave_pix tb_chave_pix_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tb_chave_pix
    ADD CONSTRAINT tb_chave_pix_pkey PRIMARY KEY (codigo);
 H   ALTER TABLE ONLY public.tb_chave_pix DROP CONSTRAINT tb_chave_pix_pkey;
       public            postgres    false    212            �           2606    30913    tb_cidade tb_cidade_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tb_cidade
    ADD CONSTRAINT tb_cidade_pkey PRIMARY KEY (codigo);
 B   ALTER TABLE ONLY public.tb_cidade DROP CONSTRAINT tb_cidade_pkey;
       public            postgres    false    213            �           2606    30918 0   tb_composicao_salario tb_composicao_salario_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.tb_composicao_salario
    ADD CONSTRAINT tb_composicao_salario_pkey PRIMARY KEY (codigo);
 Z   ALTER TABLE ONLY public.tb_composicao_salario DROP CONSTRAINT tb_composicao_salario_pkey;
       public            postgres    false    214            �           2606    30923 (   tb_conta_bancaria tb_conta_bancaria_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.tb_conta_bancaria
    ADD CONSTRAINT tb_conta_bancaria_pkey PRIMARY KEY (codigo);
 R   ALTER TABLE ONLY public.tb_conta_bancaria DROP CONSTRAINT tb_conta_bancaria_pkey;
       public            postgres    false    215            �           2606    30928    tb_contrato tb_contrato_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tb_contrato
    ADD CONSTRAINT tb_contrato_pkey PRIMARY KEY (codigo);
 F   ALTER TABLE ONLY public.tb_contrato DROP CONSTRAINT tb_contrato_pkey;
       public            postgres    false    216            �           2606    30936    tb_despesa tb_despesa_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tb_despesa
    ADD CONSTRAINT tb_despesa_pkey PRIMARY KEY (codigo);
 D   ALTER TABLE ONLY public.tb_despesa DROP CONSTRAINT tb_despesa_pkey;
       public            postgres    false    217            �           2606    30944    tb_documento tb_documento_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tb_documento
    ADD CONSTRAINT tb_documento_pkey PRIMARY KEY (codigo);
 H   ALTER TABLE ONLY public.tb_documento DROP CONSTRAINT tb_documento_pkey;
       public            postgres    false    218            �           2606    30949    tb_email tb_email_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tb_email
    ADD CONSTRAINT tb_email_pkey PRIMARY KEY (codigo);
 @   ALTER TABLE ONLY public.tb_email DROP CONSTRAINT tb_email_pkey;
       public            postgres    false    219            �           2606    30954    tb_endereco tb_endereco_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tb_endereco
    ADD CONSTRAINT tb_endereco_pkey PRIMARY KEY (codigo);
 F   ALTER TABLE ONLY public.tb_endereco DROP CONSTRAINT tb_endereco_pkey;
       public            postgres    false    220            �           2606    30959    tb_estado tb_estado_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tb_estado
    ADD CONSTRAINT tb_estado_pkey PRIMARY KEY (codigo);
 B   ALTER TABLE ONLY public.tb_estado DROP CONSTRAINT tb_estado_pkey;
       public            postgres    false    221            �           2606    30967 *   tb_fatura_bancaria tb_fatura_bancaria_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_fatura_bancaria
    ADD CONSTRAINT tb_fatura_bancaria_pkey PRIMARY KEY (codigo);
 T   ALTER TABLE ONLY public.tb_fatura_bancaria DROP CONSTRAINT tb_fatura_bancaria_pkey;
       public            postgres    false    222            �           2606    30977 :   tb_forma_pagamento_despesa tb_forma_pagamento_despesa_pkey 
   CONSTRAINT     |   ALTER TABLE ONLY public.tb_forma_pagamento_despesa
    ADD CONSTRAINT tb_forma_pagamento_despesa_pkey PRIMARY KEY (codigo);
 d   ALTER TABLE ONLY public.tb_forma_pagamento_despesa DROP CONSTRAINT tb_forma_pagamento_despesa_pkey;
       public            postgres    false    224            �           2606    30972 *   tb_forma_pagamento tb_forma_pagamento_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_forma_pagamento
    ADD CONSTRAINT tb_forma_pagamento_pkey PRIMARY KEY (codigo);
 T   ALTER TABLE ONLY public.tb_forma_pagamento DROP CONSTRAINT tb_forma_pagamento_pkey;
       public            postgres    false    223            �           2606    30982 8   tb_funcao_cartao_bancario tb_funcao_cartao_bancario_pkey 
   CONSTRAINT     z   ALTER TABLE ONLY public.tb_funcao_cartao_bancario
    ADD CONSTRAINT tb_funcao_cartao_bancario_pkey PRIMARY KEY (codigo);
 b   ALTER TABLE ONLY public.tb_funcao_cartao_bancario DROP CONSTRAINT tb_funcao_cartao_bancario_pkey;
       public            postgres    false    225                        2606    30987    tb_pais tb_pais_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.tb_pais
    ADD CONSTRAINT tb_pais_pkey PRIMARY KEY (codigo);
 >   ALTER TABLE ONLY public.tb_pais DROP CONSTRAINT tb_pais_pkey;
       public            postgres    false    226                       2606    30992 $   tb_parcelamento tb_parcelamento_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.tb_parcelamento
    ADD CONSTRAINT tb_parcelamento_pkey PRIMARY KEY (codigo);
 N   ALTER TABLE ONLY public.tb_parcelamento DROP CONSTRAINT tb_parcelamento_pkey;
       public            postgres    false    227                       2606    31000    tb_pessoa tb_pessoa_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tb_pessoa
    ADD CONSTRAINT tb_pessoa_pkey PRIMARY KEY (codigo);
 B   ALTER TABLE ONLY public.tb_pessoa DROP CONSTRAINT tb_pessoa_pkey;
       public            postgres    false    228            
           2606    31008 ,   tb_produto_bancario tb_produto_bancario_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.tb_produto_bancario
    ADD CONSTRAINT tb_produto_bancario_pkey PRIMARY KEY (codigo);
 V   ALTER TABLE ONLY public.tb_produto_bancario DROP CONSTRAINT tb_produto_bancario_pkey;
       public            postgres    false    229                       2606    31018 @   tb_produto_servico_ocorrencia tb_produto_servico_ocorrencia_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.tb_produto_servico_ocorrencia
    ADD CONSTRAINT tb_produto_servico_ocorrencia_pkey PRIMARY KEY (codigo);
 j   ALTER TABLE ONLY public.tb_produto_servico_ocorrencia DROP CONSTRAINT tb_produto_servico_ocorrencia_pkey;
       public            postgres    false    231                       2606    31013 *   tb_produto_servico tb_produto_servico_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_produto_servico
    ADD CONSTRAINT tb_produto_servico_pkey PRIMARY KEY (codigo);
 T   ALTER TABLE ONLY public.tb_produto_servico DROP CONSTRAINT tb_produto_servico_pkey;
       public            postgres    false    230                       2606    31026    tb_receita tb_receita_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tb_receita
    ADD CONSTRAINT tb_receita_pkey PRIMARY KEY (codigo);
 D   ALTER TABLE ONLY public.tb_receita DROP CONSTRAINT tb_receita_pkey;
       public            postgres    false    232                       2606    31031 2   tb_tipo_conta_bancaria tb_tipo_conta_bancaria_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY public.tb_tipo_conta_bancaria
    ADD CONSTRAINT tb_tipo_conta_bancaria_pkey PRIMARY KEY (codigo);
 \   ALTER TABLE ONLY public.tb_tipo_conta_bancaria DROP CONSTRAINT tb_tipo_conta_bancaria_pkey;
       public            postgres    false    233                       2606    31036 &   tb_tipo_contrato tb_tipo_contrato_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.tb_tipo_contrato
    ADD CONSTRAINT tb_tipo_contrato_pkey PRIMARY KEY (codigo);
 P   ALTER TABLE ONLY public.tb_tipo_contrato DROP CONSTRAINT tb_tipo_contrato_pkey;
       public            postgres    false    234                       2606    31041 &   tb_tipo_endereco tb_tipo_endereco_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.tb_tipo_endereco
    ADD CONSTRAINT tb_tipo_endereco_pkey PRIMARY KEY (codigo);
 P   ALTER TABLE ONLY public.tb_tipo_endereco DROP CONSTRAINT tb_tipo_endereco_pkey;
       public            postgres    false    235            "           2606    31046 "   tb_tipo_pessoa tb_tipo_pessoa_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.tb_tipo_pessoa
    ADD CONSTRAINT tb_tipo_pessoa_pkey PRIMARY KEY (codigo);
 L   ALTER TABLE ONLY public.tb_tipo_pessoa DROP CONSTRAINT tb_tipo_pessoa_pkey;
       public            postgres    false    236            (           2606    31051 &   tb_tipo_telefone tb_tipo_telefone_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.tb_tipo_telefone
    ADD CONSTRAINT tb_tipo_telefone_pkey PRIMARY KEY (codigo);
 P   ALTER TABLE ONLY public.tb_tipo_telefone DROP CONSTRAINT tb_tipo_telefone_pkey;
       public            postgres    false    237            ,           2606    31056 $   tb_tipo_usuario tb_tipo_usuario_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.tb_tipo_usuario
    ADD CONSTRAINT tb_tipo_usuario_pkey PRIMARY KEY (codigo);
 N   ALTER TABLE ONLY public.tb_tipo_usuario DROP CONSTRAINT tb_tipo_usuario_pkey;
       public            postgres    false    238            0           2606    31061 *   tb_usuario_sistema tb_usuario_sistema_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_usuario_sistema
    ADD CONSTRAINT tb_usuario_sistema_pkey PRIMARY KEY (codigo);
 T   ALTER TABLE ONLY public.tb_usuario_sistema DROP CONSTRAINT tb_usuario_sistema_pkey;
       public            postgres    false    239                       2606    31109 -   tb_tipo_contrato uk_29hln57i9awwn4jhunhed5rpj 
   CONSTRAINT     m   ALTER TABLE ONLY public.tb_tipo_contrato
    ADD CONSTRAINT uk_29hln57i9awwn4jhunhed5rpj UNIQUE (descricao);
 W   ALTER TABLE ONLY public.tb_tipo_contrato DROP CONSTRAINT uk_29hln57i9awwn4jhunhed5rpj;
       public            postgres    false    234            �           2606    31075 1   tb_categoria_despesa uk_29tcx6f5siba42y1jq3m9cthh 
   CONSTRAINT     q   ALTER TABLE ONLY public.tb_categoria_despesa
    ADD CONSTRAINT uk_29tcx6f5siba42y1jq3m9cthh UNIQUE (descricao);
 [   ALTER TABLE ONLY public.tb_categoria_despesa DROP CONSTRAINT uk_29tcx6f5siba42y1jq3m9cthh;
       public            postgres    false    209                       2606    31105 '   tb_receita uk_3irv45tdehjvsb3bii3dnarv8 
   CONSTRAINT     k   ALTER TABLE ONLY public.tb_receita
    ADD CONSTRAINT uk_3irv45tdehjvsb3bii3dnarv8 UNIQUE (identificador);
 Q   ALTER TABLE ONLY public.tb_receita DROP CONSTRAINT uk_3irv45tdehjvsb3bii3dnarv8;
       public            postgres    false    232            �           2606    31081 3   tb_categoria_documento uk_4myd3bcy6befl4fydji8b75i8 
   CONSTRAINT     o   ALTER TABLE ONLY public.tb_categoria_documento
    ADD CONSTRAINT uk_4myd3bcy6befl4fydji8b75i8 UNIQUE (sigla);
 ]   ALTER TABLE ONLY public.tb_categoria_documento DROP CONSTRAINT uk_4myd3bcy6befl4fydji8b75i8;
       public            postgres    false    210            �           2606    31087 2   tb_composicao_salario uk_5bwoo9uiww8fbm1474lsrmglc 
   CONSTRAINT     x   ALTER TABLE ONLY public.tb_composicao_salario
    ADD CONSTRAINT uk_5bwoo9uiww8fbm1474lsrmglc UNIQUE (data_referencia);
 \   ALTER TABLE ONLY public.tb_composicao_salario DROP CONSTRAINT uk_5bwoo9uiww8fbm1474lsrmglc;
       public            postgres    false    214            �           2606    31083 1   tb_categoria_receita uk_71mtn3ww5eektn5r9n2lk32v4 
   CONSTRAINT     q   ALTER TABLE ONLY public.tb_categoria_receita
    ADD CONSTRAINT uk_71mtn3ww5eektn5r9n2lk32v4 UNIQUE (descricao);
 [   ALTER TABLE ONLY public.tb_categoria_receita DROP CONSTRAINT uk_71mtn3ww5eektn5r9n2lk32v4;
       public            postgres    false    211            $           2606    31113 +   tb_tipo_pessoa uk_9ic3mrwo42v71rlbx3r2frncm 
   CONSTRAINT     k   ALTER TABLE ONLY public.tb_tipo_pessoa
    ADD CONSTRAINT uk_9ic3mrwo42v71rlbx3r2frncm UNIQUE (descricao);
 U   ALTER TABLE ONLY public.tb_tipo_pessoa DROP CONSTRAINT uk_9ic3mrwo42v71rlbx3r2frncm;
       public            postgres    false    236            �           2606    31079 3   tb_categoria_documento uk_9q75bweb4fgvwq5kgc3nkyl4n 
   CONSTRAINT     s   ALTER TABLE ONLY public.tb_categoria_documento
    ADD CONSTRAINT uk_9q75bweb4fgvwq5kgc3nkyl4n UNIQUE (descricao);
 ]   ALTER TABLE ONLY public.tb_categoria_documento DROP CONSTRAINT uk_9q75bweb4fgvwq5kgc3nkyl4n;
       public            postgres    false    210                       2606    31103 /   tb_produto_servico uk_a3daxqydfs794q2sln8qvgs87 
   CONSTRAINT     o   ALTER TABLE ONLY public.tb_produto_servico
    ADD CONSTRAINT uk_a3daxqydfs794q2sln8qvgs87 UNIQUE (descricao);
 Y   ALTER TABLE ONLY public.tb_produto_servico DROP CONSTRAINT uk_a3daxqydfs794q2sln8qvgs87;
       public            postgres    false    230            �           2606    31097 /   tb_forma_pagamento uk_agp349q6rhc1aalys2lryw8vy 
   CONSTRAINT     k   ALTER TABLE ONLY public.tb_forma_pagamento
    ADD CONSTRAINT uk_agp349q6rhc1aalys2lryw8vy UNIQUE (sigla);
 Y   ALTER TABLE ONLY public.tb_forma_pagamento DROP CONSTRAINT uk_agp349q6rhc1aalys2lryw8vy;
       public            postgres    false    223                       2606    31107 3   tb_tipo_conta_bancaria uk_b3chfforxyjkltoljwd615qys 
   CONSTRAINT     s   ALTER TABLE ONLY public.tb_tipo_conta_bancaria
    ADD CONSTRAINT uk_b3chfforxyjkltoljwd615qys UNIQUE (descricao);
 ]   ALTER TABLE ONLY public.tb_tipo_conta_bancaria DROP CONSTRAINT uk_b3chfforxyjkltoljwd615qys;
       public            postgres    false    233            �           2606    31067 )   tb_beneficio uk_bwa0hvmxrku9odg3f2abodpg2 
   CONSTRAINT     e   ALTER TABLE ONLY public.tb_beneficio
    ADD CONSTRAINT uk_bwa0hvmxrku9odg3f2abodpg2 UNIQUE (sigla);
 S   ALTER TABLE ONLY public.tb_beneficio DROP CONSTRAINT uk_bwa0hvmxrku9odg3f2abodpg2;
       public            postgres    false    205            �           2606    31063 8   tb_bandeira_cartao_bancario uk_c8o38qud7spf0itme3842lx7p 
   CONSTRAINT     x   ALTER TABLE ONLY public.tb_bandeira_cartao_bancario
    ADD CONSTRAINT uk_c8o38qud7spf0itme3842lx7p UNIQUE (descricao);
 b   ALTER TABLE ONLY public.tb_bandeira_cartao_bancario DROP CONSTRAINT uk_c8o38qud7spf0itme3842lx7p;
       public            postgres    false    204            �           2606    31093 &   tb_estado uk_c8vrqbb3yo4ylo3m7tyxw7hen 
   CONSTRAINT     a   ALTER TABLE ONLY public.tb_estado
    ADD CONSTRAINT uk_c8vrqbb3yo4ylo3m7tyxw7hen UNIQUE (nome);
 P   ALTER TABLE ONLY public.tb_estado DROP CONSTRAINT uk_c8vrqbb3yo4ylo3m7tyxw7hen;
       public            postgres    false    221            �           2606    31073 9   tb_categoria_cartao_bancario uk_cgtb69shm7ohhfgknf5a62omy 
   CONSTRAINT     y   ALTER TABLE ONLY public.tb_categoria_cartao_bancario
    ADD CONSTRAINT uk_cgtb69shm7ohhfgknf5a62omy UNIQUE (descricao);
 c   ALTER TABLE ONLY public.tb_categoria_cartao_bancario DROP CONSTRAINT uk_cgtb69shm7ohhfgknf5a62omy;
       public            postgres    false    208                       2606    31099 $   tb_pais uk_cgu82g5joibpude01kknp93uc 
   CONSTRAINT     _   ALTER TABLE ONLY public.tb_pais
    ADD CONSTRAINT uk_cgu82g5joibpude01kknp93uc UNIQUE (nome);
 N   ALTER TABLE ONLY public.tb_pais DROP CONSTRAINT uk_cgu82g5joibpude01kknp93uc;
       public            postgres    false    226            �           2606    31069 /   tb_cartao_bancario uk_cun4oa1km6ltc5dnc6sruj34f 
   CONSTRAINT     o   ALTER TABLE ONLY public.tb_cartao_bancario
    ADD CONSTRAINT uk_cun4oa1km6ltc5dnc6sruj34f UNIQUE (descricao);
 Y   ALTER TABLE ONLY public.tb_cartao_bancario DROP CONSTRAINT uk_cun4oa1km6ltc5dnc6sruj34f;
       public            postgres    false    207            �           2606    31065 )   tb_beneficio uk_ef13mkvug234m1wjeqt80nihb 
   CONSTRAINT     i   ALTER TABLE ONLY public.tb_beneficio
    ADD CONSTRAINT uk_ef13mkvug234m1wjeqt80nihb UNIQUE (descricao);
 S   ALTER TABLE ONLY public.tb_beneficio DROP CONSTRAINT uk_ef13mkvug234m1wjeqt80nihb;
       public            postgres    false    205            2           2606    31121 /   tb_usuario_sistema uk_exxvkhwhbo723b7n9onejuc6d 
   CONSTRAINT     s   ALTER TABLE ONLY public.tb_usuario_sistema
    ADD CONSTRAINT uk_exxvkhwhbo723b7n9onejuc6d UNIQUE (identificador);
 Y   ALTER TABLE ONLY public.tb_usuario_sistema DROP CONSTRAINT uk_exxvkhwhbo723b7n9onejuc6d;
       public            postgres    false    239            �           2606    31091 (   tb_contrato uk_f6f4ebjy4ptnixwaxefrnr0ee 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_contrato
    ADD CONSTRAINT uk_f6f4ebjy4ptnixwaxefrnr0ee UNIQUE (identificador);
 R   ALTER TABLE ONLY public.tb_contrato DROP CONSTRAINT uk_f6f4ebjy4ptnixwaxefrnr0ee;
       public            postgres    false    216            �           2606    31095 /   tb_forma_pagamento uk_ghrb2uniamosq6usqbyb9qnnf 
   CONSTRAINT     o   ALTER TABLE ONLY public.tb_forma_pagamento
    ADD CONSTRAINT uk_ghrb2uniamosq6usqbyb9qnnf UNIQUE (descricao);
 Y   ALTER TABLE ONLY public.tb_forma_pagamento DROP CONSTRAINT uk_ghrb2uniamosq6usqbyb9qnnf;
       public            postgres    false    223                       2606    31101 &   tb_pessoa uk_gi38cv4u55byat7g2xkb60bdr 
   CONSTRAINT     a   ALTER TABLE ONLY public.tb_pessoa
    ADD CONSTRAINT uk_gi38cv4u55byat7g2xkb60bdr UNIQUE (nome);
 P   ALTER TABLE ONLY public.tb_pessoa DROP CONSTRAINT uk_gi38cv4u55byat7g2xkb60bdr;
       public            postgres    false    228            �           2606    31077 0   tb_categoria_despesa uk_l1jcswgyl0eq9nnhx7ya78vi 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_categoria_despesa
    ADD CONSTRAINT uk_l1jcswgyl0eq9nnhx7ya78vi UNIQUE (sigla);
 Z   ALTER TABLE ONLY public.tb_categoria_despesa DROP CONSTRAINT uk_l1jcswgyl0eq9nnhx7ya78vi;
       public            postgres    false    209            �           2606    31085 )   tb_chave_pix uk_lyubq7q43n7j1fualgrkaygc4 
   CONSTRAINT     i   ALTER TABLE ONLY public.tb_chave_pix
    ADD CONSTRAINT uk_lyubq7q43n7j1fualgrkaygc4 UNIQUE (chave_pix);
 S   ALTER TABLE ONLY public.tb_chave_pix DROP CONSTRAINT uk_lyubq7q43n7j1fualgrkaygc4;
       public            postgres    false    212            �           2606    31071 /   tb_cartao_bancario uk_nxtui53simu9n0yf3a91gc4g0 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_cartao_bancario
    ADD CONSTRAINT uk_nxtui53simu9n0yf3a91gc4g0 UNIQUE (numero);
 Y   ALTER TABLE ONLY public.tb_cartao_bancario DROP CONSTRAINT uk_nxtui53simu9n0yf3a91gc4g0;
       public            postgres    false    207            &           2606    31115 +   tb_tipo_pessoa uk_o0dtid8pcgpwpavsfrpykbuwh 
   CONSTRAINT     g   ALTER TABLE ONLY public.tb_tipo_pessoa
    ADD CONSTRAINT uk_o0dtid8pcgpwpavsfrpykbuwh UNIQUE (sigla);
 U   ALTER TABLE ONLY public.tb_tipo_pessoa DROP CONSTRAINT uk_o0dtid8pcgpwpavsfrpykbuwh;
       public            postgres    false    236            .           2606    31119 ,   tb_tipo_usuario uk_ok40t1j4gm3fxsxbd4k9ixi6a 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_tipo_usuario
    ADD CONSTRAINT uk_ok40t1j4gm3fxsxbd4k9ixi6a UNIQUE (descricao);
 V   ALTER TABLE ONLY public.tb_tipo_usuario DROP CONSTRAINT uk_ok40t1j4gm3fxsxbd4k9ixi6a;
       public            postgres    false    238            �           2606    31089 .   tb_conta_bancaria uk_p8dx5fq4cbsj6qbq78r12lg1e 
   CONSTRAINT     s   ALTER TABLE ONLY public.tb_conta_bancaria
    ADD CONSTRAINT uk_p8dx5fq4cbsj6qbq78r12lg1e UNIQUE (numero_agencia);
 X   ALTER TABLE ONLY public.tb_conta_bancaria DROP CONSTRAINT uk_p8dx5fq4cbsj6qbq78r12lg1e;
       public            postgres    false    215                        2606    31111 -   tb_tipo_endereco uk_ro491n72tx7jstyt3so91eig0 
   CONSTRAINT     m   ALTER TABLE ONLY public.tb_tipo_endereco
    ADD CONSTRAINT uk_ro491n72tx7jstyt3so91eig0 UNIQUE (descricao);
 W   ALTER TABLE ONLY public.tb_tipo_endereco DROP CONSTRAINT uk_ro491n72tx7jstyt3so91eig0;
       public            postgres    false    235            *           2606    31117 ,   tb_tipo_telefone uk_v1ba7v5t2yu2ujvh5tt4ei02 
   CONSTRAINT     l   ALTER TABLE ONLY public.tb_tipo_telefone
    ADD CONSTRAINT uk_v1ba7v5t2yu2ujvh5tt4ei02 UNIQUE (descricao);
 V   ALTER TABLE ONLY public.tb_tipo_telefone DROP CONSTRAINT uk_v1ba7v5t2yu2ujvh5tt4ei02;
       public            postgres    false    237            9           2606    31152 %   tb_cidade fk12tfv6wlsvaml7nsmq106hvib    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_cidade
    ADD CONSTRAINT fk12tfv6wlsvaml7nsmq106hvib FOREIGN KEY (id_estado) REFERENCES public.tb_estado(codigo);
 O   ALTER TABLE ONLY public.tb_cidade DROP CONSTRAINT fk12tfv6wlsvaml7nsmq106hvib;
       public          postgres    false    213    221    3056            Z           2606    31317 .   tb_usuario_sistema fk1jon08upe9a66eyjqcv5c11kc    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_usuario_sistema
    ADD CONSTRAINT fk1jon08upe9a66eyjqcv5c11kc FOREIGN KEY (id_tipo_usuario_sistema) REFERENCES public.tb_tipo_usuario(codigo);
 X   ALTER TABLE ONLY public.tb_usuario_sistema DROP CONSTRAINT fk1jon08upe9a66eyjqcv5c11kc;
       public          postgres    false    3116    238    239            E           2606    31212 '   tb_endereco fk1wlvil0y56h89uki97895gl5o    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_endereco
    ADD CONSTRAINT fk1wlvil0y56h89uki97895gl5o FOREIGN KEY (id_cidade) REFERENCES public.tb_cidade(codigo);
 Q   ALTER TABLE ONLY public.tb_endereco DROP CONSTRAINT fk1wlvil0y56h89uki97895gl5o;
       public          postgres    false    220    213    3034            D           2606    31207 $   tb_email fk228rm1lwu3gle9oas5611l06g    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_email
    ADD CONSTRAINT fk228rm1lwu3gle9oas5611l06g FOREIGN KEY (id_pessoa) REFERENCES public.tb_pessoa(codigo);
 N   ALTER TABLE ONLY public.tb_email DROP CONSTRAINT fk228rm1lwu3gle9oas5611l06g;
       public          postgres    false    219    228    3078            U           2606    31292 &   tb_receita fk3h70cci4ad686fmltmrd9wwua    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_receita
    ADD CONSTRAINT fk3h70cci4ad686fmltmrd9wwua FOREIGN KEY (id_categoria_receita) REFERENCES public.tb_categoria_receita(codigo);
 P   ALTER TABLE ONLY public.tb_receita DROP CONSTRAINT fk3h70cci4ad686fmltmrd9wwua;
       public          postgres    false    211    232    3026            R           2606    31277 .   tb_produto_servico fk4kpj5xjvsfsih4btfls6r3ome    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_produto_servico
    ADD CONSTRAINT fk4kpj5xjvsfsih4btfls6r3ome FOREIGN KEY (id_despesa) REFERENCES public.tb_despesa(codigo);
 X   ALTER TABLE ONLY public.tb_produto_servico DROP CONSTRAINT fk4kpj5xjvsfsih4btfls6r3ome;
       public          postgres    false    217    230    3048            >           2606    31177 '   tb_contrato fk5butay4i4eeowxxdrwvvjtckw    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_contrato
    ADD CONSTRAINT fk5butay4i4eeowxxdrwvvjtckw FOREIGN KEY (id_pessoa_contratante) REFERENCES public.tb_pessoa(codigo);
 Q   ALTER TABLE ONLY public.tb_contrato DROP CONSTRAINT fk5butay4i4eeowxxdrwvvjtckw;
       public          postgres    false    216    228    3078            X           2606    31307 &   tb_receita fk5lcivrnwltpuk794ib9aawdra    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_receita
    ADD CONSTRAINT fk5lcivrnwltpuk794ib9aawdra FOREIGN KEY (tipo_forma_pagamento) REFERENCES public.tb_forma_pagamento(codigo);
 P   ALTER TABLE ONLY public.tb_receita DROP CONSTRAINT fk5lcivrnwltpuk794ib9aawdra;
       public          postgres    false    232    223    3062            J           2606    31237 6   tb_forma_pagamento_despesa fk66r988hw2r6v7saxep57yilil    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_forma_pagamento_despesa
    ADD CONSTRAINT fk66r988hw2r6v7saxep57yilil FOREIGN KEY (id_despesa) REFERENCES public.tb_despesa(codigo);
 `   ALTER TABLE ONLY public.tb_forma_pagamento_despesa DROP CONSTRAINT fk66r988hw2r6v7saxep57yilil;
       public          postgres    false    217    3048    224            @           2606    31187 &   tb_despesa fk6ksq5x0lih19njxcnjflw75r8    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_despesa
    ADD CONSTRAINT fk6ksq5x0lih19njxcnjflw75r8 FOREIGN KEY (id_categoria_despesa) REFERENCES public.tb_categoria_despesa(codigo);
 P   ALTER TABLE ONLY public.tb_despesa DROP CONSTRAINT fk6ksq5x0lih19njxcnjflw75r8;
       public          postgres    false    209    217    3014            L           2606    31247 6   tb_forma_pagamento_despesa fk7gdav8i2xxfd07as3h5mno8uv    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_forma_pagamento_despesa
    ADD CONSTRAINT fk7gdav8i2xxfd07as3h5mno8uv FOREIGN KEY (id_pessoa_pagamento) REFERENCES public.tb_pessoa(codigo);
 `   ALTER TABLE ONLY public.tb_forma_pagamento_despesa DROP CONSTRAINT fk7gdav8i2xxfd07as3h5mno8uv;
       public          postgres    false    228    224    3078            P           2606    31267 /   tb_produto_bancario fk86kgyavk6unf72xp6jdrd2erg    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_produto_bancario
    ADD CONSTRAINT fk86kgyavk6unf72xp6jdrd2erg FOREIGN KEY (id_conta_bancaria) REFERENCES public.tb_conta_bancaria(codigo);
 Y   ALTER TABLE ONLY public.tb_produto_bancario DROP CONSTRAINT fk86kgyavk6unf72xp6jdrd2erg;
       public          postgres    false    229    3040    215            5           2606    31132 .   tb_cartao_bancario fk9ifx63fa40g984l0afnj28s9a    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_cartao_bancario
    ADD CONSTRAINT fk9ifx63fa40g984l0afnj28s9a FOREIGN KEY (id_bandeira_cartao_bancario) REFERENCES public.tb_bandeira_cartao_bancario(codigo);
 X   ALTER TABLE ONLY public.tb_cartao_bancario DROP CONSTRAINT fk9ifx63fa40g984l0afnj28s9a;
       public          postgres    false    207    204    2992            8           2606    31147 (   tb_chave_pix fk9mhvkgp45fu4kpxbbv140hai8    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_chave_pix
    ADD CONSTRAINT fk9mhvkgp45fu4kpxbbv140hai8 FOREIGN KEY (id_contrato) REFERENCES public.tb_contrato(codigo);
 R   ALTER TABLE ONLY public.tb_chave_pix DROP CONSTRAINT fk9mhvkgp45fu4kpxbbv140hai8;
       public          postgres    false    212    216    3044            <           2606    31167 -   tb_conta_bancaria fkb28dwv4gc45lfot928s9k53t3    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_conta_bancaria
    ADD CONSTRAINT fkb28dwv4gc45lfot928s9k53t3 FOREIGN KEY (id_pessoa_instituicao_financeira) REFERENCES public.tb_pessoa(codigo);
 W   ALTER TABLE ONLY public.tb_conta_bancaria DROP CONSTRAINT fkb28dwv4gc45lfot928s9k53t3;
       public          postgres    false    215    228    3078            6           2606    31137 .   tb_cartao_bancario fkbdq4niutb1xm0l0sg45x4fqsk    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_cartao_bancario
    ADD CONSTRAINT fkbdq4niutb1xm0l0sg45x4fqsk FOREIGN KEY (id_categoria_cartao_bancario) REFERENCES public.tb_categoria_cartao_bancario(codigo);
 X   ALTER TABLE ONLY public.tb_cartao_bancario DROP CONSTRAINT fkbdq4niutb1xm0l0sg45x4fqsk;
       public          postgres    false    207    208    3010            I           2606    31232 .   tb_fatura_bancaria fkcte9kf2meabssclrfw2xf4lrj    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_fatura_bancaria
    ADD CONSTRAINT fkcte9kf2meabssclrfw2xf4lrj FOREIGN KEY (id_cartao_bancario) REFERENCES public.tb_cartao_bancario(codigo);
 X   ALTER TABLE ONLY public.tb_fatura_bancaria DROP CONSTRAINT fkcte9kf2meabssclrfw2xf4lrj;
       public          postgres    false    207    222    3004            7           2606    31142 .   tb_cartao_bancario fkcv0r2j9dlcf6qb2d1vn06dy4w    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_cartao_bancario
    ADD CONSTRAINT fkcv0r2j9dlcf6qb2d1vn06dy4w FOREIGN KEY (id_conta_bancaria) REFERENCES public.tb_conta_bancaria(codigo);
 X   ALTER TABLE ONLY public.tb_cartao_bancario DROP CONSTRAINT fkcv0r2j9dlcf6qb2d1vn06dy4w;
       public          postgres    false    207    215    3040            K           2606    31242 6   tb_forma_pagamento_despesa fkd1ndvtw86wpi16vwf8qaxe3op    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_forma_pagamento_despesa
    ADD CONSTRAINT fkd1ndvtw86wpi16vwf8qaxe3op FOREIGN KEY (id_forma_pagamento) REFERENCES public.tb_forma_pagamento(codigo);
 `   ALTER TABLE ONLY public.tb_forma_pagamento_despesa DROP CONSTRAINT fkd1ndvtw86wpi16vwf8qaxe3op;
       public          postgres    false    223    224    3062            C           2606    31202 (   tb_documento fkdo5x9yvwhu6sy0ox97fnhmo9k    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_documento
    ADD CONSTRAINT fkdo5x9yvwhu6sy0ox97fnhmo9k FOREIGN KEY (id_pessoa) REFERENCES public.tb_pessoa(codigo);
 R   ALTER TABLE ONLY public.tb_documento DROP CONSTRAINT fkdo5x9yvwhu6sy0ox97fnhmo9k;
       public          postgres    false    218    228    3078            S           2606    31282 .   tb_produto_servico fkdr0m14doqnwojcgfpoq8vagbk    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_produto_servico
    ADD CONSTRAINT fkdr0m14doqnwojcgfpoq8vagbk FOREIGN KEY (id_fatura_bancaria) REFERENCES public.tb_fatura_bancaria(codigo);
 X   ALTER TABLE ONLY public.tb_produto_servico DROP CONSTRAINT fkdr0m14doqnwojcgfpoq8vagbk;
       public          postgres    false    230    222    3060            ;           2606    31162 -   tb_conta_bancaria fke6dbt0a2gh5fgaqs4payuxrgr    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_conta_bancaria
    ADD CONSTRAINT fke6dbt0a2gh5fgaqs4payuxrgr FOREIGN KEY (id_contrato) REFERENCES public.tb_contrato(codigo);
 W   ALTER TABLE ONLY public.tb_conta_bancaria DROP CONSTRAINT fke6dbt0a2gh5fgaqs4payuxrgr;
       public          postgres    false    215    216    3044            G           2606    31222 &   tb_endereco fkfbi768m2wdpm91iu4sbfgvga    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_endereco
    ADD CONSTRAINT fkfbi768m2wdpm91iu4sbfgvga FOREIGN KEY (id_tipo_endereco) REFERENCES public.tb_tipo_endereco(codigo);
 P   ALTER TABLE ONLY public.tb_endereco DROP CONSTRAINT fkfbi768m2wdpm91iu4sbfgvga;
       public          postgres    false    220    235    3102            H           2606    31227 %   tb_estado fkgnjyqe6lj745wsrrcbqh97f6m    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_estado
    ADD CONSTRAINT fkgnjyqe6lj745wsrrcbqh97f6m FOREIGN KEY (id_pais) REFERENCES public.tb_pais(codigo);
 O   ALTER TABLE ONLY public.tb_estado DROP CONSTRAINT fkgnjyqe6lj745wsrrcbqh97f6m;
       public          postgres    false    221    226    3072            =           2606    31172 '   tb_contrato fkgu72xspmpeuohott0ye31euwt    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_contrato
    ADD CONSTRAINT fkgu72xspmpeuohott0ye31euwt FOREIGN KEY (id_pessoa_contratado) REFERENCES public.tb_pessoa(codigo);
 Q   ALTER TABLE ONLY public.tb_contrato DROP CONSTRAINT fkgu72xspmpeuohott0ye31euwt;
       public          postgres    false    216    228    3078            A           2606    31192 &   tb_despesa fkihdwpbm6nyjqkmvesvl8o8y65    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_despesa
    ADD CONSTRAINT fkihdwpbm6nyjqkmvesvl8o8y65 FOREIGN KEY (id_pessoa_favorecido) REFERENCES public.tb_pessoa(codigo);
 P   ALTER TABLE ONLY public.tb_despesa DROP CONSTRAINT fkihdwpbm6nyjqkmvesvl8o8y65;
       public          postgres    false    217    228    3078            4           2606    31127 .   tb_beneficio_valor fkjuapkivdbcoour83t4h7dngo4    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_beneficio_valor
    ADD CONSTRAINT fkjuapkivdbcoour83t4h7dngo4 FOREIGN KEY (id_composicao_salario) REFERENCES public.tb_composicao_salario(codigo);
 X   ALTER TABLE ONLY public.tb_beneficio_valor DROP CONSTRAINT fkjuapkivdbcoour83t4h7dngo4;
       public          postgres    false    206    214    3036            B           2606    31197 (   tb_documento fkjxgov7ek6hy790br5hrgdp0lw    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_documento
    ADD CONSTRAINT fkjxgov7ek6hy790br5hrgdp0lw FOREIGN KEY (id_categoria_documento) REFERENCES public.tb_categoria_documento(codigo);
 R   ALTER TABLE ONLY public.tb_documento DROP CONSTRAINT fkjxgov7ek6hy790br5hrgdp0lw;
       public          postgres    false    218    210    3020            3           2606    31122 .   tb_beneficio_valor fkk32p0qf15my8j89pr9grtyb88    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_beneficio_valor
    ADD CONSTRAINT fkk32p0qf15my8j89pr9grtyb88 FOREIGN KEY (id_beneficio) REFERENCES public.tb_beneficio(codigo);
 X   ALTER TABLE ONLY public.tb_beneficio_valor DROP CONSTRAINT fkk32p0qf15my8j89pr9grtyb88;
       public          postgres    false    205    206    2996            V           2606    31297 &   tb_receita fkkshydstlh2tqo1toxkshcfelc    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_receita
    ADD CONSTRAINT fkkshydstlh2tqo1toxkshcfelc FOREIGN KEY (id_conta_bancaria_deposito) REFERENCES public.tb_conta_bancaria(codigo);
 P   ALTER TABLE ONLY public.tb_receita DROP CONSTRAINT fkkshydstlh2tqo1toxkshcfelc;
       public          postgres    false    232    215    3040            Y           2606    31312 .   tb_usuario_sistema fkl9wmregm12jcjedk5vvmn0dk8    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_usuario_sistema
    ADD CONSTRAINT fkl9wmregm12jcjedk5vvmn0dk8 FOREIGN KEY (id_pessoa) REFERENCES public.tb_pessoa(codigo);
 X   ALTER TABLE ONLY public.tb_usuario_sistema DROP CONSTRAINT fkl9wmregm12jcjedk5vvmn0dk8;
       public          postgres    false    3078    228    239            Q           2606    31272 /   tb_produto_bancario fklfnhypp28x9cs2a4fle21dfgo    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_produto_bancario
    ADD CONSTRAINT fklfnhypp28x9cs2a4fle21dfgo FOREIGN KEY (id_tipo_conta_bancaria) REFERENCES public.tb_tipo_conta_bancaria(codigo);
 Y   ALTER TABLE ONLY public.tb_produto_bancario DROP CONSTRAINT fklfnhypp28x9cs2a4fle21dfgo;
       public          postgres    false    3094    233    229            F           2606    31217 &   tb_endereco fklulmoqiwd20dykrxhyfxvo9r    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_endereco
    ADD CONSTRAINT fklulmoqiwd20dykrxhyfxvo9r FOREIGN KEY (id_pessoa) REFERENCES public.tb_pessoa(codigo);
 P   ALTER TABLE ONLY public.tb_endereco DROP CONSTRAINT fklulmoqiwd20dykrxhyfxvo9r;
       public          postgres    false    220    228    3078            N           2606    31257 +   tb_parcelamento fkmw0r3k8awug9jai52lyh2y8j2    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_parcelamento
    ADD CONSTRAINT fkmw0r3k8awug9jai52lyh2y8j2 FOREIGN KEY (id_despesa) REFERENCES public.tb_despesa(codigo);
 U   ALTER TABLE ONLY public.tb_parcelamento DROP CONSTRAINT fkmw0r3k8awug9jai52lyh2y8j2;
       public          postgres    false    217    227    3048            O           2606    31262 %   tb_pessoa fknfjlv78bjlb5ywtbyplv0vhd1    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_pessoa
    ADD CONSTRAINT fknfjlv78bjlb5ywtbyplv0vhd1 FOREIGN KEY (id_tipo_pessoa) REFERENCES public.tb_tipo_pessoa(codigo);
 O   ALTER TABLE ONLY public.tb_pessoa DROP CONSTRAINT fknfjlv78bjlb5ywtbyplv0vhd1;
       public          postgres    false    3106    228    236            :           2606    31157 -   tb_conta_bancaria fko2wqw1ypr435l4wqs6wdymg3x    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_conta_bancaria
    ADD CONSTRAINT fko2wqw1ypr435l4wqs6wdymg3x FOREIGN KEY (id_cidade_agencia_bancaria) REFERENCES public.tb_cidade(codigo);
 W   ALTER TABLE ONLY public.tb_conta_bancaria DROP CONSTRAINT fko2wqw1ypr435l4wqs6wdymg3x;
       public          postgres    false    215    213    3034            T           2606    31287 9   tb_produto_servico_ocorrencia fkobte3bt0r05jovxiypvo0fa5q    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_produto_servico_ocorrencia
    ADD CONSTRAINT fkobte3bt0r05jovxiypvo0fa5q FOREIGN KEY (id_produto_servico) REFERENCES public.tb_produto_servico(codigo);
 c   ALTER TABLE ONLY public.tb_produto_servico_ocorrencia DROP CONSTRAINT fkobte3bt0r05jovxiypvo0fa5q;
       public          postgres    false    3084    230    231            ?           2606    31182 '   tb_contrato fkrtjjs991fq7fdwx68ivi2mwk5    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_contrato
    ADD CONSTRAINT fkrtjjs991fq7fdwx68ivi2mwk5 FOREIGN KEY (id_tipo_contrato) REFERENCES public.tb_tipo_contrato(codigo);
 Q   ALTER TABLE ONLY public.tb_contrato DROP CONSTRAINT fkrtjjs991fq7fdwx68ivi2mwk5;
       public          postgres    false    3098    234    216            W           2606    31302 &   tb_receita fks3iquxuc15d3r02diw71t3iyg    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_receita
    ADD CONSTRAINT fks3iquxuc15d3r02diw71t3iyg FOREIGN KEY (id_responsavel_pagamento) REFERENCES public.tb_pessoa(codigo);
 P   ALTER TABLE ONLY public.tb_receita DROP CONSTRAINT fks3iquxuc15d3r02diw71t3iyg;
       public          postgres    false    228    3078    232            M           2606    31252 5   tb_funcao_cartao_bancario fktpt3gm335x50uacixp0eir5j5    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_funcao_cartao_bancario
    ADD CONSTRAINT fktpt3gm335x50uacixp0eir5j5 FOREIGN KEY (id_cartao_bancario) REFERENCES public.tb_cartao_bancario(codigo);
 _   ALTER TABLE ONLY public.tb_funcao_cartao_bancario DROP CONSTRAINT fktpt3gm335x50uacixp0eir5j5;
       public          postgres    false    207    3004    225            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �   1   x�3�tI-.H-NTpˬH�tq��2��%e^X���������� p�      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �   c   x��̱
�0���/J.�Z��*D�~���-N���%�ݳ%���i��ü�}K��JeK���!�#-�	A����S� [/���'�'a����(����'=      �   E   x�34�4202�50�54���tA<ddf "�9-��,��dhh�eh�ebD�6#S�e��\1z\\\ �<�      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �   -  x�}�1n�0��Y�K
��dy,����c���q`S"�-�?x�����A(���m���E���"G�V���W�u�	�#�D�#�/Io�#Y>�np|'db]�B�����1e��F-�����N�wjhեДj�[�i�-����Vc�e	 S�u�K��^�i��ҼWcӼWcy�K[�W,�|<n7<�~��c��=N��Ë�,8y�Z���W����`r�����ч	�F<7��L<gO�R<����x��=;^����|������;7������W��&#      �   �   x�u�1
�@E��SL1VZ*PAS��1$30��J�<A.�*�N>����_�让��Kd�6M��!6jP���Ħ3W�\��I���J��~�q|�/
�mw_x���D�����H&!�}8*Ԑ��'��n[m��(���ת���7�XB*      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �   f   x�3�t��+)J,�WHIUN-*�<�<����+I-�K-QpˬH�2#B����e�9\�(J���3/?�8_��׼�̔D��FPjNfzf~q�&W� R�3p      �      x������ � �      �   .   x�3�H-.�OTp;��839�3���&�UZtxm
Xԋ+F��� ��      �      x������ � �      �   (   x�34�tt���	rt��w��s�sv������� ���      �   (   x�34�LI-N�+��)��M�+��,���44����� ��     