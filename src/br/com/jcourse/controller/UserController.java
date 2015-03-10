package br.com.jcourse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jcourse.entities.Customer;
import br.com.jcourse.jdbc.CustomerDAO;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/usercontroller.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("Calling for get method.");
		
		//1st - Geting the list
		CustomerDAO customerDAO = new CustomerDAO();
		List<Customer> list = customerDAO.readAll();
		
		//2nd - Setting request attribute
		request.setAttribute("list", list);
		
		//Forwarding to JSP
		RequestDispatcher out = request.getRequestDispatcher("customerlist.jsp");
		out.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String idStr = request.getParameter("txtid");
		String name = request.getParameter("txtname");
		String login = request.getParameter("txtlogin");
		String password = request.getParameter("txtpassword");
		
		Customer customer = new Customer();
		customer.setName(name);
		customer.setLogin(login);
		customer.setPassword(password);
		
		System.out.println(name);
		
		if(idStr != ""){
			customer.setId(Integer.parseInt(idStr));
		}
		
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.save(customer);
		
		PrintWriter output = response.getWriter();
		output.println("Customer registered!");
	}

}
