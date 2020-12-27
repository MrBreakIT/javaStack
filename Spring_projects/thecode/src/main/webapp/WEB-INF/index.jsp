<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import = "java.io.*,java.util.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Code</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container text-center">
		<div class="jumbotron text-center p-3 m-5">
			<h1 class="text-center">Enter if you must, Enter if you can!</h1>
			  <div class="col-5 alert alert-light mx-auto">Page views: ${pageViews}
			  </div> 			       	
		</div>	
		<div>
			<h3>Dare to enter secret code?</h3>
				<form action= "/code" method="post" >
					<div>
						<input type="text" name="code" />
						<input type="submit" value="Best Guess?" />
					</div>
				</form>
				<div class="col-8 card mx-auto bg-danger text-white m-2">
				<c:forEach items="${bestGuess}" var="bestGuess" varStatus="loop">
	                <div class="col text-center text-light"><h1>${loop.index +1} : ${bestGuess}</h1></div>
	            </c:forEach>
               </div>
		</div>
	</div>
</body>
</html>