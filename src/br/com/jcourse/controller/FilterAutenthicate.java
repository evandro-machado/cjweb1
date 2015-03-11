package br.com.jcourse.controller;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterAutenthicate
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/*" })
public class FilterAutenthicate implements Filter {

    /**
     * Default constructor. 
     */
    public FilterAutenthicate() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//Casting HttpServletRequest
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String url =httpServletRequest.getRequestURI();
		
		
		//Is logged in?
		HttpSession session = httpServletRequest.getSession();
		
		if(session.getAttribute("custLogged") != null 
				|| url.lastIndexOf("login.html")>-1 
				|| url.lastIndexOf("authcontroller.do")>-1){
			
			chain.doFilter(request, response);//Let request flow			
		}else{
			//redirect to Log in page
			((HttpServletResponse) response).sendRedirect("login.html");
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
