<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikiuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<p class="fs-3 text-center">Send a Omikijui</p>
	<form action="/process" class="mx-auto w-50 border border-2 border-dark d-flex justify-content-center" method="post">
		<div class="p-3 text-center d-flex flex-column w-25">
			<p>Pick a number from 5 to 25</p>
			<input type="number" name="number"/>
			<p>Enter the name of any city</p>
			<input type="text" name="city" />
			<p>Enter the name of any real person:</p>
			<input type="text" name="person" />
			<p>Enter job or hobby:</p>
			<input type="text" name="job" />
			<p>Enter a living thing</p>
			<input type="text" name="thing" id="" />
			<p>Say something nice to someone:</p>
			<textarea name="nice" rows="4" cols="50" > </textarea>
			<input type="submit" class="btn btn-primary mt-2" value="Submit" />
		</div>
	</form>
</body>
</html>