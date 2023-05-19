<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="partials/head.jsp">
		<jsp:param name="title" value="Create Your Account!" />
	</jsp:include>
	<link rel="stylesheet" href="../styles/register.css">
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
	<h1>Create Your Account</h1>
	<form action="/register" method="post">
		<div class="form-group">
			<label for="username">Username</label>
			<input id="username" name="username" class="form-control" type="text" required>
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			<input id="email" name="email" class="form-control" type="text" required>
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<input id="password" name="password" class="form-control" type="password">
		</div>
		<div class="form-group">
			<label for="confirm_password">Confirm Password</label>
			<input id="confirm_password" name="confirm_password" class="form-control" type="password">
		</div>
		<div class="form-group">
			<label for="phone_number">Enter your phone number</label>
			<input id="phone_number" name="phone_number" class="form-control" type="text" placeholder="Format: xxxxxxxxxx">
		</div>
	</form>
	<input style="margin: 30px 0 10px 0;" type="submit" class="btn btn-primary btn-block form-submit">
	<span>Already registered? <a href="/login">Log in now!</a></span>
</div>
</body>
</html>