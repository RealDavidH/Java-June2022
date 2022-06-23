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
<title>Editing <c:out value="${editName.name }"/></title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="bg-dark text-light p-4">
		<nav class="navbar navbar-expand-lg">
		<div class="container-fluid col-10">
			<p class="fs-1">Edit <c:out value="${editName.name }"/>!</p>
		</div>
		
	</nav>
	<div class="container-fluid col-12">
		<form:form action="/name/update/${editName.id}" method="post" modelAttribute="editName" class="mx-auto w-75">
		<input type="hidden" name="_method" value="put" />
			<p>
				<form:label class="form-label" path="name">Name:</form:label>
				<form:errors path="name" />
				<form:input class="form-control w-50 bg-secondary" path="name" value="${editName.name }" disabled="true"/>
			</p>
			<p>
				<form:label class="form-label" path="gender">Typical Gender:</form:label>
				<form:errors path="gender" />
				<form:select path="gender" > 
					<form:option selected="true" value="${editName.gender }"><c:out value="${editName.gender }"/></form:option>
					<form:option value="neutral">Neutral</form:option>
					<form:option  value="male">Male</form:option>
					<form:option  value="female">Female</form:option>
				</form:select>
			</p>
			<p>
				<form:label class="form-label" path="origin">Origin:</form:label>
				<form:errors path="origin" />
				<form:input class="form-control w-50" path="origin" value="${editName.origin }" />
			</p>
			<p>
				<form:label class="form-label" path="meaning">Meaning(s):</form:label>
				<form:errors path="meaning" />
				<form:input class="form-control col-12" path="meaning" value="${editName.meaning }"/>
			</p>
			<div>
				<a href="/name/view/${editName.id }" class="btn btn-danger">Cancel</a>
				<input type="submit" value="Submit" class="btn btn-primary" />
			</div>
			
		</form:form>
		
	</div>
	</body>
</html>