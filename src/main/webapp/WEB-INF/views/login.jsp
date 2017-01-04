<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
        <spring:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" var="bootstrapCss"/>
        <link rel="stylesheet" href="${bootstrapCss}"/>
    </head>
    <body>
        <div class="container">
            <c:url value="/j_spring_security_check" var="loginUrl"/>
            <form action="${loginUrl}" method="post">
                <h2>Please sign in</h2>
                <input type="text" class="form-control" name="j_username" placeholder="Email address">
                <input type="password" class="form-control" name="j_password" placeholder="Password">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
            </form>
        </div>
    </body>
</html>
