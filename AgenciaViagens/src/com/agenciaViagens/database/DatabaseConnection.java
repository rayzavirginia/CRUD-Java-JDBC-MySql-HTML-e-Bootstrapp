package com.agenciaViagens.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	//nome do usuário do mySQL
	private static final String USERNAME = "root";
	
	//senha do banco
	private static final String PASSWORD = "root";
	
	//caminho do banco de dados, porta e nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/AgenciaViagens";
	
	//conexão com banco de dados
	public static Connection createConnectionToMySQL() throws Exception {
		//Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//cria conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		//Recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//testar se a conexão é nula
		if(con!=null) {
			System.out.println("Conexão obtida com sucesso!");
			con.close();
		}
	}
}
