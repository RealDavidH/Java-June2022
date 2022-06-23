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
<title><c:out value="${oneName.name}" /></title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="bg-dark text-light p-4">
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid col-10">
			<p class="fs-1">
				<c:out value="${oneName.name }" />
			</p>

		</div>
		<div class="container-fluid col-2">
			<a href="/home" class="nav-link fs-5">Back to home</a>
		</div>
	</nav>
	<div class="container-fluid">
		<p class="fs-3">(added by <c:out value="${oneName.getUser().getName() }" />)</p>
	</div>
	<div class="container-fluid border-bottom">
		<p class="fs-5">Gender:	<c:out value="${oneName.gender }" /></p>
		<p class="fs-5"> Origin: <c:out value="${oneName.origin }" /></p>
		<p class="fs-5">Meaning: <c:out value="${oneName.meaning }" /></p>
		<c:choose>
			<c:when test="${ user.getLikedName().contains(oneName) }"> 
			<p class="fs-5 text-primary">You have upvoted this name!</p>
			</c:when>
			<c:otherwise>
				<form:form action="/name/view/upvote/${oneName.id }" method="post">
				<input type="hidden" name="_method" value="put" />
				<input type="submit" value="Upvote" class="btn btn-primary" />
				</form:form>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="d-flex justify-content-end mt-5">
		<c:if test="${user == oneName.getUser() }">
			<form:form action="/name/delete/${oneName.id}" method="post">
				<input type="hidden" name="_method" value="delete" />
				<a href="/name/edit/${oneName.id }" class="btn btn-primary">Edit your post</a> 
				<input type="submit" value="Delete" class="btn btn-danger" />
			</form:form>
		</c:if>
	</div>
</body>
</html>