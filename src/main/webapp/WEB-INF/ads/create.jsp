<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/partials/head.jsp">
		<jsp:param name="title" value="Create a new Ad" />
	</jsp:include>
	<link rel="stylesheet" href="../../styles/create.css">
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />
<div class="container">
    <h1>Create a new Bike Ad</h1>
    <form action="/ads/create" method="post">
        <div class="form-group">
            <label for="title">Name</label>
            <input id="title" name="title" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <label for="type">Type</label>
            <select id="type" name="type" class="form-control">
                <%--        bike types informative options tags       --%>
                <option value="0" name="blank"></option>
                <option value="Mountain" name="Mountain">Mountain</option>
                <option value="Road">Road</option>
                <option value="Hybrid">Hybrid</option>
                <option value="Electric">Electric</option>
                <option value="Folding">Folding</option>
            </select>
        </div>
        <div class="form-group">
            <label for="size">size</label>
            <select id="size" name="size" class="form-control">
                <%--        bike sizes informative options tags       --%>
                <option value="0"></option>
                <option value="Child">Child</option>
                <option value="Small">Small</option>
                <option value="Medium">Medium</option>
                <option value="Large">Large</option>
                <option value="XL">XL</option>
            </select>
        </div>
        <div class="form-group">
            <label for="description">Price</label>
            <input id="price" name="price" class="form-control" type="text">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
