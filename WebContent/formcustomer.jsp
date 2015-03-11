
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.jcourse.entities.Customer" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
request.setCharacterEncoding("UTF-8");
Customer customer = (Customer) request.getAttribute("customer");
%>
<form action="usercontroller.do?action=lis" method="post" >
		<label>ID: </label>
		<input type="text" name="txtid" readonly="readonly" value="<%=customer.getId()%>"/>
		<label>Name: </label>
		<input type="text" name="txtname" value="<%= customer.getName() %>" />
		<label>Login: </label>
		<input type="text" name="txtlogin" value="<%= customer.getLogin() %>" />
		<label>Password: </label>
		<input type="password" name="txtpassword" value="<%= customer.getPassword() %>" maxlength="6" />
		<input type="submit" value="Save"/>
		</form>
</body>
</html>