<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/WEB-INF/partials/head.jsp">
		<jsp:param name="title" value="Your Profile" />
	</jsp:include>
	<link rel="stylesheet" href="../styles/profile.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
	<div class="page-wrapper">
		<section class="user-data">
			<h2>Welcome, <c:out value="${sessionScope.user.username}" />!</h2>
			<div class="user-avatar"
					 style="background-image: url(../styles/kimson-doan-HD8KlyWRYYM-unsplash.jpg); background-size: cover; background-position: top center; border-radius: 50%;">
				<label class="profile-pic-upload" type="submit">
					<div class="icon-wrapper">
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512">
							<!--! Font Awesome Pro 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
							<path d="M64 16C37.5 16 16 37.5 16 64V448c0 26.5 21.5 48 48 48H320c26.5 0 48-21.5 48-48V64c0-26.5-21.5-48-48-48H64zM0 64C0 28.7 28.7 0 64 0H320c35.3 0 64 28.7 64 64V448c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V64zM240 192a48 48 0 1 0 -96 0 48 48 0 1 0 96 0zM96 356.6c0 6.3 5.1 11.4 11.4 11.4H276.6c6.3 0 11.4-5.1 11.4-11.4c0-29-23.5-52.6-52.6-52.6H148.6c-29 0-52.6 23.5-52.6 52.6zM192 128a64 64 0 1 1 0 128 64 64 0 1 1 0-128zM148.6 288h86.9c37.9 0 68.6 30.7 68.6 68.6c0 15.1-12.3 27.4-27.4 27.4H107.4C92.3 384 80 371.7 80 356.6c0-37.9 30.7-68.6 68.6-68.6z" />
						</svg>
					</div>
					˝</label>
			</div>
			<div class="user-details">
				<div class="details-wrap">
					<h3>Member Since</h3>
				</div>
				<div class="details-wrap">
					<h3>Username</h3>
				</div>
				<div class="details-wrap">
					<h3>Email</h3>
				</div>
				<div class="details-wrap">
					<h3>Phone Number</h3>
				</div>
				<div class="details-wrap">
					<h3>City / State</h3>
				</div>
				<div class="details-wrap">
					<h3>No. of Ads</h3>
				</div>
			</div>
		</section>
		<main>

		</main>
	</div>
</div>

</body>
</html>
