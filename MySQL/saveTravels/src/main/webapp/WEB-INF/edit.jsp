<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- for Form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="bg-dark text-light">
	<div class="container w-75 mx-auto mt-3">
	<h1 class="text-danger">Edit Product:</h1>
		<form:form action="/update/${oneSaver.id}" method="post"
			modelAttribute="saver" class="w-75 text-center form">
			
				<input type="hidden" name="_method" value="put"/>
				<p>
					<form:label path="vendorName">Vendor name:</form:label>
					<form:errors path="vendorName"/>
					<form:input path="vendorName" value="${oneSaver.vendorName}"/>
				</p>
				<p>
					<form:label path="product">Product name:</form:label>
					<form:errors path="product"/>
					<form:input path="product" value="${oneSaver.product}"/>
				</p>
				<p>
					<form:label path="price">Price:</form:label>
					<form:errors path="price"/>
					<form:input path="price" value="${oneSaver.price}"/>
				</p>
				<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>