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
<title>Create a new Idea</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: lightgray">


	<h3>Edit: <c:out value="${idea.content}"/></h3>
		<c:out value="${error}" />

		<form:form action="/ideas/${idea.id}/edit" method="post" modelAttribute="updatedidea">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="content">Idea: </form:label>
				<form:input path="content" />
			</p>
			<p>
				<form:errors class="text-danger" path="content" />
			</p>
			<input type="submit" value="Update Idea" />
		</form:form>
		<p></p>
		<form action="/ideas/${idea.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" class="btn btn-danger" value="Delete">
		</form>
	
</body>
</html>