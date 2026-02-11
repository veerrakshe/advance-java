<%@page import="com.Model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Successful</title>
</head>
<body>
	<h1>Login Successfull!!!</h1>

	<%
	       List<Employee> list = (List<Employee>)request.getAttribute("msg");
	    %>


	<table border="1">

		<thead>
			<tr>
				<th>Employee id</th>
				<th>Employee address</th>
				<th>Employee age</th>
				<th>Employee email</th>
				<th>Employee name</th>
				<th>Employee password</th>

			</tr>


		</thead>


		<tbody>
			<%for(Employee emp:list){ %>

			<tr>

				<td><%=emp.getEid() %></td>
				<td><%=emp.getAddress() %></td>
				<td><%=emp.getAge() %></td>
				<td><%=emp.getEmail()%></td>
				<td><%=emp.getName() %></td>
				<td><%=emp.getPassword() %></td>	
			</tr>
			
			<%} %>



		</tbody>
	</table>
</body>
</html>