<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${category.name}</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<h1>${category.name}</h1>
	<h2>Products:</h2>
	<table class="table table-bordered" style="width:50%">
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Description</th>
	            <th>Price</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${category.products}" var="product">
	        <tr>
	            <td><c:out value="${product.name}"/></td>
	            <td><c:out value="${product.description}"/></td>
	            <td><c:out value="${product.price}"/></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<br><br>
	<form action="/categories/${category.id}" method="post">
		<label for="prod">Add Product:</label>
		<select name="prod">
			<option selected="selected">Select product</option>
			<c:forEach items="${allprods}" var="prod">
				<option value="${prod.id}">${prod.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form>
</body>
</html>