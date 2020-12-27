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
<title>Programming Languages</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: gray">
	<div class="container">
		<div class="col mx-auto text-center">
			<h1>Programming Languages</h1>
			<div style="overflow-y: auto; height: 410px; box-shadow:5px 5px 5px 5px black; table-header: sticky">
				<table
					class="table table-dark table-striped table-hover">
					<tr>
						<th>Name</th>
						<th>Creator</th>
						<th>Version</th>
						<th>Action</th>
					</tr>
					<c:forEach items="${lang}" var="language">
						<tr>
							<td><a href="/language/show/${language.id}">${language.name}</a></td>
							<td>${language.creator}</td>
							<td>${language.version}</td>
							<td><a href="/edit/language/${language.id}">Edit</a> || <a
								href="/language/destroy/${language.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<form:form action="/create/language" method="post"
				modelAttribute="newLang" style="margin-top: 50px">
				<div class="form-group">
					<form:input path="name" class="form-control text-center" placeholder="Add a Language" />
					<form:errors path="name" class="text-danger" />
				</div>
				<div class="form-group">
					<form:input path="creator" class="form-control text-center" placeholder="Add creator's name"  />
					<form:errors path="creator" class="text-danger" />
				</div>
				<div class="form-group">
					<form:input path="version" class="form-control text-center" placeholder="Add language version" />
					<form:errors path="version" class="text-danger" />
				</div>
				<input type="submit" value="Add Language"
					class="btn btn-sm btn-dark" />
			</form:form>

		</div>
	</div>
</body>
</html>