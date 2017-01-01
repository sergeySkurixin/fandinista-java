<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Fans</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${places}" var="place">
                <li><a href="<c:url value="/places/${place.id}"/>">${place.name}</a></li>
            </c:forEach>
        </ul>
        <a href="<c:url value="/places/new"/>">New place</a>
    </body>
</html>
