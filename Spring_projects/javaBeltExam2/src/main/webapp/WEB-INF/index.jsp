<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Ideas</title>
</head>
<body class="mt-2 ml-3 mr-3">

	<h1> Welcome <c:out value="${user.name}" /></h1>
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
					<td>
						<a href="/ideas/${idea.id }">
							<c:out value="${idea.content}"/>
						</a>
					</td>
					<td><c:out value="${idea.creator.name}"/></td>
					<td><c:out value="${idea.likedUser.size()}"/></td>
					<td>
						<c:choose>
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
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	
	
	<a href="/ideas/new">Create an idea</a>

</body>
</html>