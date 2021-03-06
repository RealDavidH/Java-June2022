<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>

<!-- for Form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a book!</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
	<body class="bg-dark text-light p-4">
		<nav class="navbar navbar-expand-lg">
		<div class="container-fluid col-10">
			<p class="fs-1">Add a book to your shelf!</p>
		</div>
		<div class="container-fluid col-2">
			<a href="/books" class="nav-link fs-5">Back to the shelves!</a>
		</div>
	</nav>
	<div class="container-fluid col-12">
		<form:form action="/book/create" method="post" modelAttribute="book" class="mx-auto w-75">
			<p>
				<form:label class="form-label" path="title">Title:</form:label>
				<form:errors path="title" />
				<form:input class="form-control w-50" path="title" />
			</p>
			<p>
				<form:label class="form-label" path="author">Author:</form:label>
				<form:errors path="author" />
				<form:input class="form-control w-50" path="author" />
			</p>
			<p>
				<form:label class="form-label" path="thoughts">Your thoughts:</form:label>
				<form:errors path="thoughts" />
				<form:textarea class="form-control w-50" path="thoughts" />
			</p>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>
	</body>
</html>