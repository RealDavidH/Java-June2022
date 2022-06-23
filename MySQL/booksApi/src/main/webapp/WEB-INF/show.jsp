<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h1><c:out value="${book.title }"/></h1>
<p><c:out value="${book.description}"/></p>
<p><c:out value="${book.language}"/></p>
<p><c:out value="${book.number_of_pages}"/></p>
</body>
</html>