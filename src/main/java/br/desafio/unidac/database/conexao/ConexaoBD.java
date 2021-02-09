package br.desafio.unidac.database.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBD {
	
	private static Connection connection = null;

	public static Connection getConnection() { // Metodo que cria a conexao com o banco de dados Postgres.

		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/unidac";
		String user = "postgres";
		String password = "007123";

		try {

			if (connection == null) {

				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
				System.out.println("Conexão realizada com sucesso!");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Não foi possível carregar o driver " + e.getMessage());

		} catch (SQLException sqle) {
			System.out.println("Não foi possável criar conexão! " + sqle.getMessage());
		}

		return connection;
	}

	public static void closeConnection(Connection connection) {

		try {
			if (connection != null) {
				connection.close();
				System.out.println("Conexao fechada com o BD.");
			} else
				System.out.println("Nao foi possivel encerrar --> A conexao n�o foi iniciada.");

		} catch (SQLException e) {
			System.out.println("Nao foi possivel fechar a conexao com BD! " + e.getMessage());
		}
	}

	// 2 FECHA O CONNECTION E PREPAREDSTATEMENT
	public static void closeConnection(Connection connection, PreparedStatement statement) {

		closeConnection(connection);

		try {
			if (statement != null)
				statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3 FECHA O CONNECTION, PREPAREDSTATEMENT E RESULTSET
	public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {

		closeConnection(connection, statement);

		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
