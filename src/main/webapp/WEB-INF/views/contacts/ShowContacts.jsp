<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Contacts Page</title>
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
 <c:url value="/contacts/UserHome" var="home"/>
 <a href="${home}">Contact Home</a>

 <font color="CRIMSON"style="float:right;">${loggedUser.userName}</font>
 <font color="CRIMSON"style="float:right;">Welcome :</font> 
 
</p>
<hr>

<center>
<font color="DARKRED "style="float:center;font-size:20pt  "> Users Registered Are</font>

<table border="1" bordercolor="BLUE">
	<c:choose>
		<c:when test="${empty listOfContacts}">Contact List is Empty</c:when>
		<c:otherwise>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Contact Number</th>
			</tr>
			
			<c:forEach items="${listOfContacts}" var="contact">
				<tr>
				<td>${contact.contactId}</td>
				<td>${contact.contactName}</td>
				<td>${contact.contactNumber}</td>
			</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
</center>

</body>
</html>