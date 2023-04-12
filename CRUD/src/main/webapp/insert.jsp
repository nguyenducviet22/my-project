<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert new products</title>
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
		<h1>Insert form</h1>
		<div class="text-center">
			<span class="red">${error }</span>
		</div>
		<form action="insert" method="post">
			<table>
				<tr>
					<td>Name product</td>
					<td><input type="text" name="name" value="${name }" /></td>
				</tr>
				<tr>
					<td>Image product</td>
					<td><input type="text" name="image" value="${image }" /></td>
				</tr>
				<tr>
					<td>Price product</td>
					<td><input type="text" name="price" value="${price }" /></td>
				</tr>
				<tr>
					<td>Amount product</td>
					<td><input type="text" name="amount" value="${amount }" /></td>
				</tr>
				<tr>
					<td>Description product</td>
					<td><textarea name="description"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit" value="Submit"
							class="btn btn-primary" id="submit" name="submit">Submit</button>
						<button type="reset" value="Reset" class="btn btn-primary"
							id="reset" name="reset">Reset</button> <a
						href="home" class="btn btn-primary">Back home</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>