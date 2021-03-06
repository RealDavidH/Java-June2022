<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="p-4">
	<p>Your gold: <span class="border border-dark ps-3 pe-3"><c:out value="${gold}"/></span></p>
	<div class="container d-flex flex-row p-3">
		<form action="/farm" class="container border border-dark me-3 p-3 text-center" method="post">
			<p class="fs-4" >Farm</p>
			<p class="mt-3">(earns 10-20 gold)</p>
			<input type="submit" name="farm" value="Find Gold!" />
		</form>
		<form action="/cave" class="container border border-dark me-3 p-3 text-center" method="post">
			<p class="fs-4">Cave</p>
			<p class="mt-3">(earns 5-10 gold)</p>
			<input type="submit" name="cave" value="Find Gold! " />
		</form>
		<form action="/house" class="container border border-dark p-3 text-center" method="post">
			<p class="fs-4">House</p>
			<p class="mt-3">(earns 10-20 gold)</p>
			<input type="submit" name="house" value="Find Gold!" />
		</form>
		<form action="/casino" class="container border border-dark ms-3 p-3 text-center" method="post">
			<p class="fs-4">Casino</p>
			<p class="mt-3">(Takes/earns 0-50 gold)</p>
			<input type="submit" name="casino" value="Find Gold!" />
		</form>
		
	</div>
	<p class="text-center">Activity:</p>
	<div style=" min-height: 200px; max-height: 200px;" class="border border-dark overflow-auto" >
	<c:if test="${message.size() > 0}">
		
		<c:forEach items="${message}" var="stuff">
			<p>${stuff}</p>
		</c:forEach>
	</c:if>
	</div>
</body>
</html>