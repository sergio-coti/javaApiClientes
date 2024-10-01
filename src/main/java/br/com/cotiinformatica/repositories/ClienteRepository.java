package br.com.cotiinformatica.repositories;

import java.util.UUID;

import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ClienteRepository {

	/*
	 * Método para inserir um cliente no banco de dados
	 */
	public void create(Cliente cliente) {
		
		try {
			
			//abrindo conexão com o banco de dados
			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();
			
			//escrever um comando SQL para gravar um cliente na tabela
			var statement = connection.prepareStatement("INSERT INTO cliente(id, nome, email, telefone) VALUES(?,?,?,?)");
			statement.setString(1, cliente.getId().toString());
			statement.setString(2, cliente.getNome());
			statement.setString(3, cliente.getEmail());
			statement.setString(4, cliente.getTelefone());
			statement.execute(); //executar o comando SQL
			
			connection.close(); //fechando a conexão com o banco de dados
		}
		catch(Exception e) {
			//imprimir um log do erro
			e.printStackTrace();
		}
	}
	
	/*
	 * Método para atualizar os dados de um cliente
	 */
	public void update(Cliente cliente) {
		
		try {
			
			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();
			
			var statement = connection.prepareStatement("UPDATE cliente SET nome=?, email=?, telefone=? WHERE id=?");
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getEmail());
			statement.setString(3, cliente.getTelefone());
			statement.setString(4, cliente.getId().toString());
			statement.execute();
			
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	/*
	 * Método para excluir um cliente no banco de dados
	 */
	public void delete(UUID id) {
		
		try {
			
			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();
			
			var statement = connection.prepareStatement("DELETE FROM cliente WHERE id=?");
			statement.setString(1, id.toString());
			statement.execute();
			
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}




