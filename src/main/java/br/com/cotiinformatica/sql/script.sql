#criando o banco de dados
CREATE DATABASE bdApiClientes;

#acessando o banco de dados
USE bdApiClientes;

#criando a tabela de clientes no banco de dados
CREATE TABLE cliente(
	id				CHAR(36)		PRIMARY KEY,
	nome			VARCHAR(150)	NOT NULL,
	email			VARCHAR(100)	NOT NULL,
	telefone		VARCHAR(15)		NOT NULL,
	datacadastro	TIMESTAMP		DEFAULT CURRENT_TIMESTAMP
);

#visualizar a estrutura da tabela
DESC cliente;