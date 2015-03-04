package br.com.jcourse.test;

import br.com.jcourse.entities.Customer;
import br.com.jcourse.jdbc.CustomerDAO;

public class TesteUsuarioDAO {
	public static void main(String[] args){
		Customer evandro = new Customer();
		evandro.setName("Evandro Machado");
		evandro.setLogin("Evandro");
		evandro.setPassword("123456");
		
		CustomerDAO customerDAO = new CustomerDAO();
		
		customerDAO.create(evandro);
		System.out.println("Cadastrado com sucesso!");
		
	}
}
