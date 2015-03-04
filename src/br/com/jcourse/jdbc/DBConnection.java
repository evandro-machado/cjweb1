package br.com.jcourse.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnect(){
		Connection con = null;
		String adress = "jdbc:postgresql://localhost:5432/cjweb1";
		String userName = "postgres";
		String password = "root";
		try{
			con = DriverManager.getConnection(adress, userName, password);
			System.out.println("Connection successful.");
		} catch (SQLException e){
			System.out.println("Não pode conectar, erro:"+e.getMessage());
		}
		return con;
		
	}
	

}

