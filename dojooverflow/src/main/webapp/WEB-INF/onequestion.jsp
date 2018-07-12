<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Question ${question.id}</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<style>
		#tags{
			display:inline-block;
			margin-right:15px;
		}
		.red{
			color:red;
		}
	</style>
</head>
<body>

	<h1>${question.name}</h1>
	<h2>Tags:</h2>
	<c:forEach items="${question.tags}" var="tag">
		<div id="tags" class='btn-primary'><c:out value="${tag.subject}"/></div>
	</c:forEach>
	<br><br>
	<table class ="table table-bordered">
		<thead>
			<tr>
				<th>Answers</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${question.answers}" var="answer">
			<tr>
				<td><c:out value="${answer.name}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form:form action="/questions/${question.id}" modelAttribute="answer" method="POST">
		<form:label path="name">Answer</form:label>
		<form:errors path="name" class="red"/>
		<form:input path="name"/>
		<form:input type="hidden" value="${question.id}" path="question"/>
		<input type="submit" value="Submit" class="btn btn-success"/>
	</form:form>
	
</body>
</html>