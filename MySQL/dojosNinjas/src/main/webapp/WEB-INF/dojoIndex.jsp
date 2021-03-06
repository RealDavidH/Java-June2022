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
	<div class="mx-auto w-75">
		<p class="fs-1 text-primary">Dojos</p>
	
	<table class="table table-light mx-auto">
		<thead>
			<tr>
				<td>Dojo</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allDojos}" var="dojo">
				<tr>
					<td><a href="/view/dojo/${dojo.id}"><c:out
								value="${dojo.name }" /></a></td>
					<td><a href="/delete/${dojo.id}" class="btn btn-danger btn-sm">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="container d-flex flex-row text-center">
		<div class="col-6">
			<p class="fs-2 text-primary">Add a new dojo:</p>
			<form:form action="/dojo/new" method="post" modelAttribute="dojo" class="">
				<p>
					<form:label path="name">Dojo Location:</form:label>
					<form:errors path="name" />
					<form:input path="name" />
				</p>
				<input type="submit" value="Add Dojo" class="btn btn-primary" />
			</form:form>
		</div>
		<div class="col-6 ">
			<p class="fs-2 text-primary">Add a new Ninja:</p>
			<form:form action="/ninja/new" method="post" modelAttribute="ninja" class="">
				<p>
					<form:label path="first_Name">First Name:</form:label>
					<form:errors path="first_Name" />
					<form:input path="first_Name" />
				</p>
				<p>
					<form:label path="last_Name">Last Name:</form:label>
					<form:errors path="last_Name" />
					<form:input path="last_Name" />
				</p>
				<p>
					<form:label path="age">Age:</form:label>
					<form:errors path="age" />
					<form:input path="age" type="number" />
				</p>
				<p>
					<form:select path="dojo">
						<c:forEach items="${allDojos }" var ="dojo">
							<form:option value="${dojo }"><c:out value="${dojo.name }"/></form:option>
						</c:forEach>
					</form:select>
				</p>
				<input type="submit" value="Add Ninja" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
</div>

</body>
</html>