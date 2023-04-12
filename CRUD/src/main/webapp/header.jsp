<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Narvar -->
<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"> <img alt="Fashion"
			src="https://tse4.mm.bing.net/th?id=OIP.ZbP3SFRdKs9-9OwxsS1ymQHaHa&pid=Api&P=0"
			style="width: 10%">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home">Home</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="manage">Manage</a></li>
			</ul>
			<form action="search" method="post" class="d-flex" role="search">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search" name="txt" value="${search}">
				<button class="btn btn-outline-success" type="submit">Search</button>

			</form>
		</div>
	</div>
</nav>
<!-- End Narvar -->