<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hopper Receipt</title>
</head>
<body>
	<h1>Customer name: <c:out value="${name}" /></h1>
	<p>Item name: <c:out value="${itemName}"/></p>
	<p>Price: <c:out value="${price}"/></p>
	<p>Description: <c:out value="${desc}"/></p>
	<p>Vendor: <c:out value="${vendor}"/></p>
</body>
</html>