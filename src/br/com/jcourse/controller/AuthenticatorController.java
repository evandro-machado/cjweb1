package br.com.jcourse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jcourse.entities.Customer;
import br.com.jcourse.jdbc.CustomerDAO;

/**
 * Servlet implementation class AuthenticatorController
 */
@WebServlet("/authcontroller.do")
public class AuthenticatorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticatorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.invalidate();	
		}
		
		response.sendRedirect("login.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Customer customer = new Customer();
		customer.setLogin(login);
		customer.setPassword(password);
		
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customerReturn = customerDAO.authenticate(customer);
		if(customerReturn != null){
			//Creating Session
			HttpSession session = request.getSession();
			session.setAttribute("custLogged", customerReturn);
			
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			response.sendRedirect("login.html");
		
		}
		
		
	}

}
