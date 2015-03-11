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
		
		String action = request.getParameter("action");
		
		CustomerDAO customerDAO = new CustomerDAO();
		
		if(action!=null && action.equals("rem")){

			Customer customer = new Customer();
			int id = Integer.parseInt(request.getParameter("id"));
			customer.setId(id);
			customerDAO.delete(customer);
			response.sendRedirect("usercontroller.do?action=lis");
		}
		if(action!=null && action.equals("alt")){
			int id = Integer.parseInt(request.getParameter("id"));
			Customer customer = customerDAO.readById(id);
			request.setAttribute("customer", customer);
			RequestDispatcher output = request.getRequestDispatcher("formcustomer.jsp");
			output.forward(request, response);
		}
			
		
		if(action!=null && action.equals("lis")){		
			//1st - Geting the list
	
			List<Customer> list = customerDAO.readAll();
			
			//2nd - Setting request attribute
			request.setAttribute("list", list);
			
			//Forwarding to JSP
			RequestDispatcher out = request.getRequestDispatcher("customerlists.jsp");
			out.forward(request, response);
		}
		
		if(action!=null && action.equals("sgn")){
			Customer customer = new Customer();
			customer.setId(0);
			customer.setName("");
			customer.setLogin("");
			customer.setPassword("");
			
			request.setAttribute("customer", customer);
			RequestDispatcher out = request.getRequestDispatcher("formcustomer.jsp");
			out.forward(request,response);
		}
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
		
	}

}
