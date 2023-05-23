<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Edit ad # ${edit_ad.id}</h1>
    <form action="/ads/edit" method="post">
        <input type="hidden" name="id" value="${edit_ad.id}">
        <div class="form-group">
            <label for="title">Name</label>
            <input id="title" name="title" class="form-control" type="text" value="${edit_ad.title}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text">${edit_ad.description}</textarea>
        </div>
        <div class="form-group">
            <label for="type">Type</label>
            <select id="type" name="type" class="form-control" >
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
            <input id="price" name="price" class="form-control" type="text" value="${edit_ad.price}">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>