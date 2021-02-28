-- DROP SCHEMA if exists public CASCADE;
-- CREATE SCHEMA if not exists  public;
-- DROP TABLE IF EXISTS flyway_schema_history;

-- RECUPERAR TABELAS DO BANCO DE DADOS CORRENTE
SELECT table_schema, LOWER(table_name) FROM information_schema.TABLES WHERE table_schema LIKE 'public' ORDER BY table_schema,table_name;

-- RECUPERAR TABELAS
SELECT concat('SELECT * FROM ', UPPER(table_name), ';') AS SELECT_TABLE_ FROM information_schema.TABLES WHERE table_schema LIKE 'public' ORDER BY table_schema,table_name;

-- RECUPERAR TODAS AS SEQUENCIAS
SELECT RELNAME SEQUENCE_NAME FROM PG_CLASS WHERE RELKIND = 'S';