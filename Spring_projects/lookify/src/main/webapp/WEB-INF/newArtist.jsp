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
<title>Lookify</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: gray">
	<div class="container">
		<div class="col mx-auto text-center">
			<h1>Add a Artist</h1>
				<a class="btn btn-dark btn-outline-info" href="/dashboard">Dashboard</a>
			<form:form action="/create/artist" method="post"
				modelAttribute="newArtist" style="margin-top: 50px">
				<div class="form-group">
					<form:input path="name" class="form-control text-center" placeholder="Artist Name or Band" />
					<form:errors path="name" class="text-danger" />
				</div>
				<div class="form-group">
					<form:input path="hometown" class="form-control text-center" placeholder="Hometown"  />
					<form:errors path="hometown" class="text-danger" />
				</div>
				<div class="form-group">
					<form:input path="age" type="number" class="form-control text-center" placeholder="Age or if band how long have they been together" />
					<form:errors path="age" class="text-danger" />
				</div>
				<input type="submit" value="Add Artist"
					class="btn btn-sm btn-dark" />
			</form:form>
		</div>
	</div>
</body>
</html>