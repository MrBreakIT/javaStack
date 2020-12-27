<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body style="background-color: lightgray">
	<h1>Register!</h1>

	<!-- <p>
		<form:errors path="user.*" />
	</p>
 -->
	<form:form method="POST" action="/registration" modelAttribute="user">
		<p>
			<form:label path="email">Email:</form:label>
			<form:input type="email" path="email" />
			<form:errors path="email" class="text-danger" />
		</p>
		<p>
			<form:label path="password">Password:</form:label>
			<form:password path="password" />
			<form:errors path="password" class="text-danger" />
		</p>
		<p>
			<form:label path="passwordConfirmation">Password Confirmation:</form:label>
			<form:password path="passwordConfirmation" />
		</p>
		<input type="submit" value="Register!" />
	</form:form>

</body>
</html>