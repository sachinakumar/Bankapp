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
<form:form action="transfer" modelAttribute="trans" method="post" >
		<label>from userid :</label>
		<form:input path="from_Account" /><br>
		<label>to userid :</label>
		<form:input path="to_Account" /><br>
		<label>amount :</label>
		<form:input path="amount" />
		<input type="submit" value="Transfer" />
	</form:form> 

</body>
</html>