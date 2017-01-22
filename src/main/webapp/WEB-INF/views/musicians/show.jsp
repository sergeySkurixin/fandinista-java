<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Musician</title>
    </head>
    <body>
        <h1>${musician.name}</h1>
        <h2>Рейтинг: ${musician.rating}</h2>
        <c:choose>
            <c:when test="${not empty musician.avatar}">
                <img src="/img/${musician.avatar}" alt="${musician.name}">
            </c:when>
            <c:otherwise>
                <img src="/img/deactivated_200.gif" alt="${musician.name}">
            </c:otherwise>
        </c:choose>
        <form action="/musicians/${musician.id}/change-img" method="post" enctype="multipart/form-data">
            <input type="file" name="avatar" aria-describedby="fileHelp"><br/>
            <button type="submit">Send</button>
        </form>
        <br>
        <%--<a href="<c:url value="/musicians/${musician.id}/edit"/>">Edit musician</a>--%>
        <a href="<c:url value="/musicians/${musician.id}/follow"/>">Follow</a>
    </body>
</html>
