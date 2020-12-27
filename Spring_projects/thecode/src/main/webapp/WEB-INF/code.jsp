<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import = "java.io.*,java.util.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Secret Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron text-center p-3 m-5">
			<h1 class="text-center mx-auto"><i>Your secret message!</i></h1>
			<div class="d-flex justify-content-center">
				<ul>
					<li>Loyalty</li>
					<li>Courage</li>
					<li>Veracity</li>
					<li>Compassion</li>
					<li>Honor</li>
				</ul>
			</div>
			<a href="/reset" class="col-sm-3 btn btn-secondary mx-auto m-3">Start Over</a>
		</div>
	</div>
</body>
</html>