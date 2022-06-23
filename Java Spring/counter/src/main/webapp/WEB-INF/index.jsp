<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Counter</title>
</head>
<body>
	<h1>The current count is:</h1>
	<p><c:out value="${counter}"/></p>
	<a href="/count">Click me to add to the count!</a>
	
	
</body>
</html>
