<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>

<body>


	<div>
		<h1>Registration</h1>
		<!--       			commandName="user" -->
		<form:form method="POST" action="registration" modelAttribute="user">

			<table>
				<form:hidden path="userId" />
				<tr>
					<td>Name:</td>
					<td><form:input path="name" />
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" />
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" />
				</tr>

				<tr>
					<td>Phone Number:</td>
					<td><form:input path="phoneNo" />
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Register"></td>
					
				</tr>
				
			</table>


		</form:form>
	</div>


</body>
</html>

