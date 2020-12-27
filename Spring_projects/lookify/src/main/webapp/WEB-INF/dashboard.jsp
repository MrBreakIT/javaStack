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
</head>
<body style="background-color: gray">
	<div class="container">
		<nav class="navbar navbar-expand navbar-light bg-dark m-2 rounded">
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a
						class="nav-link btn btn-outline-success my-2 my-sm-0 m-1"
						href="/songs/new">Add New Title <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a
						class="nav-link btn btn-outline-success my-2 my-sm-0 m-1"
						href="/artist/new">Add New Artist <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a
						class="nav-link btn btn-outline-success my-2 my-sm-0 m-1"
						href="/songs/top/10">Top Songs</a></li>
					<li class="nav-item active"><a
						class="nav-link btn btn-outline-success my-2 my-sm-0 m-1"
						href="">Log Out</a></li>
				</ul>
				<form:form action="/dashboard" method="get"
					class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="text"
						placeholder="Search" name="search" aria-label="Search">
					<button type="submit" value="search"
						class="btn btn-outline-success my-2 my-sm-0">Search
						Artist or Title</button>
				</form:form>
			</div>
		</nav>
		<div>
			<table
				class="table text-center table-dark table-striped table-hover rounded overflow-hidden">
				<tr>
					<th style="width: 300px">Artist</th>
					<th style="width: 300px">Title</th>
					<th style="width: 300px">Rating</th>
					<th style="width: 150px">Action</th>
				</tr>
				<c:forEach items="${song}" var="song">
					<tr>
						<td><a href="/artist/${artist.id}">${song.artist}</a></td>
						<td><a href="/song/${song.id}">${song.title}</a></td>
						<td>${song.rating}</td>
						<td><a href="/song/destroy/${song.id}"
							class="btn btn-sm btn-outline-danger">&times;</a></td>

					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

</body>
</html>