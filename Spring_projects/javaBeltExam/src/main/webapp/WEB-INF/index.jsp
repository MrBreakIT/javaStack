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
<title>Idea Board</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: lightgray">

	<h1>
		Welcome
		<c:out value="${user.name}" />
	</h1>
	<a href="/logout">Logout</a>


	<h4>Ideas</h4>


	<table class="table table-hover">
		<thead class="thead-dark">
			<tr>
				<th>Idea</th>
				<th>Created By</th>
				<th>Likes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allIdeas}" var="idea">
				<tr>
					<td><a href="/ideas/${idea.id }"> <c:out
								value="${idea.content}" />
					</a></td>
					<td><c:out value="${idea.creator.name}" /></td>
					<td><c:out value="${idea.likedUser.size()}" /></td>
					<td><c:choose>
							<c:when test="${idea.likedUser.contains(user)==false}">
								<form action="/ideas/${idea.id}/like" method="post">
									<input type="submit" value="Like">
								</form>
							</c:when>
							<c:otherwise>
								<form action="/ideas/${idea.id}/unlike" method="post">
									<input type="submit" value="Unlike">
								</form>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>




	<a href="/ideas/new">Create an idea</a>

</body>
</html>