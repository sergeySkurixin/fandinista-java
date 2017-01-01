<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Musicians</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${musicians}" var="musician">
                <li><a href="<c:url value="/musicians/${musician.id}"/>">${musician.name}</a></li>
            </c:forEach>
        </ul>
        <a href="<c:url value="/musicians/new"/>">New musician</a>
    </body>
</html>
