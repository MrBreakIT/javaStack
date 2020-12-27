<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import = "java.io.*,java.util.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container text-center">
		<div class="jumbotron m-3" style="background-color:lightgray">
			<h1>Welcome to Ninja Gold</h1>
				<div class="d-flex justify-content-around col p-2">
					<h4>Your gold: </h4>
					<input name="gold" value="${player.gold}"/>
				</div>
		</div>
		<!-- <div class="jumbotron m-3" style="background-color:lightgray"> -->
		<div class=" col-12 d-flex justify-content-around">
			<form action="/action/farm" class="col" method="post">
				<div class="card col p-1 m-1">
					<h4 class="card-title">Farm</h4>
					<p class="card-text">(earns 0-30 gold)</p>					
					<button type="submit" class="btn btn-sm btn-secondary" name="farm">Find Gold!</button>
				</div>
			</form>
			<form action="/action/programming" class="col" method="post">
				<div class="card col p-1 m-1">
					<h4 class="card-title">Programming</h4>
					<p class="card-text">(earns 0-800 gold)</p>
					<button type="submit" class="btn btn-sm btn-secondary" name="cave">Find Gold!</button>
				</div>
			</form>
			<form action="/action/house" class="col" method="post">
				<div class="card col p-1 m-1">
					<h4 class="card-title">House</h4>
					<p class="card-text">(earns 0-10 gold)</p>
					<button type="submit" class="btn btn-sm btn-secondary" name="house">Find Gold!</button>
				</div>
			</form>	
			<form action="/action/casino" class="col" method="post">
				<div class="card col p-1 m-1">
					<h4 class="card-title">Casino</h4>
					<p class="card-text">(costs 10/gamble, returns??)</p>
					<button type="submit" class="btn btn-sm btn-secondary" name="casino">Find Gold!</button>
				</div>
			</form>
		</div>
		<div>			
			<h4 class="float-left">Activities: </h4>			
		</div>
		<div class="col-sm" id="overflow">
		<c:forEach items="${player.tasks}" var="task" varStatus="loop">
			<p>${task}
		</c:forEach>
		</div>
	</div>
			
</body>
</html>