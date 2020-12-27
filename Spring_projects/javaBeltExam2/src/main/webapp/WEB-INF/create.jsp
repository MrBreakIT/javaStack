<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Create an idea</title>
</head>
<body class="mt-2 ml-3 mr-3">

	<h3>Create a new idea</h3>

	<form:form action="/ideas/new" method="post" modelAttribute="newidea">

		<p>
			<form:label path="content">Idea: </form:label>
			<form:input path="content" />
		</p>
		<p>
			<form:errors class="text-danger" path="content" />
		</p>
		<input type="submit" value="Create Idea!" />

	</form:form>

</body>
</html>