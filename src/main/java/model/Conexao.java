package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	Connection con = null;

	public Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection( "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC", "root", "admin");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public Connection getConnection() {
		return this.con;
	}
	
	public void closeConnection() {
		try {
			this.con.close();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
	}
	
}
