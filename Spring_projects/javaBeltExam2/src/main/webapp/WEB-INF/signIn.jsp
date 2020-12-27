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
<title>Welcome</title>
</head>
<body style="background-color: lightgray">
	<div class="container mt-5">
		<div class="jumbotron rounded ">
			<h1 class="text-center">Welcome to the Idea's Board</h1>
		</div>
		<div class="row">
			<div class="col-sm-8 ">
				<div class="card">
					<div class="card-header bg-dark text-light">Register</div>
					<div class="card-body">
						<p>
							<form:errors class="text-danger" path="user.*" />
						</p>
						<form:form action="/registration" method="POST"
							modelAttribute="user">
							<div class="row">
								<div class="form-group col-sm-6">
									<p>
										<form:input type="name" path="name"
											placeholder="First & Last Name" class="form-control" />
									</p>
								</div>
								<div class="form-group col-sm-6">
									<p>
										<form:input type="email" path="email" placeholder="Email"
											class="form-control" />
									</p>
								</div>
								<div class="form-group col-sm-6">
									<p>
										<form:password path="password" placeholder="Password"
											class="form-control" />
									</p>
								</div>
								<div class="form-group col-sm-6">
									<p>
										<form:password path="passwordConfirmation"
											placeholder="Password Confirmation" class="form-control" />
									</p>
								</div>
								<input type="submit" value="Register!" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="card">
				<div class="card-header bg-dark text-light">Login</div>
				<div class="card-body">
					<p class="text-danger">
						<c:out value="${error}" />
					</p>
					<form method="post" action="/login">
						<div class="form-group col-sm-6">
							<p>
								<input type="text" id="email" name="email" placeholder="Email" />
							</p>
						</div>
						<div class="form-group col-sm-6">
							<p>
								<input type="password" id="password" name="password"
									placeholder="Password" />
							</p>
						</div>
						<input type="submit" value="Login!" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>