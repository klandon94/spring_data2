<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	
	<form action="/ninjas/new" method="post">
		<select name="dojo">
			<option selected="selected">Select dojo</option>
			<c:forEach items="${dojos}" var="dojo">
				<option value="${dojo.id}">${dojo.name}</option>
			</c:forEach>
		</select>
		<label for="fName">First Name:</label>
		<input type="text" name="fName">
		<label for="lName">Last Name:</label>
		<input type="text" name="lName">
		<label for="age">Age:</label>
		<input type="text" name="age">
		<input type="submit" value="submit">
	</form>
</body>
</html>