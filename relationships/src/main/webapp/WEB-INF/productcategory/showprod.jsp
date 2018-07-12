<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${product.name}</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<h1>${product.name}</h1>
	<p>${product.description}</p>
	<h2>Categories:</h2>
	<ul>
	<c:forEach items="${product.categories}" var="cat">
		<li><c:out value="${cat.name}"/></li>
	</c:forEach>
	</ul>
	<br><br>
	<form action="/products/${product.id}" method="post">
		<label for="cat">Add Category:</label>
		<select name="cat">
			<option selected="selected">Select category</option>
			<c:forEach items="${allcats}" var="cat">
				<option value="${cat.id}">${cat.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form>
</body>
</html>