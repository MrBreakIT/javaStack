<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Song Info</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">

<body style="background-color: lightslategray">
	<div class="container mx-auto text-center m-5">
		<div class="card mx-auto">
			<div class="card-body m-2">
				<h2 class="card-title">"${song.title}"</h2>
				<h4 class="card-title">Artist: ${song.artist}</h4>
				<h4 class="card-title">Fan Rating: ${song.rating}</h4>

				<a href="/dashboard" class="btn btn-sm btn-dark">Dashboard</a>
				<a href="/edit/song/${song.id}" class="btn btn-sm btn-dark">Edit</a>
				<a href="/song/destroy/${id}" class="btn btn-sm btn-dark">Delete</a>
			</div>
		</div>
	</div>
</body>
</html>