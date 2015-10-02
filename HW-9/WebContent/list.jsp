<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="navigation.jsp" />
<div id="content">
	<table align="center">
		<c:forEach var="favorite" items="${favoriteList }">
			<tr>
				<td>
					<div><a href="click.do?id=${favorite.favoriteID }&source=l" onClick="javascript:window.open('http://${favorite.url}','_blank')">${favorite.url}</a></div>
					<c:choose>
						<c:when test="${(not empty favorite.comment) }">
							<div>${favorite.comment}</div>
						</c:when>
					</c:choose>
					<div>${favorite.clickCount}</div>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page="template-bottom.jsp" />