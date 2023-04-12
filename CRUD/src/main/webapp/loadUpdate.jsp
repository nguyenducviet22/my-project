<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
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
	<div class="container">
		<h1>Update Info</h1>
		<div class="text-center">
			<span class="red">${error }</span>
		</div>
		<form action="update" method="post">
			<div class="form-group">
				<label for="id">Id</label> <input type="text"
					class="form-control" id="id" name="id" value="${detail.id }"
					required="required" readonly="readonly"/>
			</div>
			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" name="name" value="${detail.name }"
					required="required" />
			</div>
			<div class="form-group">
				<label for="image">Image</label> <input type="text"
					class="form-control" id="image" name="image"
					value="${detail.image }" required="required" />
			</div>
			<div class="form-group">
				<label for="price">Price</label> <input type="text"
					class="form-control" id="price" name="price"
					value="${detail.price }" required="required" />
			</div>
			<div class="form-group">
				<label for="amount">Amount</label> <input type="text"
					class="form-control" id="amount" name="amount"
					value="${detail.amount }" required="required" />
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<textarea name="description" class="form-control"
					required="required">${detail.description }</textarea>
			</div>
			<div class="text-center">
				<button type="submit" value="Finish" class="btn btn-primary"
					id="finish" name="finish">Finish</button>
			</div>
		</form>
	</div>
</body>
</html>