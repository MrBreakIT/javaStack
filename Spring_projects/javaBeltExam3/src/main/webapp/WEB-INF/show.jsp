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
    <title>TV Shows and Networks</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: lightgray">
    <h1 class="text-center">${title}</h1>
    <div class="row">
        <div class="col-sm-3 mx-auto m-3">
            <form:form action="/shows/new" method="post" modelAttribute="newShowPlus">
                <div class="form-group">
                    <form:input path="title" class="form-control" placeholder="TV Show" />
                    <form:errors path="title" class="text-danger" />
                </div>
                <!--<div class="form-group">
                    <form:input path="network" class="form-control" placeholder="Network" />
                    <form:errors path="network" class="text-danger" />
                </div>  -->
                <div class="form-group">
                    <form:input path="network" class="form-control" placeholder="Network" />
                    <form:errors path="network" class="text-danger" />
                </div>
                <input type="submit" value="Add Show" class="btn btn-sm btn-outline-success" />
                <a href="/user" class="btn btn-sm btn-outline-success">Check your profile!</a>
            </form:form>
        </div>
        <div class="col-sm-7 mx-auto m-3">
            <table class="table table-dark table-hover rounded">
                <tr>
                    <th>TV Show</th>
                    <th>Network</th>
                    <th>Rating</th>
                </tr>
                <c:forEach items="${allShows}" var="show">
                    <tr>
                        <td><a href="/show/${show.id}">${show.title}</a></td>
                        <td class="">${show.network}</td>
                        <td class="w-5">${show.getAverageRating()}</td>
                    </tr>
                </c:forEach>
            </table>
            <a href="/home" class="btn btn-sm btn-success">Refresh page</a>
            <a href="/logout" class="btn btn-sm btn-danger">Log Out</a>
        </div>
    </div>

</body>

</html>