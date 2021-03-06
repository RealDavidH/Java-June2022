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
<title><c:out value="${oneBook.title}"/></title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="bg-dark text-light p-4">
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid col-10">
			<p class="fs-1"><c:out value="${oneBook.title }"/></p>
		</div>
		<div class="container-fluid col-2">
			<a href="/books" class="nav-link fs-5">Back to the shelves!</a>
		</div>
	</nav>
	<div class="container-fluid w-75">
		<c:choose>
			<c:when test="${uuid == oneBook.getUser().getId() }">
				<p class="fs-5">You read <c:out value="${oneBook.title }"/> by <c:out value="${oneBook.author }"/></p>
				<p class="fs-5">Here are your thoughts on it:</p>
			</c:when>
			<c:otherwise>
				<p class="fs-5"><c:out value="${oneBook.getUser().getName() }"/> read <c:out value="${oneBook.title }"/> by <c:out value="${oneBook.author }"/></p>
				<p class="fs-5">Here are <c:out value="${oneBook.getUser().getName() }"/>'s thoughts:</p>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="container border-top border-bottom">
		<p><c:out value="${oneBook.thoughts }"/></p>
	</div>

	<c:if test="${uuid == oneBook.getUser().getId() }">
		<div class="container d-flex justify-content-end mt-2">
			<a href="/edit/${oneBook.id }" class="btn btn-primary">Edit your post</a>
			<a href="/book/delete/${oneBook.id }" class="btn btn-danger ms-3">Delete</a>
		</div>
	</c:if>
</body>
</html>