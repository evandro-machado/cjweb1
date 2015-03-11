package br.com.jcourse.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import br.com.jcourse.entities.Customer;

public class CustomerDAO {
	private Connection con = DBConnection.getConnect();
	
	public void create(Customer customer){
		String sql = "insert into customer (customername, customerlogin, customerpassword) values (?, ?, ?)";
		try{
			PreparedStatement prp = con.prepareStatement(sql);
			prp.setString(1, customer.getName());
			prp.setString(2, customer.getLogin());
			prp.setString(3, customer.getPassword());
			
			prp.execute(); 
			System.out.println("Successifully created!");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void update(Customer customer){
		String sql = "update customer set customername=?, customerlogin=?, customerpassword=? where customerid=?";
		try{
			PreparedStatement prp = con.prepareStatement(sql);
			prp.setString(1, customer.getName());
			prp.setString(2, customer.getLogin());
			prp.setString(3, customer.getPassword());
			prp.setInt(4, customer.getId());
			
			prp.execute(); 
			System.out.println("Successifully altered!");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void save(Customer customer) throws IOException{
		if(customer.getId() != null && customer.getId() != 0){
			update(customer);

		}else{
			create(customer);
		}
		
	}
	
	public void delete(Customer customer){
		String sql = "delete from customer where customerid=?";
		try{
			PreparedStatement prp = con.prepareStatement(sql);
			prp.setInt(1, customer.getId());
			
			prp.execute(); 
			System.out.println("Successifully deleted!");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public List<Customer> readAll(){
		String sql = "select * from customer";
		List customerList = new ArrayList();
		try{
			PreparedStatement prp = con.prepareStatement(sql);
			ResultSet result = prp.executeQuery(); 
			while(result.next()){
				Customer customer = new Customer();
				customer.setId(result.getInt("customerid"));
				customer.setName(result.getString("customername"));
				customer.setLogin(result.getString("customerlogin"));
				customer.setPassword(result.getString("customerpassword"));
				customerList.add(customer);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return customerList;
	}
	
	public Customer readById(Integer id){
		String sql = "select * from customer where customerid = ?";
		Customer customer = null;
		try{
			PreparedStatement prp = con.prepareStatement(sql);
			prp.setInt(1,id);
			ResultSet result = prp.executeQuery(); 
			
			if(result.next()){
				customer = new Customer();
				customer.setId(result.getInt("customerid"));
				customer.setName(result.getString("customername"));
				customer.setLogin(result.getString("customerlogin"));
				customer.setPassword(result.getString("customerpassword"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return customer;
	}
	
	
	public List<Customer> readByName(String name){
		String sql = "select * from customer where customername like ?";
		List customerList = new ArrayList();
		try{
			PreparedStatement prp = con.prepareStatement(sql);
			prp.setString(1, "%"+name+"%");
			ResultSet result = prp.executeQuery(); 
		
			while(result.next()){
				Customer customer = new Customer();
				customer.setId(result.getInt("customerid"));
				customer.setName(result.getString("customername"));
				customer.setLogin(result.getString("customerlogin"));
				customer.setPassword(result.getString("customerpassword"));
				customerList.add(customer);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return customerList;
	}
	
	public Customer authenticate(Customer customer){
		String sql = "select * from customer where customerlogin = ? and customerpassword = ?";
		
		Customer customerReturn = null;
		try{
			PreparedStatement prp = con.prepareStatement(sql);
			prp.setString(1, customer.getLogin());
			prp.setString(2, customer.getPassword());
			ResultSet result = prp.executeQuery();
			
			if(result.next()){
				customerReturn = new Customer();
				customerReturn.setId(result.getInt("customerid"));
				customerReturn.setName(result.getString("customername"));
				customerReturn.setLogin(result.getString("customerlogin"));
				customerReturn.setPassword(result.getString("customerpassword"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return customerReturn;
	}
	
}
