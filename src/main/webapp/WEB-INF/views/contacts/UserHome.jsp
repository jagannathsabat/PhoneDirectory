<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts UserHome</title>
<STYLE TYPE="text/css">
<!--
TD{font-family: Arial; font-size: 20pt;}
--->
</STYLE>

</head>
<body>

<center><font  size= 10, face="Broadway" color="RED">Home Page</font></center>
<hr>
<%@ include file="../template/menubar.jsp" %>
<table align="center" border="3" bordercolor="green">

<tr>
	<td>Add Contact</td>
	<td>
		<c:url value="/showContactView" var="showContactUrl"></c:url>
		<a href="${showContactUrl}">Show Contact</a>	
	</td>
</tr>

<tr>
	<td>Add Contact</td>
	<td>
		<c:url value="/addContactView" var="addContactUrl"></c:url>
		<a href="${addContactUrl}">Add Contact</a>	
	</td>
</tr>

<tr>
	<td>Modify Contact</td>
	<td>
		<c:url value="/modifyContactView" var="modifyContactUrl"></c:url>
		<a href="${modifyContactUrl}">Modify Contact</a>	
	</td>
</tr>
<tr>
	<td>Delete Contact</td>
	<td>
		<c:url value="/deleteContactView" var="deleteContactUrl"></c:url>
		<a href="${deleteContactUrl}">Delete Contact</a>	
	</td>
</tr>

</table>
</body>
</html>