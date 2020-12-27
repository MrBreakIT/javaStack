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

	<h3>
		<c:out value="${idea.content}" />
	</h3>
	<p>
		Created By:
		<c:out value="${idea.creator.name}" />
	</p>

	<h5>User who have liked your idea:</h5>

	<div class="row">
		<div class="col-md-4">
			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th>Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${idea.likedUser}" var="user">
						<tr>
							<td><c:out value="${ user.name}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<a href="/ideas/${idea.id }/edit">Edit</a>

</body>
</html>