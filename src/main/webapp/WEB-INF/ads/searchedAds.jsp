<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Viewing All The Ads" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
  <h1>Here are searched ads!</h1>
  <c:forEach var="ad" items="${searchResults}">

  <div class="col-md-6">
    <h2>${ad.title}</h2>
    <p>${ad.description}</p>
    <c:if test="${userId == ad.getUserId()}">
      <a href="/ads/${ad.id}/edit">Edit</a>
      <form action="/ads" method="post">
        <button name="adToDelete" type="submit" value="${ad.id}">DELETE</button>
      </form>
    </c:if>

    <div class="card" style="width: 18rem;">
      <img class="card-img-top" src="https://via.placeholder.com/500" alt="Card image cap">
      <div class="card-body">
        <h5 class="card-title">${ad.title}</h5>
        <p class="card-text">Description: ${ad.description}</p>
        <p class="card-text">Price: ${ad.price}$</p>
        <p class="card-text">Bike Type: ${ad.type}</p>
        <p class="card-text">Bike Size: ${ad.size}</p>

        <a href="#" class="btn btn-primary">View ad</a>
      </div>

    </div>
    </c:forEach>
  </div>
</body>
</html>
