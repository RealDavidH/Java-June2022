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
<meta charset="ISO-8859-1" />
<title>Create a name!</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="bg-dark text-light p-4">
		<nav class="navbar navbar-expand-lg">
		<div class="container-fluid col-10">
			<p class="fs-1">Add a name!</p>
		</div>
		
	</nav>
	<div class="container-fluid col-12">
		<form:form action="/name/create" method="post" modelAttribute="oneName" class="mx-auto w-75">
			<p>
				<form:label class="form-label" path="name">Name:</form:label>
				<form:errors path="name" />
				<form:input class="form-control w-50" path="name" />
			</p>
			<p>
				<form:label class="form-label" path="gender">Typical Gender:</form:label>
				<form:errors path="gender" />
				<form:select path="gender"> 
					<form:option value="neutral">Neutral</form:option>
					<form:option value="male">Male</form:option>
					<form:option value="female">Female</form:option>
				</form:select>
			</p>
			<p>
				<form:label class="form-label" path="origin">Origin:</form:label>
				<form:errors path="origin" />
				<form:input class="form-control w-50" path="origin" />
			</p>
			<p>
				<form:label class="form-label" path="meaning">Meaning(s):</form:label>
				<form:errors path="meaning" />
				<form:textarea class="form-control w-50" path="meaning" />
			</p>
			<div>
				<a href="/home" class="btn btn-danger">Cancel</a>
				<input type="submit" value="Submit" class="btn btn-primary" />
			</div>
		</form:form>
		
	</div>
	</body>
</html>