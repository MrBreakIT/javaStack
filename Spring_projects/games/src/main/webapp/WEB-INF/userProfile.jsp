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
	<div class="container mt-5">
		<div class="card rounded">
			<div class="card-header bg-dark text-light">
				<i>${user.firstName} ${user.lastName}</i>
				<div class="card-body">
					<p>Email: ${user.email}</p>
					<p>Member since: ${user.createdAt}</p>
					<p>Games uploaded: ${user.games.size()}</p>
					<p>Number of Reviews left: ${user.reviews.size()}</p>
					<h5><i>Games left to review!</i></h5>
					<ul>
						<c:forEach items="${gamesToReview}" var="game">
							<li><a href="/game/${game.id}">${game.title}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<a href="/home" class="btn btn-sm btn-success">Home</a>
	</div>
</body>
</html>