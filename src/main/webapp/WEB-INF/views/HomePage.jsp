<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page </title>
<STYLE TYPE="text/css">
<!--
TD{font-family: Arial; font-size: 20pt;}
--->
</STYLE>

</head>
<body>

<center><font  size= 10, face="Broadway" color="RED">Home Page</font></center>
<hr>
<table align="center" border="3" bordercolor="green">
<tr>
	<td>New User</td>
	<td>
		<c:url value="register" var="registerUrl"></c:url>
		<a href="${registerUrl}">Register here</a>	
	</td>
</tr>

<tr>
	<td>Registered Users</td>
	<td>
		<c:url value="login" var="loginUrl"></c:url>
		<a href="${loginUrl}" >Login</a>	
	</td>
</tr>


</table></body>
</html>