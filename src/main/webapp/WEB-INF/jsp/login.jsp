<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>

<body>


	<div>
		<h1>Login</h1>
		<!--       			commandName="user" -->
		<form:form method="POST" action="login" modelAttribute="credential">

			<table style="with: 80%">
				
				<tr>
					<td>User Name:</td>
					<td><form:input path="name" />
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" />
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login"></td>

				</tr>

			</table>


		</form:form>
	</div>


</body>
</html>

