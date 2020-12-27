<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Motorcycles</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Motorcycles</h1>
			<p>The date/time is currently... <fmt:formatDate type = "both" dateStyle = "long" timeStyle = "long" value = "${date}" /></p>
		</div>
		
		<div class="row">
			<div class="col-sm-8">
				<ul class="list-group">
					<li class="list-group-item bg-dark text-light">Motorcycles</li>
					<c:forEach items="${bikes}" var="bike" varStatus="loop">
						<li class="list-group-item">
							${bike}
							<a href="/view/${loop.index}" class="btn btn-secondary btn-sm float-right">View</a>
						</li>
					</c:forEach>
				</ul>			
			</div>
			<div class="col-sm-4">
				<form action="/new" method="get">
					<div class="form-group">
						<label>Bike Name: </label>
						<input type="text" name="name" class="form-control" />
					</div>
					<input type="submit" value="add bike" class="btn btn-secondary btn-block" />
					
				</form>
			</div>
			
		</div>
		
	</div>
</body>
</html>

