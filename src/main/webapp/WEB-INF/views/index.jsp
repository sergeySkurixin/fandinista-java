<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Fandinista</title>
        <spring:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" var="bootstrapCss"/>
        <link rel="stylesheet" href="${bootstrapCss}"/>
    </head>

    <body>
        <nav class="navbar navbar-light bg-faded">
            <a class="navbar-brand" href="">Fandinista</a>
            <form class="form-inline float-xs-right">
                <ul class="nav navbar-nav">
                    <li class="nav-item"></li>
                </ul>
            </form>
        </nav>
    </body>

    <spring:url value="/resources/bower_components/jquery/dist/jquery.min.js" var="jquery"/>
    <script src="${jquery}"></script>
</html>
