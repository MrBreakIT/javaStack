<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Lookify</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body style="background-color: gray">
	<div class="container">
		<div class="jumbotron col mx-auto text-center m-2" style="background-color: steelblue">
			<h1>Lookify</h1>
			<h3><i>(It's like Spotify, only crappier!)</i></h3>
		</div>
		<div class="col mx-auto m-20">
			<a href="/dashboard" class="col btn btn-large btn-dark mx-auto">Take the Journey</a>
		</div>
	</div>
</body>
</html>