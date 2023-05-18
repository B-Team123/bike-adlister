<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <c:if test="${sessionScope.user == null}">
            <jsp:forward page="/login" />
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

</body>
</html>
