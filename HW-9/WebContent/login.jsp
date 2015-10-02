<jsp:include page="navigation.jsp" />
<div id="content">
		<p id="title">
			Please login below or click <a href="register.do">here</a> to register as a new user.
		</p>
	<div align="center">
		<jsp:include page="error-list.jsp" />
	</div>
	<form method="POST" action="login.do">
		<table style="width:250px;border-color:#C75BC5;" align="center">
			<tr>
				<td class="item">E-mail Address:</td>
				<td><input name="emailAdd" size="25" type="txt" value="${form.emailAdd}" /></td>
			</tr>
			<tr>
				<td class="item">Password:</td>
				<td><input name="password" size="25" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<input type="submit" name="button" id="button" value="Log in"/>
					</div>
				</td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="template-bottom.jsp" />