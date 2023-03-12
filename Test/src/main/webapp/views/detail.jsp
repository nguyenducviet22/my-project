<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online</title>
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
			<!-- Menu left -->
			<%@include file="left.jsp"%>
			<!-- End menu left -->
			<div class="col-lg-4 col-md-6 md-4">
				<div class="card h-100" style="width: 18rem;">
					<img src="views/image/product/1.png" class="card-img-top"
						alt="White Shirt">
					<div class="card-body">
						<h5 class="card-title">White Shirt</h5>
						<p class="card-text">$120</p>
						<p class="card-text">Shirt</p>
						<p class="card-text">Beautiful.</p>
						<a href="#" class="btn btn-primary">Buy now</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@include file="footer.jsp"%>
	<!-- End Footer -->
</body>
</html>