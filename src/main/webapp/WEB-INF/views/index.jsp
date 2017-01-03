<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Fandinista</title>
        <spring:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" var="bootstrapCss"/>
        <link rel="stylesheet" href="${bootstrapCss}"/>
    </head>

    <body>
        <nav class="navbar navbar-light bg-faded">
            <a class="navbar-brand" href="<c:url value="/"/>">Fandinista</a>
            <form class="form-inline float-xs-right">
                <ul class="nav navbar-nav">
                    <li class="nav-item"></li>
                </ul>
            </form>
        </nav>
        <ul>
            <li><a href="<c:url value="/fans"/>">Fans</a></li>
            <li><a href="<c:url value="/musicians"/>">Musicians</a></li>
            <li><a href="<c:url value="/places"/>">Places</a></li>
        </ul>
    </body>

    <spring:url value="/resources/bower_components/jquery/dist/jquery.min.js" var="jquery"/>
    <script src="${jquery}"></script>
</html>
