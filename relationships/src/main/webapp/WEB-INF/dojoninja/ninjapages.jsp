<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja pages</title>
</head>
<body>
	<h1>Ninjas</h1>
    
    <!-- for loop to create all the links -->
    <c:forEach begin="1" end="${totalPages}" var="index">
        <a href="/pages/${index}">${index}</a>
    </c:forEach>
    <table class="table">
        <thead>
            <th>First Name</th>
            <th>Last Name</th>
        </thead>
        <tbody>
            <!-- we have to call the .content method to actually get the ninjas inside the Page iterable. -->
            <c:forEach var="ninja" items="${ninjas.content}">                 
            <tr>
                <td><c:out value="${ninja.firstName}"></c:out></td>
                <td><c:out value="${ninja.lastName}"></c:out></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>