<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>books</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<c:forEach items="${books}" var = "book">
	<p class="fs-3"><c:out value="${ book.title }"/></p>
	<p><c:out value="${book.description }"/></p>
	<p><c:out value="${book.language }"/></p>
	<p><c:out value="${book.number_of_pages }"/></p>
</c:forEach>
</body>
</html>