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
    <div class="container mt-5">
        <div class="row">
            <div class="col-sm-4">
                <div class="card rounded">
                    <div class="card-header bg-dark text-light">
                        <h2 class="text-center">
                            <i>${someGame.title} Info</i>
                        </h2>
                    </div>
                    <div class="card-body">
                        <p>Studio: ${someGame.studio}</p>
                        <p>Year: ${someGame.year}</p>
                        <p>AVG Rating: ${someGame.getAverageRating()}</p>
                        <h5>
                            Genre:
                            <c:forEach items="${someGame.genres}" var="genre">
                                <a href="/genre/${genre.name}" class="badge badge-pill badge-primary">${genre.name}</a>
                            </c:forEach>
                        </h5>
                    </div>
                </div>
                <a href="/home" class="btn btn-md btn-outline-primary mt-3">Home</a>
            </div>
            <div class="col-sm-8">
                <div class="card rounded">
                    <div class="card-header bg-dark text-light">
                        <h2 class="text-center">
                            <i>Add a ${someGame.title} review, ${user.firstName}</i>
                        </h2>
                    </div>
                    <div class="card-body">
                        <form:form action="/game/${someGame.id}/review" method="post" modelAttribute="newReview">
                            <div class="row">
                                <div class="col-sm-4 form-group">
                                    <label>Rating</label> <select name="rating" class="form-control">
                                        <option>5</option>
                                        <option>4</option>
                                        <option selected>3</option>
                                        <option>2</option>
                                        <option>1</option>
                                    </select>
                                </div>
                                <div class="col-sm-8 form-group">
                                    <label>Review</label>
                                    <form:textarea path="content" var="content" class="form-control" />
                                    <form:errors path="content" class="text-danger" />
                                </div>
                            </div>
                            <input type="submit" value="Upload a --${someGame.title}-- Review"
                                class="btn btn-outline-primary btn-block">
                        </form:form>
                    </div>
                </div>
                <ul class="list-group mt-5">
                    <li class="list-group-item bg-dark text-light">Reviews:</li>
                    <c:forEach items="${someGame.reviews}" var="review">
                        <li class="list-group-item"><strong>${review.rating}
                                Stars</strong><br> ${review.user.firstName} says: <i>${review.content}</i></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</body>

</html>