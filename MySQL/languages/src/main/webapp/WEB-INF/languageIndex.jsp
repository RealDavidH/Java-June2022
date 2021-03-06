<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<body class="bg-dark text-light">
	<div class="container w-75 mx-auto mt-3">
		<h1 class="text-primary">Save Travels</h1>
		<table class="table table-dark">
			<thead>
				<tr>
					<td>Language name:</td>
					<td>Creator Name:</td>
					<td>Version:</td>
					<td>Actions</td>
				</tr>
			</thead>
				<c:forEach items="${allLanguage}" var="item">
					<tr>
					<td><a href="/view/${item.id}"><c:out value="${item.languageName }"/></a> </td>
					<td><c:out value="${item.creator }"/></td>
					<td><c:out value="${item.verison }"/></td>
					<td><a href="/edit/${item.id}" class="btn btn-secondary btn-sm">Edit</a> | <a href="/delete/${item.id}" class="btn btn-danger btn-sm">Delete</a></td>
					</tr>
				</c:forEach>
			<tbody>
			</tbody>
		</table>
		<div class="container w-75 text-center">
			<p class="fs-3 text-primary">Add a Language</p>
			<form:form action="/process" method="post" modelAttribute="language">
				<p>
					<form:label path="languageName">Language name:</form:label>
					<form:errors path="languageName" />
					<form:input path="languageName" />
				</p>
				<p>
					<form:label path="creator">Creator name:</form:label>
					<form:errors path="creator" />
					<form:input path="creator" />
				</p>
				<p>
					<form:label path="verison">Version:</form:label>
					<form:errors path="verison" />
					<form:input type="number" path="verison" />
				</p>
				<input type="submit" value="Submit" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
</body>
</body>

</html>