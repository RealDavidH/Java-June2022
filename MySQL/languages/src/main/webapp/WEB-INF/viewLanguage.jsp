<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Read Share</title>
</head>
<body class="bg-dark text-light">
	<div class="container w-75 mx-auto mt-3">
		<div class="d-flex justify-content-between fs-3">
			<h1 class="text-primary">Product Details:</h1>
			<a href="/languages">Go Back</a>
		</div>
		<div class="d-flex fs-4"><div class="col-6">
				<p>Language name:</p>
				<p>Creator:</p>
				<p>Version:</p>
			</div>
			<div class="col-6">
				<p><c:out value="${oneLanguage.languageName}"/></p>
				<p><c:out value="${oneLanguage.creator}"/></p>
				<p>$<c:out value="${oneLanguage.verison}"/></p>
			</div>
			</div>
	</div>
</body>
</html>