<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Question</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<style>
		.red{
			color:red;
		}
	</style>
</head>
<body>
	<h1>What is your question?</h1>
	<form action="/questions/new" method="post">
		<p class="red"><c:out value="${questionerror}"/></p>
		<p class="red"><c:out value="${tagerror}"/></p>
		<label for="question">Question:</label>
		<textarea name="question"></textarea>
		<label for ="tags">Tag(s):</label>
		<input type="text" name="tags">
		<input type="submit" value="submit" class="btn btn-success">
	</form>
</body>
</html>