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
<title>Book Club</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="bg-dark text-light p-4">
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<p class="navbar-brand mb-0 fs-2">
				Hello
				<c:out value="${user.name }" />
			</p>
			<a href="/logout" class="nav-link text-info">Logout</a>
		</div>
	</nav>
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<p class="navbar-brand mb-0 fs-4">
				Books available to borrow:
			</p>
			<a href="/books" class="nav-link text-info fs-5">Go back to shelves</a>
		</div>
	</nav>
	<div class="container-fluid">
		
		<c:choose>
			<c:when test="${inMarket.size() > 0 }">
				<div class="card">
					<div class="table-responsive">
						<table class="table table-info table-striped">
							<thead>
								<tr>
									<td>Title</td>
									<td>Author Name</td>
									<td>Posted by</td>
									<td>Actions</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${inMarket }" var="book">
									<tr class="align-middle">
										<td><a href="/book/${book.id}" class="nav-link"><c:out value="${book.title }" /></a></td>
										<td><c:out value="${book.author }" /></td>
										<td><c:out value="${book.getUser().getName()}" /></td>
										<td><a href="/book/borrow/${book.id}" class="btn btn-primary">Borrow this book</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<p class="fs-2 text-center">All the books have been borrowed! Check back later to see what's in stock!</p>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<p class="navbar-brand mb-0 fs-4">
				Books you currently have borrowed:
			</p>
		</div>
	</div>
	<div class="container-fluid">
		
		<c:choose>
			<c:when test="${borrowed.size() > 0 }">
				<div class="card">
					<div class="table-responsive">
						<table class="table table-info table-striped">
							<thead>
								<tr>
									<td>Title</td>
									<td>Author Name</td>
									<td>Posted by</td>
									<td>Actions</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${borrowed }" var="book">
									<tr class="align-middle">
										<td><a href="/book/${book.id}" class="nav-link"><c:out value="${book.title }" /></a></td>
										<td><c:out value="${book.author }" /></td>
										<td><c:out value="${book.getUser().getName()}" /></td>
										<td><a href="/book/return/${book.id}" class="btn btn-danger">Return this book</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<p class="fs-2 text-center">You have no books currently borrowed!</p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>