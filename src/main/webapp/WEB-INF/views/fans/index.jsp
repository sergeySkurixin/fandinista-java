<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Fans</title>
    </head>
    <body>
    <a href="<c:url value="/fans/new"/>">New fan</a>
        <ul>
            <c:forEach items="${fans}" var="fan">
                <li>
                    <a href="<c:url value="/fans/${fan.id}"/>">${fan.name}</a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
