package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/novoapp";
	public static final String USER = "root";
	public static final String PASS = "";

	public static java.sql.Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			throw new RuntimeException("Erro na conexão com o banco de dados", e);
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet result) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", e);
		}
	}
	
	public static void closeConnection(Connection connection, PreparedStatement statement) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (connection != null) {
				statement.close();
			}
			if (statement != null) {
				statement.close();
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", e);
		}
	}
	

}
