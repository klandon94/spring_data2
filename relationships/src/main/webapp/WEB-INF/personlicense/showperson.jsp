<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Person ${person.id}</title>
</head>
<body>
	<h1>${person.firstName} ${person.lastName}</h1>
	<br>
	<p><b>License Number:</b> <c:out value="${person.license.number}"></c:out></p>
	<p><b>State:</b> <c:out value="${person.license.state}"></c:out></p>
	<p><b>Expiration Date:</b> <c:out value="${person.license.expiration_date}"></c:out> </p>
</body>
</html>