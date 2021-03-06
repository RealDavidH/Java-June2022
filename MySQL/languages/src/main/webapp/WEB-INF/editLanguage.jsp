<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<!-- for Form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container w-75 mx-auto mt-3">
		<h1 class="text-danger">Edit Language:</h1>
		<a href="/languages">Go back</a>
		<form:form action="/update/${oneLanguage.id}" method="post"
			modelAttribute="language" class="w-75 text-center form">
			
			<input type="hidden" name="_method" value="put" />
			<p>
				<form:label path="languageName">Language Name:</form:label>
				
				<form:input path="languageName" value="${oneLanguage.languageName}" />
			</p>
			<form:errors path="languageName" />
			<p>
				<form:label path="creator">Creator name:</form:label>
				<form:errors path="creator" />
				<form:input path="creator" value="${oneLanguage.creator}" />
			</p>
			<p>
				<form:label path="verison">Version:</form:label>
				<form:errors path="verison" />
				<form:input path="verison" value="${oneLanguage.verison}" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>