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
<meta charset="ISO-8859-1" />
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="p-4 bg-dark text-light">
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<p class="navbar-brand mb-0 fs-2">
				Hello, <c:out value="${sessionUser.name }"/>. Here are some name suggestions...
			</p>
			<a href="/logout" class="nav-link text-info">Logout</a>
		</div>
	</nav>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<p class="navbar-brand mb-0 fs-4">
				Baby Names
			</p>
		</div>
	</nav>
	<div class="container-fluid">
		
		<c:choose>
			<c:when test="${allName.size() > 0 }">
				<div class="card">
					<div class="table-responsive">
						<table class="table table-info table-striped">
							<tbody>
								<c:forEach items="${allName }" var="name">
									<tr class="align-middle">
										<td><c:choose>
											<c:when test="${sessionUser.getLikedName().contains(name) }">
											<form:form action="/name/unvote/${name.id }" method="post">
											<input type="hidden" name="_method" value="put" />
												<input type="submit" value="Un vote" class="btn btn-warning" />
											</form:form>
											</c:when>
											<c:otherwise>
												<form:form action="/name/upvote/${name.id }" method="post">
												<input type="hidden" name="_method" value="put" />
												<input type="submit" value="Up vote" class="btn btn-primary" />
											</form:form>
											</c:otherwise>
										</c:choose></td>
										<td><a href="/name/view/${name.id}" class="nav-link"><c:out value="${name.name }" /></a></td>
										<td><c:out value="${name.gender}" /></td>
										<td>Origin: <c:out value="${name.origin }" /></td>
										<td>Up votes: <p class="text-primary fs-3"><c:out value="${name.getUserLiked().size() }"/></p></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<p class="fs-2 text-center">No names posted yet, help out by adding one!</p>
			</c:otherwise>
		</c:choose>
	</div>
	<a href="/name/add" class="btn btn-success mt-3">Add a name!</a>
	</div>
		
</body>
</html>