<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-lg-3">
		<!-- Menu left -->
		<h3>Category</h3>
		<c:forEach items="${listC }" var="c">
			<a href="category?cateId=${c.cid}"
				class="list-group-item list-group-item-action">${c.cname }</a>
		</c:forEach>

		<c:forEach begin="1" end="3" step="1">
			<a href="category?cid=${c.cid}"
				class="list-group-item list-group-item-action">Men fashion</a>
		</c:forEach>
		<!-- End menu left -->
		
		<!-- Last product -->
		<h3>Latest Product</h3>
		<div class="col-lg-4 col-md-6 md-4">
			<div class="card h-100" style="width: 18rem;">
				<img
					src="${latest.image }"
					class="card-img-top" alt="${latest.name }">
				<div class="card-body">
					<h5 class="card-title">
						<a href="detail?pid=${p.id}">${latest.name }</a>
					</h5>
					<p class="card-text">${latest.price }</p>
					<p class="card-text">${latest.title }</p>
					<p class="card-text">${latest.description }</p>
					<a href="#" class="btn btn-primary">Buy now</a>
				</div>
			</div>
		</div>
		
		<div class="col-lg-4 col-md-6 md-4">
			<div class="card h-100" style="width: 18rem;">
				<img
					src="https://tse1.mm.bing.net/th?id=OIP.JW5s2BMxnSi2msPsZ-xaIAHaJf&pid=Api&P=0"
					class="card-img-top" alt="White Shirt">
				<div class="card-body">
					<h5 class="card-title">
						<a href="detail?pid=${p.id}">White Shirt</a>
					</h5>
					<p class="card-text">$120</p>
					<p class="card-text">Shirt</p>
					<p class="card-text">Beautiful.</p>
					<a href="#" class="btn btn-primary">Buy now</a>
				</div>
			</div>
		</div>
		<!-- End latest product -->
	</div>
</body>
</html>