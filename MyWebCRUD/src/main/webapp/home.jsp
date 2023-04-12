<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
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
			<!-- Slider and products -->
			<div class="col-lg-9">
				<!-- Slider -->
				<div id="carouselExampleCaptions" class="carousel slide">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleCaptions"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleCaptions"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleCaptions"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="image/slider/Design.png" class="d-block w-100"
								alt="Fashion Images">
							<div class="carousel-caption d-none d-md-block">
								<h5>First slide label</h5>
								<p>Some representative placeholder content for the first
									slide.</p>
							</div>
						</div>
						<div class="carousel-item">
							<img src="image/slider/Design1.png" class="d-block w-100"
								alt="Fashion Images">
							<div class="carousel-caption d-none d-md-block">
								<h5>Second slide label</h5>
								<p>Some representative placeholder content for the second
									slide.</p>
							</div>
						</div>
						<div class="carousel-item">
							<img src="image/slider/Design2.png" class="d-block w-100"
								alt="Fashion Images">
							<div class="carousel-caption d-none d-md-block">
								<h5>Third slide label</h5>
								<p>Some representative placeholder content for the third
									slide.</p>
							</div>
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
				<!-- End Slider -->
				<!-- Product -->
				<div id="content" class="row">
					<c:forEach items="${listP }" var="p">
						<div class="col-lg-4 col-md-6 md-4">
							<div class="card h-100" style="width: 18rem;">
								<img src="${p.image }" class="card-img-top" alt="${p.name }">
								<div class="card-body">
									<h5 class="card-title">
										<a href="detail?pid=${p.id}">${p.name }</a>
									</h5>
									<p class="card-text">${p.price }</p>
									<p class="card-text">${p.title }</p>
									<p class="card-text">${p.description }</p>
									<a href="#" class="btn btn-primary">Buy now</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- End Product -->
			</div>
			<!-- End Slider and products -->
		</div>
	</div>
	<!-- End Page content -->
	<!-- Footer -->
	<%@include file="footer.jsp"%>
	<!-- End Footer -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script type="text/javascript">
		function load(cateId) {
			$.ajax({
				url: "/Test/category",
				type: "get",
				data: {
					cid: cateId
					},
					success: function (responseData){
						document.getElementById("content").innerHTML = responseData;
						}
				});
		}
	</script>
</body>
</html>