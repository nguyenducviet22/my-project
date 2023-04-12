<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Product</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- Product -->
			<div id="content" class="row">
					<div class="col-lg-4 col-md-6 md-4">
						<div class="card h-100" style="width: 18rem;">
							<img src="${detail.image }" style="width: 50%" class="card-img-top" alt="${detail.name }">
							<div class="card-body">
								<h5 class="card-title">
									<a href="detail?pid=${p.id}">${detail.name }</a>
								</h5>
								<p class="card-text">${detail.price }</p>
								<p class="card-text">${detail.amount }</p>
								<p class="card-text">${detail.description }</p>
							</div>
						</div>
					</div>
			</div>
			<!-- End Product -->
		</div>
	</div>
</body>
</html>