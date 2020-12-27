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
	<div class="container text-center">
		<h1 class="text-center">Enter New Technique</h1>
		<img src="/images/NinjaPic.jpg" alt="ninja pic"
			class="rounded mx-auto d-block" /> <a href="/"
			class="btn btn-md btn-dark col-3 d-block mx-auto m-2">Take me
			back HOME</a>
		<div class="row mt-5 d-flex justify-content-between">
			<div class="col-sm-8 text-center mx-auto">
				<form:form action="/techs" method="post" modelAttribute="newTech">
					<div class="form-group">
						<label>Technique Name:</label>
						<form:input path="name" class="form-control" />
						<form:errors path="name" class="text-danger" />
					</div>
					<div class="form-group">
						<label>Ninja:</label> 
						<select name="ninja" class="form-control">
							<c:forEach items="${allNinjas}" var="ninja">
								<option value="${ninja.id}">${ninja.name}</option>
							</c:forEach>

						</select>
					</div>

					<input type="submit" value="Add Technique"
						class="btn btn-sm btn-dark" />
				</form:form>
			</div>

		</div>

	</div>
</body>
</html>