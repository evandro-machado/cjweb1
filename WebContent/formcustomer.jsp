<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.jcourse.entities.Customer" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Using JSTL</title>
</head>
<body>
<c:import url="includes/menu.jsp"></c:import>

<form action="usercontroller.do?action=lis" method="post" >
			<label>ID: </label>
			<input type="text" name="txtid" readonly="readonly" value="${requestScope.customer.id }"/>
			<label>Name: </label>
			<input type="text" name="txtname" value="${requestScope.customer.name }" />
			<label>Login: </label>
			<input type="text" name="txtlogin" value="${requestScope.customer.login }" />
			<label>Password: </label>
			<input type="password" name="txtpassword" value="${requestScope.customer.password }" maxlength="6" />
			<input type="submit" value="Save"/>
		</form>
</body>
</html>