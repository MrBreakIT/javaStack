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
        <h1>Date Example- Plan your party!</h1>
        <div class="card-body"></div>
        <form:form action="/dateExample" method="post" modelAttribute="newDateExample">
            <div class="form-group">
                <label>Party:</label>
                <form:input path="party" class="form-control" />
                <form:errors path="party" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Start:</label>
                <form:input type="date" path="start" class="form-control" />
                <form:errors path="start" class="text-danger" />
            </div>
            <input type="submit" value="Plan your party!" class="btn btnsm btn-success" />
        </form:form>
    </div>
</body>

</html>