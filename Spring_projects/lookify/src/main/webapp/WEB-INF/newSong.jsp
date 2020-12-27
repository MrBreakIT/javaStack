<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<body style="background-color: lightslategray">
	<div class="container">
		<h1>Add new song</h1>
		<form:form action="/create/song" method="post"
			modelAttribute="newSong">
			<div class="form-group">
				<label>Artist: </label>
				<form:input path="artist" class="form-control text-center" placeholder="Add Artist" />
				<form:errors path="artist" class="text-danger" />
			</div>
			<div class="form-group">
				<label> Title: </label>
				<form:input path="title" class="form-control text-center" placeholder="Add Title" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="form-group">
			<label>Rating: </label>
				<form:input path="rating" type="number" class="form-control text-center" placeholder="Add Rating 1-100" />
				<form:errors path="rating" class="text-danger" />
			</div>
			<input type="submit" value="Add Song" class="btn btn-sm btn-dark">
		</form:form>
		<a href="/dashboard" class="btn btn-sm btn-dark">Dashboard</a>
	</div>
</body>
</html>