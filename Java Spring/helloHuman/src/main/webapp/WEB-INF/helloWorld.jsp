
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- New line below to use the JSP Standard Tag Library -->

<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Hello world</h1>
		<p><c:out value ="${2+2}"/></p>
		<p><c:out value="${dojoName}"/></p>
		
	</div>
</body>
</html>