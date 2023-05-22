<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="partials/head.jsp">
		<jsp:param name="title" value="Create Your Account!" />
	</jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<form class="container">

    <h1>Please fill in your information.</h1>
    <form action="/register" method="post">
    <div>
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" value="${param.username}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="text">
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
            <input id="phone_number" name="phone_number" class="form-control" type="text">
        </div>
        <label for="type">Favorite Bike Type</label>
      <select id="type" name="type" class="form-control">
    <option value="0" name="blank" ${param.type == '0' ? 'selected' : ''}></option>
    <option value="1" name="Mountain" ${param.type == '1' ? 'selected' : ''}>Mountain</option>
    <option value="2" name="Road" ${param.type == '2' ? 'selected' : ''}>Road</option>
    <option value="3" name="Hybrid" ${param.type == '3' ? 'selected' : ''}>Hybrid</option>
    <option value="4" name="Electric" ${param.type == '4' ? 'selected' : ''}>Electric</option>
    <option value="5" name="Folding" ${param.type == '5' ? 'selected' : ''}>Folding</option>
    </select>
    <input type="submit" class="btn btn-primary btn-block">
    </div>
    </form>
</form>
<div class="form-group">
<span>Already registered? <a href="/login" style="color: cornflowerblue">Log in now!</a></span>
</div>
</body>
</html>