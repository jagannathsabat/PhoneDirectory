<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%-- <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>success</title>
</head>
<body>
<h3><font class="TIMES NEW ROMAN" color="RED">Welcome : ${userDetails.userName}</font> </h3>
<hr>

Success Page
${userDetails}
<hr>
<c:url value="/" var="home"/>
<a href="${home}">home</a>
</body>
</html> --%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>success</title>

<STYLE>
<!--
TD{font-family: Arial; font-size: 20pt; color: GREEN}
TH{font-family: Arial; font-size: 16pt; color: MAGENTA}
P{font-family: Arial; font-size: 20pt;}
--->
</STYLE>

</head>
<body>
<p>
 <c:url value="/" var="home"/>
 <a href="${home}">Home</a>

 <font color="CRIMSON"style="float:right;">${userDetails.userName}</font>
 <font color="CRIMSON"style="float:right;">Welcome :</font> 
 
</p>
<hr>

<center>
<font color="DARKRED "style="float:center;font-size:20pt  "> Users Registered Are</font>

<table border="1" bordercolor="BLUE">
	<c:choose>
		<c:when test="${empty listofcontact}">
			<p>Contact List is Empty</p>
		</c:when>
		<c:otherwise>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Phone Number</th>
			</tr>
			
			<c:forEach items="${listofcontact}" var="user">
				<tr>
				<td>${user.id}</td>
				<td>${user.userName}</td>
				<td>${user.mobileNumber}</td>
			</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
</center>

<table align="center" border="3" bordercolor="green">

<tr>
	<td>Add Contact</td>
	<td>
		<c:url value="contacts/addContact" var="addContactUrl"></c:url>
		<a href="${addContact}">Add Contact</a>	
	</td>
</tr>

<tr>
	<td>Modify Contact</td>
	<td>
		<c:url value="contacts/modifyContact" var="modifyContactUrl"></c:url>
		<a href="${modifyContact}">Modify Contact</a>	
	</td>
</tr>
<tr>
	<td>Delete Contact</td>
	<td>
		<c:url value="contacts/deleteContact" var="deleteContactUrl"></c:url>
		<a href="${deleteContact}">Delete Contact</a>	
	</td>
</tr>

</table>

</body>
</html>