<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="partials/head.jsp">
		<jsp:param name="title" value="Create Your Account!" />
	</jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">

    <h1>Please fill in your information.</h1>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" value="${param.username}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="text" value="${param.email}">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password" value="${param.password}">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password" value="${param.passwordConfirmation}">
        </div>
        <div class="form-group">
            <label for="phone_number">Enter your phone number</label>
            <input id="phone_number" name="phone_number" class="form-control" type="text" value="${param.number}">
        </div>
        <div class="form-group">
            <label for="address">Enter your street address</label>
            <input id="address" name="address" class="form-control" type="text" value="${param.address}">
        </div>
        <div class="form-group">
            <label for="city">Enter your city</label>
            <input id="city" name="city" class="form-control" type="text" value="${param.city}">
        </div>
<%--        create select for all states--%>
        <div class="form-group">
            <label for="state">Enter your state</label>
            <select id="state" name="state" class="form-control" type="text" value="${param.state}">
                <option value="AL">Alabama</option>
                <option value="AK">Alaska</option>
                <option value="AZ">Arizona</option>
                <option value="AR">Arkansas</option>
                <option value="CA">California</option>
                <option value="CO">Colorado</option>
                <option value="CT">Connecticut</option>
                <option value="DE">Delaware</option>
                <option value="FL">Florida</option>
                <option value="GA">Georgia</option>
                <option value="HI">Hawaii</option>
                <option value="ID">Idaho</option>
                <option value="IL">Illinois</option>
                <option value="IN">Indiana</option>
                <option value="IA">Iowa</option>
                <option value="KS">Kansas</option>
                <option value="KY">Kentucky</option>
                <option value="LA">Louisiana</option>
                <option value="ME">Maine</option>
                <option value="MD">Maryland</option>
                <option value="MA">Massachusetts</option>
                <option value="MI">Michigan</option>
                <option value="MN">Minnesota</option>
                <option value="MS">Mississippi</option>
                <option value="MO">Missouri</option>
                <option value="MT">Montana</option>
                <option value="NE">Nebraska</option>
                <option value="NV">Nevada</option>
                <option value="NH">New Hampshire</option>
                <option value="NJ">New Jersey</option>
                <option value="NM">New Mexico</option>
                <option value="NY">New York</option>
                <option value="NC">North Carolina</option>
                <option value="ND">North Dakota</option>
                <option value="OH">Ohio</option>
                <option value="OK">Oklahoma</option>
                <option value="OR">Oregon</option>
                <option value="PA">Pennsylvania</option>
                <option value="RI">Rhode Island</option>
                <option value="SC">South Carolina</option>
                <option value="SD">South Dakota</option>
                <option value="TN">Tennessee</option>
                <option value="TX">Texas</option>
                <option value="UT">Utah</option>
                <option value="VT">Vermont</option>
                <option value="VA">Virginia</option>
                <option value="WA">Washington</option>
                <option value="WV">West Virginia</option>
                <option value="WI">Wisconsin</option>
                <option value="WY">Wyoming</option>
            </select>
        </div>
        <div class="form-group">
            <label for="zip_code">Enter your zip code</label>
            <input id="zip_code" name="zip_code" class="form-control" type="text" value="${param.zip}">
        </div>

    <input type="submit" class="btn btn-primary btn-block">
    <span>Already registered? <a href="/login" style="color: cornflowerblue">Log in now!</a></span>
    </form>
    </div>
</body>
</html>