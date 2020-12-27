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
<title>Games and Genres</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<h1 class="text-center">Games and Genres</h1>
	<div class="row">
		<div class="col-sm-5 mx-auto m-3">
			<form:form action="/games" method="post" modelAttribute="newGame">
				<div class="form-group">
					<form:input path="title" class="form-control" placeholder="Title" />
					<form:errors path="title" class="text-danger" />
				</div>
				<div class="form-group">
					<form:input path="studio" class="form-control" placeholder="Studio"/>
					<form:errors path="studio" class="text-danger" />
				</div>
				<div class="form-group">
					<form:input path="year" class="form-control" placeholder="Year Release"/>
					<form:errors path="year" class="text-danger" />
				</div>
				<input type="submit" value="Add Game"
					class="btn btn-sm btn-outline-primary" />
			</form:form>
		</div>
		<div class="col-sm-5 mx-auto m-3">
			<form:form action="/genres" method="post" modelAttribute="newGenre">
				<div class="form-group">
					<form:input path="name" class="form-control" placeholder="Genre Category"/>
					<form:errors path="name" class="text-danger" />
				</div>
				<input type="submit" value="Add Genre"
					class="btn btn-sm btn-outline-primary" />
			</form:form>
			<div class="col">
				<form action="/add_genre" method="post">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Game: </label>
						<div>
							<select name="game_id" class="form-control">
								<c:forEach items="${allGames}" var="game">
									<option value="${game.id}">${game.title}-
										(${game.year})</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Genre: </label>
						<div>
							<select name="genre_id" class="form-control">
								<c:forEach items="${allGenres}" var="genre">
									<option value="${genre.id}">${genre.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<input type="submit" value="Add Genre to Game"
						class="btn btn-sm btn-outline-primary" />
				</form>
			</div>
		</div>
	</div>
	<h3 class="text-center">
		<i>A collection of titles</i>
	</h3>
	<div class="row">
		<div class="col-sm-10 mx-auto">
			<div class="container m-2 col">
				<table class="table table-dark table-hover">
					<tr>
						<th>Title</th>
						<th>Studio</th>
						<th>Year</th>
						<th>Genres</th>
					</tr>
					<c:forEach items="${allGames}" var="game">
						<tr>
							<td>${game.title}</td>
							<td>${game.studio}</td>
							<td>${game.year}</td>
							<td>${game.genreDescription()}</td>
						</tr>
					</c:forEach>
				</table>
				<a href="/games/new" class="btn btn-sm btn-danger">Alternative entry- Games/Genre</a>
			</div>
			
		</div>
	</div>
</body>
</html>