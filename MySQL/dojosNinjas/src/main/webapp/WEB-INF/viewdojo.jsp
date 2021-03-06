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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Dojos and Ninjas</title>
</head>
<body class="bg-dark text-light">
	<div class="w-75 mx-auto">
		<div class="d-flex justify-content-between mt-3 mb-3">
			<p class="fs-2 text-primary">
				<c:out value="${dojo.name }" />

			</p>
			<a href="/dojos">Go back</a>

		</div>
		<p class="fs-3">Ninjas in this dojo</p>
		<div class="col-6">
			<c:choose>
				<c:when test="${dojo.getNinjas().size() > 0 }">
					<table class="table table-light">
						<thead>
							<tr>
								<td>Ninja name:</td>
								<td>Ninja age:</td>
								<td>Actions:</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${dojo.getNinjas() }" var="student">
								<tr>
									<td><c:out value="${student.first_Name }" /> <c:out
											value="${student.last_Name }" /></td>
									<td><c:out value="${student.age }" /></td>
									<td><a href="/remove/ninja/${dojo.id }"
										class="btn btn-danger btn-sm">Remove from dojo</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<p>No students in this dojo :(</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>