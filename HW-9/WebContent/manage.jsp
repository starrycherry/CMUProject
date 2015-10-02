<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="navigation.jsp" />
<div id="content">
	<p id="title">
	Add a new favorite URL:
	</p>
	<div align="center">
		<jsp:include page="error-list.jsp" />
	</div>
	<form method="post" action="add.do">
		<table align="center" style="width:250px;border-color:#FFFFFF;">
			<tr>
				<td class="item">URL:</td>
				<td><input name="url" size="25" type="txt" value="${form.url}" /></td>
			</tr>
			<tr>
				<td class="item">Comment:</td>
				<td class="item"><input name="comment" size="25" type="txt" />(Optional)</td>
			</tr>
			<tr>
			<td colspan="2">
				<div align="center">
					<input type="submit" name="button" id="button" style="width:120px" value="Add Favorite"/>
				</div>
			</td>
		</tr>
		</table>
	</form>
	<table style="width:250px;" align="center">
		<c:forEach var="favorite" items="${favoriteList}">
			<tr>
				<td>
					<form method="POST" action="remove.do">
						<div>
							<input type="hidden" name="id" value="${favorite.favoriteID}" />
							<input type="hidden" name="source" value="r" />
							<input type="submit" value="X" id="button" style="width:20px;height:19px"/>
						</div>
					</form>
				</td>
				<td>
					<div><a href="click.do?id=${favorite.favoriteID }&source=m" onClick="javascript:window.open('http://${favorite.url}','_blank')">${favorite.url}</a></div>
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