package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection conexao;
	public static String user = "root";
	public static String password = "1010";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver Mysql não encontrado!");
		}
	}

	public static Connection obtemConexao() {
		try {

			conexao = DriverManager
					.getConnection("jdbc:mysql://localhost/sistemapredial?user=" + user + "&password=" + password);
		} catch (SQLException e) {
			throw new RuntimeException("Usuario e Senha Mysql incorreto!");
		}
		return conexao;

	}

}
