<jsp:include page="navigation.jsp" />
<div id="content">
	<p id="title">
		Enter you new password
	</p>
	<div align="center">
		<jsp:include page="error-list.jsp" />
	</div>
	<form method="POST" action="change-pwd.do">
		<table border=0 style="width:250px;border-color:#FFFFFF;" align="center">
			<tr>
				<td class="item">New Password:</td>
				<td><input name="newPassword" size="25" type="password" /></td>
			</tr>
			<tr>
				<td class="item">Confirm New Password:</td>
				<td><input name="confirmedPassword" size="25" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<input type="submit" name="button" id="button" style="width:140px" value="Change Password"/>
					</div>
				</td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="template-bottom.jsp" />