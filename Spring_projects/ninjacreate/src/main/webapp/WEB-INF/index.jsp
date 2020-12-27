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
<title>Ninja Info</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: lightslategray">
	<div class="container text-center" >
		<h1 class="text-center">Enter the Ninja</h1>
		<img src="/images/NinjaPic.jpg" alt="ninja pic" class="rounded mx-auto d-block"/>
		<a href="/ninjas/top/3" class="btn btn-md btn-outline-light col-3 d-block mx-auto m-2">Top 3 Ninjas (Click Here)</a>
		<a href="/techs/new" class="btn btn-md btn-outline-dark col-3 d-block mx-auto m-2">Add a Special Technique</a>
		<form action="/" method="get">
			<input type="text" placeholder="search ninjas" name="search" />
			<input type="submit" value="Search" class="btn btn-sm btn-dark" />
		</form>
		<div class="row mt-5 d-flex justify-content-between">
			<div class="col-sm-4">
				<form:form action="/ninja" method="post" modelAttribute="newNinja">	
					<div class="form-group">
						<label>Name:</label>
						<form:input path="name" class="form-control" />
						<form:errors path="name" class="text-danger" />
					</div>
					<div class="form-group">
						<label>Home-town:</label>
						<form:input path="hometown" class="form-control" />
						<form:errors path="hometown" class="text-danger" />
					</div>
					<div class="form-group">
						<label>Level:</label>
						<form:input path="level" type="number" class="form-control" />
						<form:errors path="level" class="text-danger" />
					</div>
					<input type="submit" value="Add Ninja" class="btn btn-sm btn-dark"/>
				</form:form>
			</div>
			<div class="col-sm-7">
				<table class="table height-500px table-dark table-striped table-hover rounded overflow-hidden">
					<tr>
						<th>Name</th>
						<th>Home-town</th>
						<th>Level</th>
						<th>Techniques</th>
						<th style="width:50px">Action</th>
					</tr>
					<c:forEach items="${ninjas}" var="ninja">
						<tr>
							<td><a href="/ninja/show/${ninja.id}">${ninja.name}</a></td>
							<td>${ninja.hometown}</td>
							<td>${ninja.level}</td>
							<td>${ninja.techniques.size()}</td>
							<td><a href="/ninja/destroy/${ninja.id}" class="btn btn-sm btn-outline-danger">&times;</a></td>
						</tr>
					</c:forEach>
				</table>				
			</div>
		</div>
		
	</div>
</body>
</html>