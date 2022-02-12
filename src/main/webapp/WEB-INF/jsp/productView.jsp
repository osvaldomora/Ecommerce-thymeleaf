<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>

<body>
	<h1 colspan="2" align="center">Products List</h1>

	<div align="center">

		
		<form:form method="POST" action="addToCart" modelAttribute="product">

			<table>
				<tr>
					<td>Product Name</td>
					<td>Product Category</td>
					<td>Price</td>
					<td>Available Quantity</td>
				</tr>
				<c:forEach items="${productsList}"  var="prod">
					<tr>
						<td>${prod.productName}</td>
						<td>${prod.productCategory}</td>
						<td>${prod.productPrice}</td>
						<td>${prod.productQuantity}</td>
						<td colspan="2" align="center"><input type="submit"
							value="add to Cart"></td>
					</tr>
				</c:forEach>
				
				<tr>
				      <td><a href="viewCart?userId=${userId}">View Cart</a></td>
				</tr>
				
				
			</table>


		</form:form>
	</div>


</body>
</html>

