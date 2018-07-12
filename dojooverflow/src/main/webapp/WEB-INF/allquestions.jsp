<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Questions Dashboard</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<style>
		.green{
			color:green;
		}
		span:last-child{
			display:none;
		}
	</style>
</head>
<body>
	<h1>Questions Dashboard</h1>
	
	<p class="green"><c:out value="${questionsuccess}"/></p>
	
	<table class="table table-bordered" style="width:50%">
	    <thead>
	        <tr>
	            <th>Question</th>
	            <th>Tags</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${questions}" var="question">
	        <tr>
	            <td><a href="/questions/${question.id}"><c:out value="${question.name}"/></a></td>
	            <td>
	            	<c:forEach items="${question.tags}" var="tag">
	            	<c:out value="${tag.subject}"/><span>,</span>
	            	</c:forEach>
	            </td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<br><br>
	
	<a href="/questions/new">New Question</a>
	
</body>
</html>