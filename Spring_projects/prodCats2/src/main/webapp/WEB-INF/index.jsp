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
<title>Products and Categories v.2</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: #40798C">
	<div class="container col-10">
		<div class="jumbotron mt-2 text-center mx-auto"
			style="padding-top: 30px; padding-bottom: 30px; background-color: #eeee">
			<h1>Products and Categories v.2</h1>

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-link btn btn-sm btn-outline-primary m-1" href="#">View
					Products</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a
							class="navbar-link btn btn-sm btn-outline-primary m-1" href="#">View
								Category <span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a
							class="navbar-link btn btn-sm btn-outline-danger m-1" href="#">Log
								Out</a></li>
					</ul>
					<form action="#" class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="text"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-sm btn-outline-success my-2 my-sm-0"
							type="submit">Search</button>
					</form>
				</div>
			</nav>
		</div>
		<div class="col-12 d-flex justify-content-around mt-3">
			<div class="left side d-flex justify-content-around m-2">
				<div class="col-sm-8 card form-group m-2"
					style="background-color: #eeee">
					<div class="card-body col-sm text-center">
						<h2 class="card-title text-center">New Product</h2>
						<form:form action="/" method="post"
							modelAttribute="newProductPlus" class="card-text">
							<form:input path="name" placeholder="Product Name"
								class="form-control m-2" />
							<form:errors path="name" class="text-danger" />
							<form:textarea path="description" rows="5" cols="30"
								placeholder="Product Description" class="form-control m-2" />
							<form:errors path="description" class="text-danger" />
							<form:input path="price" placeholder="Current Price"
								class="form-control m-2" />
							<form:errors path="price" class="text-danger" />
							<form:input path="categoryInput" placeholder="Product Category"
								class="form-control m-2" />
							<form:errors path="categoryInput" class="text-danger" />
							<input type="submit" value="Add Product"
								class="col-6 btn btn-sm btn-outline-primary form-control m-2" />
						</form:form>
					</div>
				</div>
				<div class="col-sm-8 card form-group m-2"
					style="background-color: #eeee">
					<div class="col-sm  m-3">
						<div class="card-body col-sm text-center">
							<h2 class="card-title text-center">New Category</h2>
							<table class="table table-border table-light table-hover rounded">
								<tr style="background-color: #eeee">
									<th>Product Name</th>
									<th>Description</th>
									<th>Product Price</th>
									<th>Category</th>
								</tr>
								<c:forEach items="${allProducts}" var="product">
									<tr>
										<td>${product.name}</td>
										<td>${product.description}</td>
										<!-- make <a> tag linking to a products-description jsp -->
										<td>${product.price}</td>
										<td>${product.categoryDescription()}</td>
										<!-- use function to return String value -->
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</html>