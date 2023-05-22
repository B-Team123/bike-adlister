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
	<jsp:include page="partials/profile-edit-form.jsp">
		<jsp:param name="visible" value="hidden" />
	</jsp:include>
	<div class="page-wrapper">
		<section class="user-data">
			<h2>Welcome, <c:out value="${sessionScope.user.username}" /></h2>
			<div class="user-avatar">
					<input id="hidden-input" type="hidden" name="photo" />
				<img class="avatar" src="${avatar_url}" alt="">
			</div>
			<button class="edit-btn btn btn-primary btn-block">Edit</button>
			<div class="user-details">
				<div class="details-wrap">
					<h3>Email: ${email}</h3>
				</div>
				<div class="details-wrap">
					<h3>Phone Number: ${phoneNumber}</h3>
				</div>
				<div class="details-wrap">
					<h3>City, State: ${city}, ${state}</h3>
				</div>
				<div class="details-wrap">
					<h3>Totals Ads: </h3>
				</div>
			</div>
		</section>
		<main class="user-ads-container">
            <a href="/ads/create" class="btn btn-primary">Create new ad</a>
		</main>
	</div>
</div>
<script src="//static.filestackapi.com/filestack-js/3.x.x/filestack.min.js"></script>
<script type="module" src="../js/profile-script.js"></script>
</body>
</html>
