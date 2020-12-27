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
<title>Show Ninja Info</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: lightslategray">
	<div class="container text-center">
		<h1 class="text-center">Show Ninja Info</h1>
		<img src="/images/NinjaPic.jpg" alt="ninja pic"
			class="rounded mx-auto d-block" />

		<h1>${ninja.name}</h1>
		<h2>Home-town: ${ninja.hometown}</h2>
		<h3>Skill Level: ${ninja.level}</h3>
		<h3>Skilled Techniques:</h3>
		<ul>
			<c:forEach items="${singleNinja.techniques}" var="tech">
				<li>${tech.name}</li>
			</c:forEach>
		</ul>
		<a href="/ninja/${ninja.id}" class="btn btn-sm btn-dark">Edit
			Ninja</a> <a href="/ninja/destroy/${ninja.id}"
			class="btn btn-sm btn-dark">Kill Ninja</a> <a href="/"
			class="btn btn-sm btn-dark">Home</a>


	</div>
</body>
</html>