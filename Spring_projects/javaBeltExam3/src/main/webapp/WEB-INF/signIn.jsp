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
<title>Register/Sign-In</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body style="background-color: lightgray">
	<div class="container mt-5">
		<div class="jumbotron rounded ">
			<h1 class="text-center">Welcome to TV-Landia!!!</h1>
		</div>
		<c:if test="${user != null}">
			<div class="alert alert-info">Welcome back, ${user.firstName}!</div>
		</c:if>
		<div class="row">
			<div class="col-sm-8">
				<div class="card">
					<div class="card-header bg-dark text-light">Register</div>
					<div class="card-body">
						<form:form action="/register" method="post"
							modelAttribute="registeringUser">
							<!-- modelAtt comes from the controller -->
							<div class="row">
								<div class="form-group col-sm-6">
									<form:input path="firstName" class="form-control"
										placeholder="First Name" />
									<form:errors path="firstName" class="text-danger" />
								</div>
								<div class="form-group col-sm-6">
									<form:input path="lastName" class="form-control"
										placeholder="Last Name" />
									<form:errors path="lastName" class="text-danger" />
								</div>
							</div>
							<div class="form-group">
								<form:input path="email" class="form-control"
									placeholder="Email" />
								<form:errors path="email" class="text-danger" />
							</div>
							<div class="row">
								<div class="form-group col-sm-6">
									<form:input type="password" path="password"
										class="form-control" placeholder="Password" />
									<form:errors path="password" class="text-danger" />
								</div>
								<div class="form-group col-sm-6">
									<form:input type="password" path="confirmPW"
										class="form-control" placeholder="Confirm Password" />
									<form:errors path="confirmPW" class="text-danger" />
								</div>
							</div>
							<input type="submit" value="Register" class="btn btn-primary" />
						</form:form>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="card">
					<div class="card-header bg-dark text-light">Login</div>
					<div class="card-body">
						<form:form action="/login" method="post"
							modelAttribute="loginUser">
							<!-- modelAtt comes from the controller -->
							<div class="form-group">
								<form:input path="email" class="form-control"
									placeholder="Email" value="john@email.com"/>  <!-- NeatTrick but TAKE VALUE OUT -->
								<form:errors path="email" class="text-danger" />
							</div>
							<div class="form-group">
								<form:input type="password" path="password" class="form-control"
									placeholder="Password" value="123456" /> <!-- Neat trick butTAKE VALUE OUT -->
								<form:errors path="password" class="text-danger" />
							</div>
							<input type="submit" value="Login" class="btn btn-primary" />
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>