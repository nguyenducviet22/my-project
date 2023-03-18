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
				<c:if test="${account.isAdmin == 1 }">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Admin</a></li>
				</c:if>
				<c:if test="${account.isSell == 1 }">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="seller">Seller</a></li>
				</c:if>
			</ul>
			<form action="search" method="post" class="d-flex" role="search">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search" name="txt" value="${searchValue}">
				<button class="btn btn-outline-success" type="submit">Search</button>
				<c:if test="${account == null }">
					<a class="btn btn-primary" style="white-space: nowrap;"
						href="signIn.jsp">Sign in</a>
				</c:if>
				<c:if test="${account != null }">
					<div class="form-control ml-1">
						<!-- Dropdown -->
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item dropdown dropstart"><a
								class="nav-link dropdown-toggle" href="#" role="button"
								data-bs-toggle="dropdown" aria-expanded="false">${account.username }'s
									account</a>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item" href="#">My cart</a></li>
									<li><a class="dropdown-item" href="#">Notification</a></li>
									<li><a class="dropdown-item" href="changeInfo.jsp">Info</a></li>
									<li><a class="dropdown-item" href="changePassword.jsp">Change
											password</a></li>
									<li><hr class="dropdown-divider"></li>
									<li><a class="dropdown-item"
										href="account-controller?act=sign-out&">Sign out</a></li>
								</ul></li>
						</ul>
					</div>
				</c:if>
			</form>
		</div>
	</div>
</nav>
<!-- End Narvar -->