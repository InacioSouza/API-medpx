CREATE TABLE
    medicos (
        id BIGSERIAL PRIMARY KEY,
        nome VARCHAR(100) NOT NULL,
        email VARCHAR(100) NOT NULL UNIQUE,
        crm VARCHAR(6) NOT NULL UNIQUE,
        especialidade VARCHAR(100) NOT NULL,
        logradouro VARCHAR(100) NOT NULL,
        bairro VARCHAR(100) NOT NULL,
        cep VARCHAR(9) NOT NULL,
        complemento VARCHAR(100),
        numero VARCHAR(20) NOT NULL,
        uf CHAR(2) NOT NULL,
        cidade VARCHAR(100) NOT NULL,
        telefone VARCHAR(20) NOT NULL,
        ativo BOOLEAN DEFAULT TRUE
    );

CREATE TABLE
    pacientes (
        id BIGSERIAL PRIMARY KEY,
        nome VARCHAR(100) NOT NULL,
        email VARCHAR(100) NOT NULL UNIQUE,
        cpf VARCHAR(14) NOT NULL UNIQUE,
        logradouro VARCHAR(100) NOT NULL,
        bairro VARCHAR(100) NOT NULL,
        cep VARCHAR(9) NOT NULL,
        complemento VARCHAR(100),
        numero VARCHAR(20) NOT NULL,
        uf CHAR(2) NOT NULL,
        cidade VARCHAR(100) NOT NULL,
        telefone VARCHAR(20) NOT NULL,
        ativo BOOLEAN NOT NULL
    );

CREATE TABLE
    usuarios (
        id BIGSERIAL PRIMARY KEY,
        login VARCHAR(100) NOT NULL,
        senha VARCHAR(255) NOT NULL
    );

CREATE TABLE
    consultas (
        id BIGSERIAL PRIMARY KEY,
        medico_id BIGINT NOT NULL,
        paciente_id BIGINT NOT NULL,
        data TIMESTAMP NOT NULL,
        motivo_cancelamento VARCHAR(100),
        CONSTRAINT fk_consultas_medico_id FOREIGN KEY (medico_id) REFERENCES medicos (id),
        CONSTRAINT fk_consultas_paciente_id FOREIGN KEY (paciente_id) REFERENCES pacientes (id)
    );