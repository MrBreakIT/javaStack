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
    <script type="text/javascript" src="js/app.js"></script>
    <link rel="stylesheet"  type= "text/css" href="css/styles.css">
</head>

<body>
<div class="container">
	<div class="jumbotron text-center">
		<h1>Today's Date</h1>			
		<p><fmt:formatDate pattern = "E,d-M-yy" value = "${date}" /></p>	
		<form action= "/home" method="get">
				<input type="submit" value="HOME" />
		</form>			
	</div>
	
	
</div>
</body>
</html>