package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			System.out.println("Procurando o driver...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver encontrado com sucesso!");
		} catch (ClassNotFoundException ex) {
			System.err.println("O driver n�o foi encontrado.");
		}
	}
	
	public static Connection conectar() {
		try {
			return DriverManager
					.getConnection("jdbc:mysql://localhost/portal_realnews?useTimezone=true&serverTimezone=UTC", 
							"root", "admin");
		} catch (SQLException ex) {
			System.err.println("Nao foi possivel conectar!");
			ex.printStackTrace();
			return null;
		}
	}
	
}