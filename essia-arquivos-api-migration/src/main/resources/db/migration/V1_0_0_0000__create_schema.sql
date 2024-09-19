-- SCHEMAS
CREATE SCHEMA IF NOT EXISTS arquivo_virtual;

-- TABLES
CREATE TABLE IF NOT EXISTS arquivo_virtual.diretorio
(
    id_diretorio           int8         not null,
    nome_diretorio         varchar(255) not null,
    criado_em              timestamp    not null,
    ultima_modificacao_em  timestamp    not null,
    ativo                  boolean      not null default true,
    id_diretorio_pai       int8,
    primary key (id_diretorio)
    );

CREATE TABLE IF NOT EXISTS arquivo_virtual.arquivo
(
    id_arquivo              int8         not null,
    nome_arquivo            varchar(255) not null,
    criado_em               timestamp    not null,
    ultima_modificacao_em   timestamp    not null,
    ativo                   boolean      not null default true,
    id_diretorio            int8,
    primary key (id_diretorio),
    CONSTRAINT fk_id_diretorio FOREIGN KEY (id_diretorio) REFERENCES arquivo_virtual.diretorio (id_diretorio)
    );

-- SEQUENCES
create sequence IF NOT EXISTS arquivo_virtual.seq_arquivo_id start 1 increment 1;

create sequence IF NOT EXISTS arquivo_virtual.seq_diretorio_id start 1 increment 1;