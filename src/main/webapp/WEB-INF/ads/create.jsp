<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
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
            <label for="size">size</label>
            <select id="size" name="size" class="form-control">
                <%--        bike sizes informative options tags       --%>
                <option value="0" name="blank"></option>
                <option value="1" name="Child">Child</option>
                <option value="2">Small</option>
                <option value="3">Medium</option>
                <option value="4">Large</option>
                <option value="5">XL</option>
            </select>
        </div>
        <div class="form-group">
            <%--@declare id="features"--%>
            <%--@declare id="bars"--%>
                <label for="bars">Bar Type</label><br>
                <input type="radio" id="drop" name="bar-type" value="drop">
                <label for="drop">Drop Bar</label><br>

                <input type="radio" id="flat" name="bar-type" value="flat">
                <label for="flat">Flat Bar</label><br>

                <input type="radio" id="riser" name="bar-type" value="riser">
                <label for="riser">Riser Bar</label><br>

                <input type="radio" id="bullhorn" name="bar-type" value="bullhorn">
                <label for="bullhorn">Bullhorn Bar</label><br>

                <input type="radio" id="ape" name="bar-type" value="ape">
                <label for="ape">Ape Hanger Bar</label><br>

                <label for="brake-type" id="brake-type">Brake Type</label><br>

                <input type="radio" id="disc" name="brake-type" value="disc">
                <label for="disc">Disc</label><br>

                <input type="radio" id="rim" name="brake-type" value="rim">
                <label for="rim">Rim</label><br>

                <input type="radio" id="v-brake" name="brake-type" value="v-brake">
                <label for="v-brake">V-Brake</label><br>

                <label for="bell">Bell</label><br>
                <input type="radio" id="bell" name="bell" value="yes">
                <label for="bell">Yes</label><br>

                <input type="radio" id="no" name="bell" value="no">
                <label for="no">No</label><br>

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