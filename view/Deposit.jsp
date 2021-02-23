<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <form:form action="deposit" modelAttribute="depo" >
		<label>user id :</label>
		<form:input path="userId" /><br>
		<label>amount :</label>
		<form:input path="amount" />
		<input type="submit" value="Deposit" />
	</form:form> 
	<%-- <form action="deposit" method="post">
		Account id:<input type="text" name="userId"><br>
		<br> Amount:<input type="text" name="amount"><br>
		<br> <input type="submit" value="Deposit" />
		</form> --%>
</body>
</html>