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
<title>Show Program Language Info</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: gray">
	<div class="container">
		<div class="card mx-auto text-center m-5" style="box-shadow: 5px 10px black">
		<!-- <img class="card-img-top" src="/images/pathToYourImage.png" 	
				alt="Card image cap">-->
			<div class="card-body">
				<h4 class="card-title">${language.name}</h4>
				<p class="card-text">${language.creator }</p>
				<p class="card-text">${language.version }</p>
				<a href="/" class="btn btn-sm btn-dark">Dashboard</a>
				<a href="/edit/language/${id}" class="btn btn-sm btn-dark">Edit</a>
				<a href="/language/destroy/${id}" class="btn btn-sm btn-dark">Delete</a>
			</div>
		</div>

	</div>

</body>