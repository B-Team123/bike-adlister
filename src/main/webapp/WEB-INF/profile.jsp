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
			<h2>Welcome, <c:out value="${sessionScope.user.username}" /> User!</h2>
			<div class="user-avatar">
				<label class="profile-pic-upload" type="submit">
					<div class="avatar-wrapper">
						<i class="fa-thin fa-user fa-2xl"></i>
					</div>
					</label>
				<div class="upload-remove-btn"><i class="fa-regular fa-pen-to-square"></i></div>
			</div>
			<div class="user-details">
				<div class="details-wrap">
					<h3>Member Since: </h3>
				</div>
				<div class="details-wrap">
					<h3>Username: ${username}</h3>
				</div>
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
		<main>

		</main>
	</div>
</div>
<script src="//static.filestackapi.com/filestack-js/3.x.x/filestack.min.js"></script>
<script type="module" src="../js/script.js"></script>
</body>
</html>
