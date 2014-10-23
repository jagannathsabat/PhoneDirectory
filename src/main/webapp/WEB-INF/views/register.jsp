<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>

<STYLE TYPE="text/css">
<!--
TD{font-family: Arial; font-size: 20pt;}
A{font-family: Arial; font-size: 20pt;}
--->
</STYLE>

</head>
<body>
	
	<c:url value="/" var="home"/>
	<a href="${home}" style="float:left;">Home</a>
	<center><font  size= 6, face="Arial" color="RED">Registration</font></center>
	<hr>
		
	<center>
	<table>
	<form:form method="post" modelAttribute="loginDTO">
		
			
			<tr>
				<td>Full Name</td>
				<td><form:input path="userName"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="userPassword"/></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><form:input path="mobileNumber"/></td>
			</tr>
			<tr>
				<td>Register</td>
				<td><input type="submit" value="Register" size="40"/></td>
			</tr>
		
		
	</form:form>
</table>
</center>
</body>
</html>