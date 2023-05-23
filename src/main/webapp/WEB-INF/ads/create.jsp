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
				<option value="1" name="Mountain">Mountain</option>
				<option value="2">Road</option>
				<option value="3">Hybrid</option>
				<option value="4">Electric</option>
				<option value="5">Folding</option>
			</select>
		</div>
		<div class="form-group">
			<label for="size">Size</label>
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
			<label for="price">Price</label>
			<input id="price" name="price" class="form-control" type="text">
		</div>
		<div class="ad-photo-wrapper">
			<span>Click To Enter Your Photos</span>
			<label class='ad-upload' type="submit">
				<div class="ad-thumbnail-display"></div>
			</label>
		</div>
		<input type="submit" class="btn btn-block btn-primary">
	</form>
</div>
<script src="//static.filestackapi.com/filestack-js/3.x.x/filestack.min.js"></script>
<script type="module" src="../../js/create-ad-script.js"></script>
</body>
</html>
<%--        Bike feature options: Bar Type, Brake Types, Bell        --%>

<%--        <div class="form-group">--%>
<%--            <label for="bars">Bike Features</label><br>--%>
<%--                <label for="bars" id="bars">Bar Type</label><br>--%>
<%--                <input type="radio" id="drop" name="bars" value="drop">--%>
<%--                <label for="drop">Drop Bar</label><br>--%>

<%--                <input type="radio" id="flat" name="bars" value="flat">--%>
<%--                <label for="flat">Flat Bar</label><br>--%>

<%--                <input type="radio" id="riser" name="bars" value="riser">--%>
<%--                <label for="riser">Riser Bar</label><br>--%>

<%--                <input type="radio" id="bullhorn" name="bars" value="bullhorn">--%>
<%--                <label for="bullhorn">Bullhorn Bar</label><br>--%>

<%--                <input type="radio" id="ape" name="bars" value="ape">--%>
<%--                <label for="ape">Ape Hanger Bar</label><br>--%>

<%--                <label for="brake-type" id="brake-type">Brake Type</label><br>--%>

<%--                <input type="radio" id="disc" name="brakes-type" value="disc">--%>
<%--                <label for="disc">Disc</label><br>--%>

<%--                <input type="radio" id="rim" name="brakes-type" value="rim">--%>
<%--                <label for="rim">Rim</label><br>--%>

<%--                <input type="radio" id="v-brake" name="brakes-typ" value="v-brake">--%>
<%--                <label for="v-brake">V-Brake</label><br>--%>

<%--                <label for="bell">Bell</label><br>--%>
<%--                <input type="radio" id="bell" name="bell" value="bell">--%>
<%--                <label for="bell">Bell</label><br>--%>
