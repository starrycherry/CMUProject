<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<title>Favorite Website</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
	<div class="container">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="70%"><img src="favorite-logo1.png"></td>

				<td align="right" id="header"><c:choose>
						<c:when test="${empty user }">
							<p>
								Welcome Visitor | <a href="login.do">Login </a>| <a
									href="register.do">Register</a>
							</p>
						</c:when>
						<c:otherwise>
							<p>
								Welcome ${user.firstName } ${user.lastName } | <a
									href="logout.do">Logout</a>
							</p>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</div>
	<div class="container">
		<table width="100%" border="0" cellspacing="3" cellpadding="0">
			<tr>
				<td valign="top" width="25%" height="450px" id="navigation"><c:choose>
						<c:when test="${(not empty user)}">
							<h3>${user.firstName} ${user.lastName}</h3>
							<ul class="top-level">
								<li><a href="manage.do">Manage You Favorites</a></li>
								<li><a href="change-pwd.do">Change Your Password</a></li>
								<li><a href="logout.do">Logout</a></li>
							</ul>
						</c:when>
					</c:choose>
					<h3>Favorites From:</h3>
					<ul class="top-level">
						<c:forEach var="u" items="${userList}">
							<li><a href="list.do?id=${u.userID}">${u.firstName}
									${u.lastName}</a></li>
						</c:forEach>
					</ul></td>
				<td valign="top" width="75%">