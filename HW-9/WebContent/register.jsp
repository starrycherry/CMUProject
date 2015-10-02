<jsp:include page="navigation.jsp" />
<div id="content">
	<p id="title">
		To register, enter the following information. (All fields required.) 
	</p>
	<div align="center">
		<jsp:include page="error-list.jsp" />
	</div>
	<form method="POST" action="register.do">
		<table border=0 style="width:250px;border-color:#FFFFFF;" align="center">
			<tr>
				<td class="item">E-mail Address:</td>
				<td><input name="emailAdd" size="25" type="txt" value="${form.emailAdd}" /></td>
			</tr>
			<tr>
				<td class="item">FirstName:</td>
				<td><input name="firstName" size="25" type="txt" value="${form.firstName}" /></td>
			</tr>
			<tr>
				<td class="item">LastName:</td>
				<td><input name="lastName" size="25" type="txt" value="${form.lastName}" /></td>
			</tr>
			<tr>
				<td class="item">Password:</td>
				<td><input name="password" size="25" type="password" /></td>
			</tr>
			<tr>
				<td class="item">Confirm Password:</td>
				<td><input name="confirmedPassword" size="25" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<input type="submit" name="button" id="button" value="Register"/>
					</div>
				</td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="template-bottom.jsp" />