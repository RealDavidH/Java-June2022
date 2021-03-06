<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Read Share</title>
</head>
<body class="bg-dark text-light">
	<div class="container w-75 mx-auto mt-3">
		<h1 class="text-primary">Save Travels</h1>
		<table class="table table-dark">
			<thead>
				<tr>
					<td>Product</td>
					<td>Vendor</td>
					<td>Price:</td>
					<td>Actions</td>
				</tr>
			</thead>
			<c:forEach items="${allSavers}" var="item" >
				<tr>
				<td><a href="/show/${item.id}"><c:out value="${item.product}"/></a></td>
				<td><c:out value="${item.vendorName}"/></td>
				<td>$<c:out value="${item.price}"/></td>
				<td><a href="/edit/${item.id}">Edit</a> | <a href="/delete/${item.id}" class="btn btn-danger btn-sm">Delete</a> </td>
				</tr>
			</c:forEach>
			<tbody>
			</tbody>
		</table>
		<div class="container w-75 text-center">
			<p class="fs-3 text-primary">Add an expense</p>
			<form:form action="/process" method="post" modelAttribute="saver">
				<p>
					<form:label path="product">Product name:</form:label>
					<form:errors path="product"/>
					<form:input path="product"/>
				</p>
				<p>
					<form:label path="vendorName">Vendor name:</form:label>
					<form:errors path="vendorName"/>
					<form:input path="vendorName"/>
				</p>
				<p>
					<form:label path="price">Price:</form:label>
					<form:errors path="price"/>
					<form:input type="number" path="price"/>
				</p>
				<input type="submit" value="Submit" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
</body>
</html>