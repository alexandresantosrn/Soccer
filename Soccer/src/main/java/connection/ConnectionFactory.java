package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql123456";

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
			return null;
		}
	}
}
