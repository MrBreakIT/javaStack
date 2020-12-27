<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Date/Time</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<div class="jumbotron text-center p-5 m-5">
		<h1>Display the Date / Time</h1>		
	<div class="alert alert-dark col-4 mx-auto m-3 p-1">Page views: ${pageViews}</div>
	</div>
	<div class="col d-flex justify-content-around mx-auto">
		<form action="/date" method="get" class="d-flex justify-content-around mx-auto">				
				<input type="submit" value="Date Template" class="btn btn-secondary" />
		</form>		
		
		<form action="/time" method="get" class="d-flex justify-content-around mx-auto">	
				<input type="submit" value="Time Template" class="btn btn-secondary" />
		</form>		
		
	</div>
	
</div>
</body>
</html>