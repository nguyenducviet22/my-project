<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Products</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
	crossorigin="anonymous"></script>
</head>
<body>
	<!-- Narvar -->
	<%@include file="header.jsp"%>
	<!-- End Narvar -->
	<!-- Page content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-9">
				<!-- Product -->
				<c:forEach items="${list }" var="p">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Image</th>
								<th scope="col">Name</th>
								<th scope="col">Price</th>
								<th scope="col">Amount</th>
								<th scope="col">Title</th>
								<th scope="col">Description</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">${p.id }</th>
								<td><img src="${p.image }" class="card-img-top"
									style="width: 200px" alt="${p.name }"></td>
								<td>${p.name }</td>
								<td>@mdo</td>
							</tr>
						</tbody>
					</table>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">${p.id }</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">Image</th>
								<td><img src="${p.image }" class="card-img-top"
									style="width: 200px" alt="${p.name }"></td>
							</tr>
							<tr>
								<th scope="row">Name</th>
								<td>${p.name }</td>
							</tr>
							<tr>
								<th scope="row">Price</th>
								<td>${p.price }</td>
							</tr>
							<tr>
								<th scope="row">Amount</th>
								<td>${p.amount }</td>
							</tr>
							<tr>
								<th scope="row">Title</th>
								<td>${p.title }</td>
							</tr>
							<tr>
								<th scope="row">Description</th>
								<td>${p.description }</td>
							</tr>
						</tbody>
					</table>
				</c:forEach>
				<!-- End Product -->
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@include file="footer.jsp"%>
	<!-- End Footer -->
</body>
</html>