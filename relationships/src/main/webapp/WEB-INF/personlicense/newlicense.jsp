<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New license</title>
</head>
<body>
	<h1>New License</h1>
	
	<form action="/licenses/new" method="post">
		<select name="person">
			<option selected="selected">Select person</option>
			<c:forEach items="${persons}" var="person">
				<option value="${person.id}">${person.firstName} ${person.lastName}</option>
			</c:forEach>
		</select>
		<label for="state">State:</label>
		<input type="text" name="state">
		<label for="date">Date:</label>
		<input type="text" name="date">
		<input type="submit" value="submit">
	</form>
</body>
</html>