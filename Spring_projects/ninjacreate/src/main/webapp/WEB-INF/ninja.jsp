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
	<div class="container">
		<h1 class="text-center">Edit Ninja Info</h1>
		<a href="/"
			class="col-sm-4 m-3 form-group btn btn-sm btn-outline-dark d-flex justify-content-center mx-auto">Home</a>

		<div class="row d-flex justify-content-around mx-auto">
			<div class="card bg-dark color-light rounded">
				<img src="/images/NinjaPic.jpg" alt="ninja pic"
					class="card-img-top img-fluid rounded mx-auto d-block " />
				<div class="card-header bg-light">${singleNinja.name}</div>
				<div class="card-body bg-light">
					<p>Home-town: ${singleNinja.hometown}</p>
					<p>Level: ${singleNinja.level}</p>
					<p>Techniques:</p>
					<ul>
						<c:forEach items="${singleNinja.techniques}" var="tech">
							<li>${tech.name}</li>
						</c:forEach>
					</ul>
					<form action="/addtech" method="post">
						<input type="text" name="name" />
						<input type="hidden" name="ninja" value="${singleNinja.id}" />
						<input type="submit" value="Add" class="btn btn-sm btn-dark" />
						<p class="text-danger">${nameError}</p>
					</form>
				</div>
			</div>
			<div class="col">
				<form:form action="/ninja/update/${singleNinja.id}" method="post"
					modelAttribute="singleNinja" class="col-sm-5 mx-auto">
					<div class="form-group">
						<label></label>
						<form:input path="name" class="form-control" />
						<form:errors path="name" class="text-danger" />
					</div>
					<div class="form-group">
						<label></label>
						<form:input path="hometown" class="form-control" />
						<form:errors path="hometown" class="text-danger" />
					</div>
					<div class="form-group">
						<label></label>
						<form:input path="level" type="number" class="form-control" />
						<form:errors path="level" class="text-danger" />
					</div>
					<input type="submit" value="Submit change"
						class="btn btn-sm btn-dark" />
				</form:form>
			</div>
		</div>
	</div>


</body>
</html>