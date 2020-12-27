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
<title>Idea Board</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: lightgray">
	<div class="container">
		<div class="jumbotron text-center mt-5">
			<h1 class="text-center">
				Welcome, <i>${user.firstName} ${user.lastName}</i>
			</h1>
			<a href="/logout" class="btn btn-sm btn-outline-danger">Logout</a>
		</div>
		<div class="mt-3">
			<h4>Ideas</h4>
		</div>
		<div class="col mx-auto m-3">
			<table class="table table-dark table-hover rounded">
				<tr>
					<th>Ideas</th>
					<th>Created By</th>
					<th>Likes</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${allIdeas}" var="idea">
					<tr>
						<td><a href="idea/${idea.id}">${idea.idea}</a></td>
						<td class="">${idea.name}</td>
						<td class="">${user.firstName}</td>
						<td ><a href="#">${user.lastName}</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="mt-5">
			<div class="mt-5">
				<h3>Create a new idea</h3>
			</div>
			<form:form action="/ideas/new" method="post" modelAttribute="newIdea">
				<form:input path="idea" class="form-control col-sm-4"
					placeholder="Your Idea" />
				<form:errors path="idea" class="text-danger" />
				<input type="submit" value="Create an Idea"
					class="btn btn-sm btn-success" />
			</form:form>
		</div>
	</div>

</body>
</html>