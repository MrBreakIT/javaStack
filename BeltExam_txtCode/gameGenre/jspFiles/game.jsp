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
    <title>Games and Genres</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: lightgray">
    <h1 class="text-center">${title}</h1>
    <div class="row">
        <div class="col-sm-3 mx-auto m-3">
            <form:form action="/games/new" method="post" modelAttribute="newGamePlus">
                <div class="form-group">
                    <form:input path="title" class="form-control" placeholder="Title" />
                    <form:errors path="title" class="text-danger" />
                </div>
                <div class="form-group">
                    <form:input path="studio" class="form-control" placeholder="Studio" />
                    <form:errors path="studio" class="text-danger" />
                </div>
                <div class="form-group">
                    <form:input path="year" class="form-control" placeholder="Year Release" />
                    <form:errors path="year" class="text-danger" />
                </div>
                <div class="form-group">
                    <form:input path="genresInput" class="form-control" placeholder="Genre/Category" />
                    <form:errors path="genresInput" class="text-danger" />
                </div>
                <input type="submit" value="Add Game" class="btn btn-sm btn-outline-success" />
                <a href="/user" class="btn btn-sm btn-outline-success">Check your profile!</a>
            </form:form>
        </div>
        <div class="col-sm-7 mx-auto m-3">
            <table class="table table-dark table-hover rounded">
                <tr>
                    <th>Title</th>
                    <th>Studio</th>
                    <th>Year</th>
                    <th>Genres</th>
                    <th>Rating</th>
                </tr>
                <c:forEach items="${allGames}" var="game">
                    <tr>
                        <td><a href="game/${game.id}">${game.title}</a></td>
                        <td class="">${game.studio}</td>
                        <td class="">${game.year}</td>
                        <td class="">${game.genreDescription()}</td>
                        <td class="w-5">${game.getAverageRating()}</td>
                    </tr>
                </c:forEach>
            </table>
            <a href="/home" class="btn btn-sm btn-success">Refresh page</a>
            <a href="/logout" class="btn btn-sm btn-danger">Log Out</a>
        </div>
    </div>

</body>

</html>