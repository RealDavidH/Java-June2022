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
				Books from everyone's shelves:
			</p>
			<a href="/bookmarket" class="nav-link text-info">Borrow Books</a>
			<a href="/book/add" class="nav-link text-info">+ add a book to my shelf</a>
		</div>
	</nav>
	<div class="container-fluid">
		
		<c:choose>
			<c:when test="${allBooks.size() > 0 }">
				<div class="card">
					<div class="table-responsive">
						<table class="table table-info table-striped">
							<thead>
								<tr>
									<td>Title</td>
									<td>Author Name</td>
									<td>Posted by</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${allBooks }" var="book">
									<tr class="align-middle">
										<td><a href="/book/${book.id}" class="nav-link"><c:out value="${book.title }" /></a></td>
										<td><c:out value="${book.author }" /></td>
										<td><c:out value="${book.getUser().getName()}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<p class="fs-2 text-center">No books posted yet, help out by adding one!</p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>