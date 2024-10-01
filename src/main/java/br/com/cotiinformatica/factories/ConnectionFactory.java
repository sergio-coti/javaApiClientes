package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	/*
	 * Método para criar e retornar uma conexão
	 * com o banco de dados do MySQL
	 */
	public Connection getConnection() {
		
		try {
			
			var host = "jdbc:mysql://localhost:3306/bdApiClientes";
			var user = "root";
			var pass = "coti";
			
			return DriverManager.getConnection(host, user, pass);
		}
		catch(Exception e) {
			//imprimir o log do erro no console do servidor
			e.printStackTrace();
			return null;
		}
	}
}
