<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikiuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="text-center">
	<p class="fs-1">Here's you Omikiuji!</p>
	<div class="bg-primary border border-dark mx-auto w-25">
		<p class="p-3 text-light">
			In
			<c:out value="${info.number}" />
			, you will live in
			<c:out value="${info.city}" />
			with
			<c:out value="${info.person}" />
			as your roommate,
			<c:out value="${info.job}" />
			for a living. The next time you see a
			<c:out value="${info.thing}" />
			, you will have good luck. Also
			<c:out value="${info.nice}"/>. 
		</p>
	</div>
	<a href="/" class="">Go back</a>
</body>
</html>