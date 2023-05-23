<link rel="stylesheet" href="../../styles/navbar.css">
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <h2><a class="navbar-brand" href="/">Adlister</a></h2>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <form action="/ads" method="POST" class="navbar-form">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2 text-center">
                        <input name="search" placeholder="Search Ads" type="search" class="form-control" />
                    </div>
                    <div class="col-xs-2">
                        <button type="button" class="btn btn-primary">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
        </ul>
        <ul class="nav navbar-nav navbar-right">

            <% if (request.getSession().getAttribute("user") == null) { %>
            <li><a href="/login">Login</a></li>
            <li style="display: none;"><a href="/logout">Logout</a></li>
            <li style="display: none;"> <a href="/ads/create">Create An Ad</a></li>
            <li style="display: none;"><a href="/ads">View All Ads</a></li>
            <% } else { %>
<%--            <li><a href="/profile">View profile</a></li>--%>
            <li style="display: none;"><a href="/login">Login</a></li>
            <li><a href="/ads/create">Create An Ad</a></li>
            <li><a href="/ads">View All Ads</a></li>
            <li><a href="/profile">Profile</a></li>
            <li><a href="/logout">Logout</a></li>
            <% } %>

<%--            <li><a href="/profile">Profile</a></li>--%>
<%--            <li><a href="/ads/create">Create ad</a></li>--%>
<%--            <li><a href="/profile">View profile</a></li>--%>
<%--            <li><a href="/register">Create An Account</a></li>--%>
<%--            <% if (request.getSession().getAttribute("user") == null) { %>--%>
<%--            <li><a href="/login">Login</a></li>--%>
<%--            <% } else { %>--%>
<%--            <li style="display: none;"><a href="/login">Login</a></li>--%>
<%--            <% } %>--%>
<%--            <li><a href="/login">Login</a></li>--%>
<%--            <li><a href="/logout">Logout</a></li>--%>
<%--            <li><a href="/ads">View All Ads</a></li>--%>
<%--            <li><a href="/profile">Profile</a></li>--%>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
