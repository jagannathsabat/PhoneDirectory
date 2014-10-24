<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:choose>
	<c:when test="${sessionScope.loggedUser ne null}">
		logged as: ${sessionScope.loggedUser.userName}
		<ul>
			<li><a href="#">Logout</a></li>			
			<li><a href="${rootUrl}/contacts/UserHome" style="float:left;">Home</a></li>
		</ul>	
	</c:when>
	<c:otherwise>
		<ul>
			<li>
				<a href="${rootUrl}" style="float:left;">Home</a>
			</li>
			<li>				
				<a href="${rootUrl}/register">Register here</a>
			</li>		
			<li>
				<a href="${rootUrl}/login" >Login</a>
			</li>
		</ul>		
	</c:otherwise>
</c:choose>
<hr/>