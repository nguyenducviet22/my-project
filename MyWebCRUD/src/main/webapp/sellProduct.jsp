<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seller Products</title>
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
				<h2>Manage All Products</h2>
				<div class="text-right">
					<a href="#addProduct" class="btn btn-success" data-toggle="modal">Add
						new Product</a>
				</div>
				<!-- Product -->
				<table class="table">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Image</th>
						<th scope="col">Name</th>
						<th scope="col">Price</th>
						<th scope="col">Amount</th>
						<th scope="col">Title</th>
						<th scope="col">Description</th>
					</tr>
					<c:forEach items="${list }" var="p">
						<tr>
							<td scope="row">${p.id }</td>
							<td><img src="${p.image }" class="card-img-top"
								style="width: 200px" alt="${p.name }"></td>
							<td>${p.name }</td>
							<td>${p.price }</td>
							<td>${p.amount }</td>
							<td>${p.title }</td>
							<td>${p.description }</td>
							<td><a href="loadInfo?pid=${p.id }">Edit</a> <a
								href="delete?pid=${p.id }">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
				<!-- End Product -->


				<!-- Add product Form -->
				<!-- <div id="addProduct" class="modal" >
					<div class="modal-dialog" role="document">
						<div class="modal-content"> -->
				<form action="add" method="post">
					<div class="text-center">
						<h1>Insert Product</h1>
					</div>
					<!-- <div class="modal-header">
									<h5 class="modal-title">Add product</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body"> -->
					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							class="form-control" id="name" name="name" value="${name }"
							required="required" />
					</div>
					<div class="form-group">
						<label for="image">Image</label> <input type="text"
							class="form-control" id="image" name="image" value="${name }"
							required="required" />
					</div>
					<div class="form-group">
						<label for="price">Price</label> <input type="text"
							class="form-control" id="price" name="price" value="${price }"
							required="required" />
					</div>
					<div class="form-group">
						<label for="amount">Amount</label> <input type="text"
							class="form-control" id="amount" name="amount" value="${amount }"
							required="required" />
					</div>
					<div class="form-group">
						<label for="title">Title</label> <input type="text"
							class="form-control" id="title" name="title" value="${title }"
							required="required" />
					</div>
					<div class="form-group">
						<label for="description">Description</label>
						<textarea name="description" class="form-control"
							value="${description }" required="required"></textarea>
					</div>
					<div class="form-group">
						<label for="category">Categories</label> <select name="category">
							<option></option>
							<c:forEach items="${listC }" var="c">
								<option value="${c.cid }">${c.cname }</option>
							</c:forEach>
						</select>
					</div>
					<!-- </div>
								<div class="modal-footer"> -->
					<div class="text-center">
						<button type="submit" value="Add" class="btn btn-primary" id="add"
							name="add">Add</button>
					</div>
					<!-- </div> -->
				</form>
				<!-- </div>
					</div>
				</div> -->
				<!-- End Add product Form -->
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@include file="footer.jsp"%>
	<!-- End Footer -->
</body>
</html>