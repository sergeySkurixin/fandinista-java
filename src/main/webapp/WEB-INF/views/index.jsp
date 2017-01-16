<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Fandinista</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">

        <spring:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" var="bootstrapCss"/>
        <link rel="stylesheet" href="${bootstrapCss}"/>
    </head>

    <body>
        <nav class="navbar navbar-light bg-faded">
            <a class="navbar-brand" href="<c:url value="/"/>">Fandinista</a>
            <form class="form-inline float-xs-right">
                <ul class="nav navbar-nav">
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/logout"/>" role="button">Logout</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="modal" href="#login-modal">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="modal" href="#signup-modal">Signup</a>
                        </li>
                    </sec:authorize>
                </ul>
            </form>
        </nav>

        <ul>
            <li><a href="<c:url value="/fans"/>">Fans</a></li>
            <li><a href="<c:url value="/musicians"/>">Musicians</a></li>
            <li><a href="<c:url value="/places"/>">Places</a></li>
        </ul>

        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="login-modal-title">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="login-modal-title">Please log in</h4>
                    </div>
                    <div class="modal-body">
                        <div class="container">
                            <c:url value="/j_spring_security_check" var="loginUrl"/>
                            <form action="${loginUrl}" method="post">
                                <input type="text" class="form-control" name="j_username" placeholder="Email address">
                                <input type="password" class="form-control" name="j_password" placeholder="Password">
                                <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="signup-modal" tabindex="-1" role="dialog" aria-labelledby="signup-modal-title">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="signup-modal-title">Sign up</h4>
                    </div>
                    <div class="modal-body">
                        <div>
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#fan" role="tab">Fan</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#musician" role="tab">Musician</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#stage" role="tab">Stage</a>
                                </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="fan" role="tabpanel">
                                    <form action="<c:url value="/fans"/>" method="post">
                                        <input name="name" type="text" placeholder="Name"><br/>
                                        <input name="email" type="text" placeholder="Email"><br/>
                                        <input name="password" type="password" placeholder="Password"><br/>
                                        <input type="submit" value="Save">
                                    </form>

                                    <%-- todo: validation errors binding --%>
                                    <%--<form:form modelAttribute="fan" method="post">--%>
                                        <%--<form:input path="name" type="text" placeholder="Name"/>--%>
                                        <%--<form:errors path="name"/>--%>
                                        <%--<form:input path="email" type="text" placeholder="Email"/>--%>
                                        <%--<form:errors path="email"/>--%>
                                        <%--<form:input path="password" type="password" placeholder="Password"/>--%>
                                        <%--<input type="submit" value="Save">--%>
                                    <%--</form:form>--%>

                                </div>
                                <div class="tab-pane" id="musician" role="tabpanel">
                                    <form action="<c:url value="/musicians"/>" method="post">
                                        <input name="name" type="text" placeholder="Name"><br/>
                                        <input name="email" type="text" placeholder="Email"><br/>
                                        <input name="password" type="password" placeholder="Password"><br/>
                                        <input type="submit" value="Save">
                                    </form>
                                </div>
                                <div class="tab-pane" id="stage" role="tabpanel">
                                    <form action="<c:url value="/places"/>" method="post">
                                        <input name="name" type="text" placeholder="Name"><br/>
                                        <input name="email" type="text" placeholder="Email"><br/>
                                        <input name="password" type="password" placeholder="Password"><br/>
                                        <input type="submit" value="Save">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <spring:url value="/resources/images/rhcp-hyde-park.jpg" var="mainImage"/>
        <img src="${mainImage}">
    </body>

    <spring:url value="/resources/bower_components/jquery/dist/jquery.min.js" var="jqueryJs"/>
    <spring:url value="/resources/bower_components/bootstrap/js/dist/util.js" var="utilJs"/>
    <spring:url value="/resources/bower_components/bootstrap/js/dist/modal.js" var="modalJs"/>
    <spring:url value="/resources/bower_components/bootstrap/js/dist/tab.js" var="tabJs"/>
    <script src="${jqueryJs}"></script>
    <script src="${utilJs}"></script>
    <script src="${modalJs}"></script>
    <script src="${tabJs}"></script>
</html>
