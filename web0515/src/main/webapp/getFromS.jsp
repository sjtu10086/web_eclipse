<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p> getfroms </p>
	<% String value1 = (String)request.getAttribute("acc"); %>
	<% Object value2 = request.getAttribute("mypass"); %>
	<% out.print(value1); %>
	<% out.print(value2); %>
	<a href="http://localhost:8080/web0515/ccc.jsp">ccc	</a>
</body>
</html>