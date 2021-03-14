<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
 <%@ page import = "java.io.*,java.util.*" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container text-center">
		<div class="jumbotron p-3 m-5" style="background-color: #6c757d">
			<h1 class="text-center">Welcome to Page Hit-Count!</h1>
			  <div class="alert alert-light text-center text-dark" style="background-color: green; font-weight:bold">Page views: ${pageViews}
			  </div> 			       	
		</div>
		<a href="/counter" class="col-sm-6 btn btn-secondary mx-auto m-2">Counter total</a>
	  <a href="/reset" class="col-sm-6 btn btn-secondary mx-auto m-2">Reset Counter</a> 
	</div>
</body>
</html>