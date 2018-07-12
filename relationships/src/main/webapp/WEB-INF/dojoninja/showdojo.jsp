<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${dojo.name}</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<h1>${dojo.name} Location Ninjas</h1>
	<table class="table table-bordered">
	    <thead>
	        <tr>
	            <th>First Name</th>
	            <th>Last Name</th>
	            <th>Age</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${ninjas}" var="ninja">
	        <tr>
	            <td><c:out value="${ninja.firstName}"/></td>
	            <td><c:out value="${ninja.lastName}"/></td>
	            <td><c:out value="${ninja.age}"/></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
</body>
</html>