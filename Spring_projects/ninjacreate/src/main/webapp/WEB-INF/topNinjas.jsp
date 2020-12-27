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
<title>Ninja Info</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: lightslategray">
	<div class="container text-center">
		<h1 class="text-center">Top 3 Ninjas!</h1>
		<img src="/images/NinjaPic.jpg" alt="ninja pic"
			class="rounded mx-auto d-block" />

		<div class="col-sm">
			<table
				class="table height-500px table-dark table-striped table-hover rounded overflow-hidden m-3">
				<tr>
					<th style="width: 400px">Name</th>
					<th style="width: 400px">Home-town</th>
					<th style="width: 250px">Level</th>
				</tr>
				<c:forEach items="${ninjas}" var="ninja">
					<tr>
						<td><a href="/ninja/show/${ninja.id}">${ninja.name}</a></td>
						<td>${ninja.hometown}</td>
						<td>${ninja.level}</td>
					</tr>
				</c:forEach>
			</table>
			<a href="/" class="btn btn-sm btn-dark">Home</a>
		</div>
	</div>


</body>
</html>