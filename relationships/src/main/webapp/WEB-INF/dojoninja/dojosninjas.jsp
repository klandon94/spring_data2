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
	<h1>Dojos and Ninjas</h1>
	<table class="table table-bordered">
	    <thead>
	        <tr>
	            <th>Dojo Name</th>
	            <th>Ninja First Name</th>
	            <th>Ninja Last Name</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${table}" var="row">
	        <tr>
	            <td><c:out value="${row[0].name}"/></td>
	            <td><c:out value="${row[1].firstName}"/></td>
	            <td><c:out value="${row[1].lastName}"/></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
</body>
</html>