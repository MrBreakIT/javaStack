<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Idea</title>
</head>
<body class="mt-2 ml-3 mr-3">

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