package br.com.jcourse.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.jcourse.entities.Customer;

public class CustomerDAO {
	private Connection con = DBConnection.getConnect();
	
	public void create(Customer customer){
		String sql = "insert into customer (customername, customerpassword, customerlogin) values (?, ?, ?)";
		try{
			PreparedStatement prp = con.prepareStatement(sql);
			prp.setString(1, customer.getName());
			prp.setString(2, customer.getLogin());
			prp.setString(3, customer.getPassword());
			
			prp.execute(); 
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
}
