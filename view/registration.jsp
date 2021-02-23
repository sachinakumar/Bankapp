<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration page</title>
</head>
<body>
<h2>Register Here</h2><br>
 <form:form action="register" modelAttribute="reg" method="post">
		<label>Name :</label>
		<form:input path="name" /><br>
		<label>Email :</label>
		<form:input path="email" />
		<label>Phone :</label>
		<form:input path="phone" />
		<label>User id :</label>
		<form:input path="userid" />
		<label>Password :</label>
		<form:input path="password" />
		<input type="submit" value="Register" />
	</form:form> 
<!-- <form action="/BankApp_Hiber_Spring_sachin/home">
Name:<input type="text" name="name"><br><br>
Address:<input type="text" name="address"><br><br>
Mobile no:<input type="text" name="phone"><br><br>
<input type="submit" value="Register">


</form> -->

</body>
</html>