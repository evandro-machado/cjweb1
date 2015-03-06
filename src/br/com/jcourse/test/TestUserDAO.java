package br.com.jcourse.test;

import java.util.List;

import br.com.jcourse.entities.Customer;
import br.com.jcourse.jdbc.CustomerDAO;

public class TestUserDAO {
	public static void main(String[] args){
		//testCreateCustomer();
		//testUpdateCustomer();
		//testDeleteCustomer();
		testReadAll();
		//testReadById();
		//testReadByName();
	}

	private static void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Bruno Sella");
		customer.setLogin("Bruno");
		customer.setPassword("america");
		
		CustomerDAO customerDAO = new CustomerDAO();
		
		customerDAO.create(customer);
	}
	
	private static void testUpdateCustomer() {
		Customer customer = new Customer();
		customer.setId(5);
		customer.setName("João José");
		customer.setLogin("Zebedé");
		customer.setPassword("123456");
		
		CustomerDAO customerDAO = new CustomerDAO();
		
		customerDAO.update(customer);
	}
	
	private static void testDeleteCustomer() {
		Customer customer = new Customer();
		customer.setId(2);
		CustomerDAO customerDAO = new CustomerDAO();
		
		customerDAO.delete(customer);
	}
	
	private static void testReadAll() {
		CustomerDAO customerDAO = new CustomerDAO();
		List<Customer> result = customerDAO.readAll();
		for(Customer customer: result){
			System.out.println("ID: "+customer.getId());
			System.out.println("Name: "+customer.getName());
			System.out.println("Login: "+customer.getLogin());
			System.out.println("Password: "+customer.getPassword());
		}
	}
	
	private static void testReadById() {
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.readById(10);
		if(customer!= null){
			System.out.println("ID: "+customer.getId());
			System.out.println("Name: "+customer.getName());
			System.out.println("Login: "+customer.getLogin());
			System.out.println("Password: "+customer.getPassword());
		}else{
			System.out.println("Customer not found.");
		}
	}
	
	private static void testReadByName() {
		CustomerDAO customerDAO = new CustomerDAO();
		List<Customer> result = customerDAO.readByName("n");
		for(Customer customer: result){
			System.out.println("ID: "+customer.getId());
			System.out.println("Name: "+customer.getName());
			System.out.println("Login: "+customer.getLogin());
			System.out.println("Password: "+customer.getPassword());
		}
	}
}
