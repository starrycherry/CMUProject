<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${(not empty errors) }"> 
		<div id="errors" align="left">
		  	<c:forEach var="error" items="${errors}">
				<div > ${error} </div>
			</c:forEach>
			
		</div>
	 </c:when>
</c:choose> 



