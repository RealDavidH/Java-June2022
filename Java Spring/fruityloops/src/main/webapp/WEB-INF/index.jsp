<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- for Bootstrap CSS -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Fruity Loops</title>
</head>
<body class="bg-dark">
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Name:</th>
				<th>Price:</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="fruit" items="${items}">
				<tr class="text-light">
					<td><c:out value="${fruit.name}" /></td>
					<td><c:out value="${fruit.price}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>