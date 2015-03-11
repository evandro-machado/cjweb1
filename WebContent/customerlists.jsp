<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.jcourse.entities.Customer" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listing with JSTL</title>
</head>
<body>
	<table border="1">
		<tr bgcolor="EAEAEA">
			<th>ID</th><th>Name</th><th>Login</th><th>Password</th><th>Ação</th>
		</tr>
		
		<c:forEach items="${requestScope.list }" var="customer">
		<tr>
			<td>${customer.id }</td>
			<td>${customer.name }</td>
			<td>${customer.login }</td>
			<td>${customer.password }</td>
			<td>
				<a href="usercontroller.do?action=rem&id=${customer.id }"> Delete </a>
				<a href="usercontroller.do?action=alt&id=${customer.id }">Alter</a>
			</td>
		</tr>
		</c:forEach>
	</table>
 
</body>
</html>