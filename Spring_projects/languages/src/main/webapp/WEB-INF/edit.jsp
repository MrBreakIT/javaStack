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
<title>Edit the Program Language</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: gray">
	<div class="container">
		<div class="card mx-auto text-center m-5">
		 <c:out value="${singleLang}"/>
		<form:form action="/edit/update/${singleLang.id}" method="post" modelAttribute="singleLang">
				<div class="form-group">
					<label>Language:</label>
					<form:input path="name" class="form-control" />
					<form:errors path="name" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Creator:</label>
					<form:input path="creator" class="form-control" />
					<form:errors path="creator" class="text-danger"/>
				</div>
				<div class="form-group">
					<label>Version:</label>
					<form:input path="version" class="form-control" />
					<form:errors path="version" class="text-danger"/>
				</div>
				<input type="submit" value="Confirm Edit" class="btn btn-sm btn-dark"/>
			</form:form>
		</div>
		</div>
		
</body>
</html>