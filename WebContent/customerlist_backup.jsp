
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.jcourse.entities.Customer" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr bgcolor="EAEAEA">
			<th>ID</th><th>Name</th><th>Login</th><th>Password</th><th>Ação</th>
		</tr>
		<%
		//Scriptlet
		request.setCharacterEncoding("UTF-8");
		List<Customer> list = (List<Customer>) request.getAttribute("list");
		
		for(Customer customer : list){		
		%>
		
		<tr>
			<td><%= customer.getId() %></td>
			<td><% out.print(customer.getName());%></td>
			<td><%= customer.getLogin() %></td>
			<td><%= customer.getPassword() %></td>
			<td><a href="usercontroller.do?action=rem&id=<%= customer.getId() %>">Remove</a>
				<a href="usercontroller.do?action=alt&id=<%= customer.getId() %>">Alter</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>