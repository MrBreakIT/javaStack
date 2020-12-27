<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import = "java.io.*,java.util.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body class="" style="background-color:gray">
	<div class="container text-center">
		<div class="jumbotron text-center p-3 m-5" >
			<h1  class="text-center text-primary">Dojo Survey (coming at you LIVE)</h1>
		</div>
		
		<form action="/survey/validate" method="post" >
		  <div class="form-group row">
		    <label for="name" class="col-sm-2 col-form-label">Name:</label>
		    <div class="col-sm-8 mx-auto">
		      <input type="text" class="form-control" name="name" placeholder="Name">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="dojo location" class="col-sm-2 col-form-label">Dojo Location:</label>
		   	<div class="col-sm-8 mx-auto">
	   			<select name="location" class="custom-select col">
				  <option value= "Select Loa">--Dojo Location--</option>
				  <option value="Arlington, VA">Arlington, VA</option>
				  <option value="Bellevue, WA">Bellevue, WA</option>
				  <option value="Boise, ID">Boise, ID</option>
				  <option value="Chicago, IL">Chicago, IL</option>
				  <option value="Dallas, TX">Dallas, TX</option>
				  <option value="Los Angeles, CA">Los Angeles, CA</option>
				  <option value="Oakland, CA">Oakland, CA</option>
				  <option value="Orange County, CA">Orange County, CA</option>
				  <option value="San Jose, CA">San Jose, CA</option>
				  <option value="Tulsa, OK">Tulsa, OK</option>
				  <option value="Online">Online</option>
				</select>
		    </div>
		  </div>
	  	<div class="form-group row">
	    	<label for="favorite language" class="col-sm-2 col-form-label">Favorite Language:</label>
	   		<div class="col-sm-8 mx-auto">
			    <select name="language" class="custom-select col">
				  <option value="Select Language">--Favorite Computer Language--</option>
				  <option value="Java">Java</option>
				  <option value="C#">C#</option>
			  	  <option value="C++">C++</option>
				  <option value="MERN">MERN</option>
				  <option value="Python">Python</option>
				  <option value="Javascript">Javascript</option>
				  <option value="PHP">PHP</option>
				  <option value="Ruby">Ruby</option>
				</select>			      	
	  		</div>
  	  	</div>
		<div class="form-group col-sm-12 mx-auto">
		  <label for="textarea">Comment (Optional)</label>
		  <textarea class="form-control" name="comment" rows="3" placeholder="Write something here..."></textarea>
		</div>
		<input type="submit" value="Submit" class="btn btn-primary rounded float-right"/>
		</form>
	</div>
	
</body>
</html>