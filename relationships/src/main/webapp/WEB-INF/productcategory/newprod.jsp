<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Product</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<h1>New Product</h1>
	<form:form action="/products/new" method="post" modelAttribute="product">
	<form:errors path="name"></form:errors>
    <p>    	
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
    </p>
    <form:errors path="description"></form:errors>
    <p>    	
        <form:label path="description">Description</form:label>
        <form:input path="description"/>
    </p>
    <form:errors path="price"></form:errors>
    <p>    	
        <form:label path="price">Price</form:label>
        <form:input path="price"/>
    </p>
    <input type="submit" value="Submit"/>
	</form:form>  
</body>
</html>